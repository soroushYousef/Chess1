package Client.Controller;

import Client.Model.Client;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditUserController {

    @FXML
    TextField password;


    public void changePass(ActionEvent actionEvent) {
        if(password.getText().isEmpty() || password.getText().length()<8){
            new Alert(Alert.AlertType.ERROR,"please fill the fields correctly").showAndWait();
        }
        else {
            try {
                Client.userOut.writeUTF("change@"+password.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteAcount(ActionEvent actionEvent) {
        try {
            Client.userOut.writeUTF("delete");
            new PageLoader().load("../View/LoginPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void back(ActionEvent actionEvent) {
        try {
            new PageLoader().load("MainPanelPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
