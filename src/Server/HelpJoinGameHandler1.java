package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HelpJoinGameHandler1 implements Runnable{
    Socket helpJoinGameSocket1;
    DataInputStream dis ;
    DataOutputStream dos;

    public HelpJoinGameHandler1(Socket socket){
        helpJoinGameSocket1 = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
       while (true){

       }
    }
}
