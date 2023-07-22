/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpoly.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author HP
 */
public class StudentAPI {
    private static ObjectMapper mapper = new ObjectMapper();
    
    public static JsonNode get(String path){
        return request("GET",path,null);
    }
    
    public static JsonNode post(String path,Object data){
        return request("POST",path,data);
    }
    
    public static JsonNode put(String path,Object data){
        return request("PUT",path,data);
    }
    
    public static void delete(String path){
        request("DELETE",path,null);
    }
    
    private static JsonNode request(String methob, String path, Object data){
        try {
            //1 request
            String uri = "https://ps20520-lab4-java6-default-rtdb.firebaseio.com" +
"" + path + ".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestMethod(methob);
            
            //1.1 Data (POST & PUT only)
            if(methob.equalsIgnoreCase("POST") || methob.equalsIgnoreCase("PUT")){
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(),data);
            }
            
            //2. Response
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
