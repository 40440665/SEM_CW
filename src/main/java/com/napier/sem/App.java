package com.napier.sem;

import java.sql.*;

public class App {
    Connection con = null;

    public static void main(String[] args) {
        //Create new application
        App Test = new App();

        //Connect to database
        Test.connect();

        //Disconnect from database
        Test.disconnect();
        }


        //Connect to the database
        public void connect()
        {
            try {
                // Load Database driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            // Connection to the database
            int retries = 100;
            for (int i = 0; i < retries; ++i) {
                System.out.println("Connecting to database...");
                try {
                    // Wait a bit for db to start
                    Thread.sleep(30000);
                    // Connect to database
                    con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                    System.out.println("Successfully connected");
                    // Wait a bit
                    Thread.sleep(10000);
                    // Exit for loop
                    break;
                } catch (SQLException sqle) {
                    System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                    System.out.println(sqle.getMessage());
                } catch (InterruptedException ie) {
                    System.out.println("Thread interrupted? Should not happen.");
                }
            }
        }

        //Disconnect from the database
        public void disconnect()
        {
            if (con != null) {
                try {
                    // Close connection
                    con.close();
                    System.out.println("Dsiconnecting from database");
                } catch (Exception e) {
                    System.out.println("Error closing connection to database");
                }
            }
        }

    }
