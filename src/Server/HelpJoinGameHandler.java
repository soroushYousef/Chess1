package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HelpJoinGameHandler implements Runnable{

    Socket helpJoinGameSocket;
    DataInputStream dis ;
    DataOutputStream dos;

    private boolean isAccepted = false;

    public HelpJoinGameHandler(Socket socket){
        helpJoinGameSocket = socket;
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
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
/*
                    if (answer.contains("accept")) {

                        Server.getHandler(array[1], Server.helpJoinGameHandlerMap).dos.writeUTF(answer);

                    }
*/
                    //else if(answer.contains("isAccepted")){
                    ///    Server.getHandler(array[1])
                    //  }

                }
            }
            catch (IOException e){


        }


    }
    public boolean getIsAccepted(){
        return isAccepted;
    }

}
