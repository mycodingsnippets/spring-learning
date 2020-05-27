package com.thenerdyaditya.testing.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thenerdyaditya.testing.Models.Person;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class QueryData {

    private static final String INDEX = "persondata";
    private static final String TYPE = "person";
    private static ObjectMapper objectMapper = new ObjectMapper();


    public static Person insertPerson(Person person) {

        person.setPersonId(UUID.randomUUID().toString());

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("personId", person.getPersonId());
        dataMap.put("name", person.getName());

        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, person.getPersonId()).source(dataMap);

        try{
            IndexResponse response = Connection.restHighLevelClient.index(indexRequest);
        }catch (ElasticsearchException e){
            e.getDetailedMessage();
        }catch (java.io.IOException ex){
            ex.getLocalizedMessage();
        }

        return person;

    }

    public static Person getPersonById(String id){
        GetRequest getPersonRequest = new GetRequest(INDEX, TYPE, id);

        GetResponse getResponse = null;
        try{
            getResponse = Connection.restHighLevelClient.get(getPersonRequest);
        }catch (java.io.IOException e){
            e.getLocalizedMessage();
        }

        return getResponse != null ? objectMapper.convertValue(getResponse.getSourceAsMap(), Person.class) : null;
    }

    public static Person updatePersonById(String id, Person person){
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, id).fetchSource(true); //fetch object after its update

        try {
            String personJson = objectMapper.writeValueAsString(person);
            updateRequest.doc(personJson, XContentType.JSON); //we didnt passed any specific property of object instead we passed complete Object Json which will replace every key present

            UpdateResponse updateResponse = Connection.restHighLevelClient.update(updateRequest);
            return objectMapper.convertValue(updateResponse.getGetResult().sourceAsMap(), Person.class);
        } catch (JsonProcessingException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        System.out.println("Unable to update person");
        return null;
    }


    public static void deletePersonById(String id){
        DeleteRequest deleteRequest = new DeleteRequest(INDEX, TYPE, id);

        try {
            DeleteResponse deleteResponse = Connection.restHighLevelClient.delete(deleteRequest);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

}
