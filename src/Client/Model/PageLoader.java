package Client.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PageLoader {

    private static final int WIDTH = 1000;
    private static final int Height = 1000;
    public static Stage stage;



    public static void initStage(Stage primaryStage){
        stage = primaryStage;
        stage.initStyle(StageStyle.DECORATED);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMaxHeight(Height);
        // stage.setMaxHeight(Height);
        //stage.setMaxWidth(WIDTH);
    }

    public void load(String url) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        stage.setScene(new Scene(root,800,800 ));
        stage.show();
    }
}




