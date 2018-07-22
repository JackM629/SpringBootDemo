/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swapi.control;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jack Martin
 * 
 */

public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // Variable declarations
        boolean databaseValid = false;
        Scanner scan = new Scanner(System.in);
        String database = "";
        
        // Gets user input for database name
        while (databaseValid == false) {
            System.out.println("Enter star wars database to retrieve data from (films, people, starships, planets, vehicles, species)");
            database = scan.next();
            if ("films".equals(database) || "people".equals(database) || "starships".equals(database) || "planets".equals(database) || "vehicles".equals(database) || "species".equals(database)) {
                databaseValid = true;
            }
            else {
                System.out.println("Entry invalid");
            }
        }
        
        // Gets user input for database resource number
        System.out.println("Enter resource number");
        String resourceNum = scan.next();
        
        // Requests data row from swapi.co
        System.out.println("Sending GET request to https://swapi.co/api/" + database + "/" + resourceNum + "/");
        try {
            ConnectionController.sendGetRequest("https://swapi.co/api/" + database + "/" + resourceNum + "/");
        }
        catch (IOException e) {
            System.out.println("Data not found");
        }
        
    }
    
}
