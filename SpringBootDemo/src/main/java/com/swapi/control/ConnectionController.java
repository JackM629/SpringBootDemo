/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swapi.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Jack Martin
 * 
 */

public class ConnectionController {
    
    private static HttpURLConnection httpConn;
    
    public static void sendGetRequest(String requestURL) throws IOException {
        
        // Establishes connection
        URL url = new URL(requestURL);
        httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        
        // Fetches and displays response code (success or error)
        int responseCode = httpConn.getResponseCode();
        System.out.println(responseCode);
        
        // Fetches reponse from GET request
        BufferedReader in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
        String inputLine;
	StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
	}

        // Closes connection
        in.close();

        // Displays response
	System.out.println(response.toString());
        
    }
    
}
