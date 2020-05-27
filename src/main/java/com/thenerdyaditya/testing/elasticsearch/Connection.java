package com.thenerdyaditya.testing.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class Connection {
    protected static final String HOST = "localhost";
    protected static final int PORT_ONE = 9200;
    protected static final int PORT_TWO = 9201;
    protected static final String SCHEME = "http";

    protected static RestHighLevelClient restHighLevelClient;

    //singleton design pattern
    public static synchronized RestHighLevelClient makeConnection(){
        if(restHighLevelClient == null){
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(HOST, PORT_ONE, SCHEME),
                            new HttpHost(HOST, PORT_TWO, SCHEME)
                    )
            );
        }
        return  restHighLevelClient;
    }

    public static synchronized void closeConnection() throws IOException{
        restHighLevelClient.close();
        restHighLevelClient = null;
    }
}
