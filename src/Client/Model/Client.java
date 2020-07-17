package Client.Model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Application {

    static Socket userSocket;
    static Socket gameSocket;
    static Socket joinGameSocket;
    static Socket helpJoinGameSocket;
    static Socket chatSocktet;

    public static DataOutputStream userOut;
    public static DataInputStream userIn;

    public static DataOutputStream joinGameOut;
    public static DataInputStream joinGameIn;

    public static DataOutputStream helpJoinGameOut;
    public static DataInputStream helpJoinGameIn;



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
            Client.helpJoinGameSocket = new Socket("localhost",9002);
            helpJoinGameIn = new DataInputStream(helpJoinGameSocket.getInputStream());
            helpJoinGameOut = new DataOutputStream(helpJoinGameSocket.getOutputStream());





        } catch (IOException e) {
            e.printStackTrace();
        }

        //launch args
        launch(args);




    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PageLoader.initStage(primaryStage);
        new PageLoader().load("../View/SignUpPage.fxml");
    }
}
