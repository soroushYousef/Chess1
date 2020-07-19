package Server.Communication;

import Common.Game;
import Common.TimeMaker;
import Common.User;
import Server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameHandler implements Runnable{
    DataInputStream dis;
    DataOutputStream dos;
    private Socket gameSocket;
    private User user;
    private User targetUser;

    public GameHandler(Socket gameSocket) {
        this.gameSocket = gameSocket;
        try {
            dis = new DataInputStream(gameSocket.getInputStream());
            dos = new DataOutputStream(gameSocket.getOutputStream());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while (true){
                String answer = dis.readUTF();
                String array[] = answer.split("@");

                if(answer.contains("start")){
                    user = Server.users.get(array[1]);
                    targetUser = Server.users.get(array[2]);
                    Server.games.put(TimeMaker.getTime(),new Game(user,targetUser));

                }
                else if(answer.contains("userName")){
                    user = Server.users.get(array[1]);
                    targetUser = Server.users.get(array[2]);
                }
                else if(answer.contains("move")){
                    Server.getGame(user,targetUser).addNumberOfMovments();
                    if(answer.contains("attack")){
                        Server.getGame(user,targetUser).addNumberOfPiecesRemoved();
                    }
                    Server.getHandler(targetUser.getUserName(),Server.gameHandlerMap).dos.writeUTF(array[1]+"@"+array[2]);
                }






            }



        }
        catch (IOException e){

        }
    }
}
