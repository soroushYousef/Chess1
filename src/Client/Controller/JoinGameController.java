package Client.Controller;

import Client.Model.Client;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ClientInfoStatus;


public class JoinGameController {

    @FXML
    TextArea onlineUsers,requests;
    @FXML
    TextField userName;


    public void initialize(){
        try {
            Client.joinGameOut.writeUTF("details");
            String onlineUsersText = Client.joinGameIn.readUTF();
            onlineUsers.setText(onlineUsersText);
            //get requests
            getRequest.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    public void sendRequest(ActionEvent actionEvent) {
        if(userName.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"fill the user name field").showAndWait();
        }
        else {
            try {
                Client.joinGameOut.writeUTF("send@"+userName.getText());
                //new Alert(Alert.AlertType.ERROR, "cc").showAndWait();
                String temp = Client.joinGameIn.readUTF();
                //new Alert(Alert.AlertType.ERROR, Client.joinGameIn.readUTF()).showAndWait();
                if (temp.contains("bad")) {
                    new Alert(Alert.AlertType.ERROR, "user name is not found").showAndWait();
                }
                else if(temp.contains("good")){
                    new Alert(Alert.AlertType.CONFIRMATION,"request sent successfully").showAndWait();
                }




            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void acceptRequest(ActionEvent actionEvent) {
        if(requests.equals("") || requests.equals(null)){
            new Alert(Alert.AlertType.ERROR,"you have no request").showAndWait();
        }
        else {
            try {
                Client.helpJoinGameOut.writeUTF("accept@" + requests.getText());
                new PageLoader().load("../View/GamePage.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    Thread getRequest = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    String answer = Client.helpJoinGameIn.readUTF();
                    String[] array = answer.split("@");
                    if (answer.contains("get")) {
                        requests.setText(array[1]);
                    }
                    else if (answer.contains("accept")){
                       // new PageLoader().load("../View/GamePage.fxml");
                        break;
                    }
                }
                //new PageLoader().load("../View/GamePage.fxml");
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    public void setRequestsText(String text){

    }


    public void back(ActionEvent actionEvent) {
        try {
            new PageLoader().load("../View/MainPanelPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rejectRequest(ActionEvent actionEvent) {
        requests.setText("");
    }
}
