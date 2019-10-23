package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class ServerClientThread extends Thread {
    private Socket serverClient;
    private int clientNo;

    ServerClientThread(Socket inSocket, int counter){
        serverClient = inSocket;
        clientNo=counter;
    }
    public void run(){
        try{
            DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            String clientMessage="", serverMessage="";
            while(!clientMessage.equals("farvel")){
                clientMessage=inStream.readUTF();
                System.out.println("Fra Client-" +clientNo+ ": beskeden er :"+clientMessage);
                serverMessage="Fra Server til Client-" + clientNo + " beskeden er " + clientMessage + " og kommer fra " +clientNo;
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }
            inStream.close();
            outStream.close();
            serverClient.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("Client -" + clientNo + " smutter!! ");
        }
    }
}
