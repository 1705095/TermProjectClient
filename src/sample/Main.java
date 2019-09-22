package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;


public class Main extends Application {
    public static Socket socket;

    static {
        try {
            socket = new Socket("localhost",5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        primaryStage.setTitle("Online Exam");
        primaryStage.setScene(new Scene(root, 970, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
