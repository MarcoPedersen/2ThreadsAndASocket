package com.company;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient2 {
    public static void main(String[] args) throws Exception {
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
            System.out.println(e);
        }
    }
}