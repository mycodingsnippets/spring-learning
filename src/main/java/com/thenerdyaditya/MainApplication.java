package com.thenerdyaditya;

import com.thenerdyaditya.testing.Models.Person;
import com.thenerdyaditya.testing.elasticsearch.Connection;
import com.thenerdyaditya.testing.elasticsearch.QueryData;
import com.thenerdyaditya.testing.filehandling.ReadingFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Value("${my-name}")
    private String testVar;

    private static final Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }


    public void esTesting(){
//        Connection.makeConnection();

//        System.out.println("Inserting a person with name Aditya");
//        Person person = new Person();
//        person.setName("Aditya");
//        person = QueryData.insertPerson(person);
//        logger.info("Person Inserted ---> {}", person);

//        System.out.println("Changing name to Aditya Bansal");
//        Person person = new Person();
//        person.setName("Aditya Bansal");
//        QueryData.updatePersonById("8aeabb4b-a9fe-47c8-9fcb-b9b94ac8dd5f", person);
//        logger.info("Person updated --> {}", person);

//        System.out.println("Getting Aditya..");
//        Person personFromDB = QueryData.getPersonById("8aeabb4b-a9fe-47c8-9fcb-b9b94ac8dd5f");
//        logger.info("Person from DB -> {}", personFromDB);

//        System.out.println("Deleting Data");
//        QueryData.deletePersonById("0ced469b-6cc4-44d3-b684-64491a5e25f9");
//        logger.info("Person Deleted ");

//        Connection.closeConnection();
    }

    public void parameterTesting(){
        System.out.println(testVar);
    }
}
