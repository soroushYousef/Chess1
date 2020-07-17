package Client.Controller;

import Client.Model.Client;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;

    public void signUp(ActionEvent actionEvent) {
        if(userName.getText().isEmpty() || password.getText().isEmpty() || password.getText().length()<8){
            new Alert(Alert.AlertType.ERROR,"fill the fields correctly").showAndWait();
        }
        else {
            try {
                Client.userOut.writeUTF("New@User@" + userName.getText() + "@" + password.getText());
               //  new Alert(Alert.AlertType.ERROR,"user").showAndWait();

                if(Client.userIn.readUTF().contains("bad")){
                    new Alert(Alert.AlertType.ERROR,"user name tekrari ast").showAndWait();
                }

                else {
                    new Alert(Alert.AlertType.CONFIRMATION,"add shodid!!").showAndWait();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void next(ActionEvent actionEvent) {
        try {
            new PageLoader().load("../View/LoginPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}