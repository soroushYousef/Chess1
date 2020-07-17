package Server;

import Common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;

public class UserHandler implements Runnable{

    private Socket userSocket;
    private DataOutputStream dos;
    private DataInputStream dis;
    private User user;

    public UserHandler(Socket socket){
        this.userSocket = socket;
        try {
            this.dis = new DataInputStream(userSocket.getInputStream());
            this.dos = new DataOutputStream(userSocket.getOutputStream());

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

                //add kardan user jadaid
                if (answer.contains("New")) {
                    userAdder(array[2], array[3]);
                }



                //login kardan user
                else if(answer.contains("login")){
                     User temp = new User(array[1],array[2]);
                     if(Server.users.containsValue(temp)){
                         setUser(temp);
                         dos.writeUTF("good");
                     }
                     else {
                         dos.writeUTF("bad");
                     }
                 }

                 //taghir password
                else if(answer.contains("change")){
                    user.setPassword(array[1]);
                }

                //hazf account
                else if(answer.contains("delete")){
                    Server.users.remove(user.getUserName());
                    user = null;
                }

                else if(answer.contains("logout")){
                    user = null;
                }





            }
        }
            catch (IOException e) {
            e.printStackTrace();
        }


    }



    public void setUser(User user){
        this.user=user;
    }
    public User getUser(){
        return user;
    }



    public void userAdder(String userName,String password){
        try {
            if (Server.users.containsKey(userName)) {
                dos.writeUTF("bad");
            }
            else {
                Server.users.put(userName,new User(userName,password));
                dos.writeUTF("good");
            }
        }
        catch (IOException e) {
                e.printStackTrace();
            }

    }



}
