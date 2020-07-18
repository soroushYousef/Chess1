package Client.Controller;

import Client.Model.Client;
import Client.Model.PageLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;


import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class JoinGameController {

    @FXML
    TextArea onlineUsers,requests;
    @FXML
    TextField userName;
    @FXML
    Button nextButton;

  //volatile AtomicBoolean isRequestAccepted = new AtomicBoolean(false);
    boolean[] booleans = new boolean[1];


    public void initialize(){
        try {
            Client.joinGameOut.writeUTF("details");
            String onlineUsersText = Client.joinGameIn.readUTF();
            onlineUsers.setText(onlineUsersText);
            //booleans[0] = false;
         //   nextButton.setVisible(true);
            //get requests
            getRequest.start();
         //   getToGame.start();


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
                Client.userOut.writeUTF("send@"+userName.getText());
                //new Alert(Alert.AlertType.ERROR, "cc").showAndWait();
                String temp = Client.userIn.readUTF();
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
        if(requests.getText().contains("request")==false){
            new Alert(Alert.AlertType.ERROR,"you have no request").showAndWait();
        }
        else {
            try {
                Client.joinGameOut.writeUTF("accept@" + requests.getText().split(" ")[0]);
                new PageLoader().load("../View/GamePage.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    Thread getRequest = new Thread(new Runnable() {
        boolean flag = true;
        @Override
        public void run() {
            try {
          //      while (flag) {
                    String answer = Client.joinGameIn.readUTF();
                    String[] array = answer.split("@");
                    if (answer.contains("get")) {
                        requests.setText(array[1]+ " " + " : " +" request");
                  //      flag = false;
                    }
                    else if (answer.contains("accept")) {
                        //Client.requestStatue = answer;
                        //    }

                        //  else if (answer.contains("accept")) {
                        //   new Alert(Alert.AlertType.ERROR,answer).showAndWait();
                        //  requests.setText(answer);
                        //flag = false;/


                        Thread t = new Thread(new Runnable() {
                            @Override
                            public void run() {


                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                           // nextButton.setVisible(true);
                                          //  new Alert(Alert.AlertType.ERROR, answer).showAndWait();
                                           // Client.isRequestAccepted = true;
                                            new PageLoader().load("../View/GamePage.fxml");
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });
                            }


                        });
                        t.start();
                    }

                            /*
                        });
                        t.start();
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        */





                        //    AcceptedRequest.getAcceptedRequest().setAcceptedRequest(true);

                        //gamePageLoader(answer);
                        //  new Alert(Alert.AlertType.ERROR,"AA").showAndWait();
                        //Client.isRequestAccepted = true;
                       //requests.setText("accepted!!");
                    //    Client.str = answer;
                  //  }
           //    }

            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

    /*
    Thread getToGame = new Thread(new Runnable() {
        @Override
        public void run() {
                try {
                    while (true) {
                    String answer = Client.helpJoinGameIn1.readUTF();
                    String array []= answer.split("@");

                    if (answer.contains("accept")) {
                        new PageLoader().load("../View/GamePage.fxml");
                    }
                  }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    });

     */


    public synchronized void setRequestsText(String text){
        this.requests.setText(text);

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





    public void update(ActionEvent actionEvent) {
        /*
        try {
            String txt = Client.helpJoinGameIn1.readUTF();
            new Alert(Alert.AlertType.ERROR,txt).showAndWait();
           // new Alert(Alert.AlertType.ERROR,AcceptedRequest.getAcceptedRequest().getb() ? "true" : "false").showAndWait();
            if(txt.contains("accept")){

                new PageLoader().load("../View/GamePage.fxml");
            }
            else {
                new Alert(Alert.AlertType.ERROR,"you have not been accepted").showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }








    /*
    public void gamePageLoader(String txt) {
        Thread t = new Thread() {
            @Override
            public void run(){

              /* Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setRequestAccepted(true);
                        requests.setText("accepted!!");
                       // new Alert(Alert.AlertType.ERROR,booleans[0] ? "true" : "false").showAndWait();
                        new Alert(Alert.AlertType.ERROR,txt).showAndWait();
                        //  new PageLoader().load("../View/GamePage.fxml");
                    }

                AcceptedRequest.getAcceptedRequest().setAcceptedRequest(true);
            }
        };
        t.start();
        //try {
       //     t.join();
       // } catch (InterruptedException e) {
    //        e.printStackTrace();
     //   }
    }
    */


    public void next(ActionEvent actionEvent) {
        /*
        try {
            if(Client.requestStatue.contains("accept")) {
            //if(Client.helpJoinGameIn.readUTF().contains("accept")){
                new PageLoader().load("../View/GamePage.fxml");
            }
            else {
                new Alert(Alert.AlertType.ERROR,"you are not accepted").showAndWait();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }

    public synchronized void setRequestAccepted(boolean b){
        this.booleans[0] = b;
    }
}
