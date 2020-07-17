package Server;

import Common.Request;
import Common.User;


import java.io.*;
import java.net.Socket;

public class JoinGameHandler implements Runnable{

    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket joinGameSocket;
    private Request request;

    public JoinGameHandler(Socket joinGameSocket){
        this.joinGameSocket = joinGameSocket;
        try {
            dis = new DataInputStream(joinGameSocket.getInputStream());
            dos = new DataOutputStream(joinGameSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {



            try {

                while (true) {

                String answer = dis.readUTF();
                String[] array = answer.split("@");

                if (answer.contains("details")) {
                    dos.writeUTF(onlinePlayersNamesMaker());
                }

                else if (answer.contains("send")) {
                    if(Server.getJoinGameHandler((array[1])) == null){
                    dos.writeUTF("bad");
                    }
                        else {
                        Server.getHandler(array[1],Server.helpJoinGameHandlerMap).dos.writeUTF("get@" + array[1]);
                       dos.writeUTF("good");
                      }
                }

            }


        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public String onlinePlayersNamesMaker(){
        String s = " ";
        for(UserHandler userHandler : Server.joinGameHandlers.keySet()){
            if(Server.joinGameHandlers.get(userHandler).equals(this) == false && Server.joinGameHandlers.size()!=1)
                 s += userHandler.getUser().joinGameNameMaker() + "\n";
        }
        return s;
    }
}
