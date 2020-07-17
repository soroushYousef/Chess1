package Client.Controller;

import Client.Model.Client;
import Client.Model.PageLoader;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainPanelController {

    public void join(ActionEvent actionEvent) {
        try {
            new PageLoader().load("../View/JoinGamePage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit(ActionEvent actionEvent) {
        try {
            new PageLoader().load("../View/EditUserPage.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void history(ActionEvent actionEvent) {
    }

    public void score(ActionEvent actionEvent) {
    }

    public void about(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) {
        try {
            Client.userOut.writeUTF("logout");
            new PageLoader().load("../View/Login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
