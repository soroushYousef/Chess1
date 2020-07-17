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

public class LoginController {

    @FXML
    public Button buttonField;
    @FXML
    public TextField UsernameField;
    @FXML
    public PasswordField passwordField;



    public void enter(ActionEvent actionEvent) {
        if(UsernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"fill the fileds").showAndWait();
        }
        else {
            try {
                Client.userOut.writeUTF("login" + "@" + UsernameField.getText() + "@" + passwordField.getText());

                if (Client.userIn.readUTF().contains("bad")) {
                    new Alert(Alert.AlertType.ERROR, "wrong user name/password").showAndWait();
                } else {
                    new PageLoader().load("../View/MainPanelPage.fxml");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void backAction(ActionEvent actionEvent) {
        try {
            new PageLoader().load("../View/SignUpPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void next(ActionEvent actionEvent) {

    }
}
