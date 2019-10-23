package com.company;

import java.io.*;
import java.net.Socket;

public class TCPClient1 {
    public static void main(String[] args) {

        // HEARTBEAT needs to be sent every 1 minute //
        // QUIT to end connection as a command //
        // Tag DATA and USERNAME on any free-text sent to the server //

        try{
            Socket socket=new Socket("127.0.0.1",8888);

            DataInputStream inStream=new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";

            while(!clientMessage.equals("farvel")){
                clientMessage=br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();
                serverMessage=inStream.readUTF();
                System.out.println("Fra Server: "+serverMessage);
            }

            outStream.close();
            outStream.close();
            socket.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}