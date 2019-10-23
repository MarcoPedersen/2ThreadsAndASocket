package com.company;

import java.net.*;
import java.io.*;
public class MultithreadedSocketServer {

    private ServerSocket server = null;

    public MultithreadedSocketServer(int port) {
        try{
            server = new ServerSocket(port);
            int counter=0;
            System.out.println("Server Started ....");

            while(true){
                counter++;
                Socket serverClient=server.accept();  //server accept the client connection request
                System.out.println(" >> " + "Client No:" + counter + " started!");
                ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
                sct.start();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MultithreadedSocketServer multithreadedSocketServer = new MultithreadedSocketServer(8888);
    }
}