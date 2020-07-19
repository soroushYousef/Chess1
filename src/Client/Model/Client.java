package Client.Model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {

    public static volatile boolean isRequestAccepted = false;
    public static String  requestStatue = "c";

    static Socket userSocket;
    static Socket gameSocket;
    static Socket joinGameSocket;
    static Socket helpJoinGameSocket;
    static Socket helpJoinGameSocket1;
    static Socket chatSocktet;

    public static DataOutputStream userOut;
    public static DataInputStream userIn;

    public static DataOutputStream joinGameOut;
    public static DataInputStream joinGameIn;

    public static DataOutputStream gameOut;
    public static DataInputStream gameIn;

    public static DataOutputStream helpJoinGameOut1;
    public static DataInputStream helpJoinGameIn1;




    public static void main(String args[]) {


        try {
            //user socket
            Client.userSocket = new Socket("localhost", 9000);
            userIn = new DataInputStream(userSocket.getInputStream());
            userOut = new DataOutputStream(userSocket.getOutputStream());
            //join game socket
            Client.joinGameSocket = new Socket("localhost",9001);
            joinGameIn = new DataInputStream(joinGameSocket.getInputStream());
            joinGameOut = new DataOutputStream(joinGameSocket.getOutputStream());
            //help join game socket
            //for updating requets

            gameSocket = new Socket("localhost",9002);
            gameIn = new DataInputStream(gameSocket.getInputStream());
            gameOut = new DataOutputStream(gameSocket.getOutputStream());

            /*
            Client.helpJoinGameSocket1 = new Socket("localhost",9003);
            helpJoinGameIn1 = new DataInputStream(helpJoinGameSocket1.getInputStream());
            helpJoinGameOut1 = new DataOutputStream(helpJoinGameSocket1.getOutputStream());
             */







        } catch (IOException e) {
            e.printStackTrace();
        }

        //launch args
        launch(args);
/*
        try {
            System.out.print(helpJoinGameIn1.readUTF());
        } catch (IOException e) {
            e.printStackTrace();

       }

 */


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PageLoader.initStage(primaryStage);
        new PageLoader().load("../View/SignUpPage.fxml");
    }
}
