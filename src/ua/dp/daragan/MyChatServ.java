//use: telnet 127.0.0.1 8080
//write "exit" for close
package ua.dp.daragan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MyChatServ implements ClientsListner{
    private static MyChatServ mcs = null;
    private ArrayList<Clients> clients;
    private LinkedList<String> allMsg;
    private int countOfMsgs = 0;
    private ServerSocket servSock = null;
    

    private MyChatServ() {
        clients = new ArrayList<Clients>();
        allMsg = new LinkedList<String>();
        try{
            servSock = new ServerSocket(8080);
            System.out.println("Server started on port 8080!");
        } catch (IOException e){
            System.err.println(e.getStackTrace());
        }
    }
    
    public static MyChatServ getInstance(){
        if(mcs == null) {
            mcs = new MyChatServ();
        }
        return mcs;
    }
    
    public ServerSocket getServSock (){
        return servSock;
    }

    @Override
    public void addClient(Clients cl) {
        clients.add(cl);
    }

    @Override
    public void delClient(Clients cl) {
        int i = clients.indexOf(cl);
        if(i >=0){
            clients.remove(i);
        }
    }

    @Override
    public void sendToAll() {
        for(int i = 0; i<clients.size(); i++){
            Clients client = clients.get(i);
            client.updateMsgs("test");//to do
        }
    }
    
}
