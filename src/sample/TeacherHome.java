package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static sample.Main.socket;

public class TeacherHome {

    @FXML
    private Label teachername;

    @FXML
    private Button setques;

    @FXML
    private Button notice;

    @FXML
    private Button score;

    @FXML
    private Button lo;

    @FXML
    private Button stat;

    @FXML
    void LogOut(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();


    }

    @FXML
    void NotifyStudent(ActionEvent event) throws IOException {
        PrintWriter Confirm=new PrintWriter(socket.getOutputStream());
        Confirm.println("Notice");
        Confirm.flush();

        Parent Tpage= FXMLLoader.load(getClass().getResource("NoticeInput.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void ScoreBoard(ActionEvent event) {

    }

    @FXML
    void SetQuestions(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("BeforeQuestion.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void StatusShow(ActionEvent event) {

    }

    @FXML
    void ContactStudent(ActionEvent event) throws IOException {
        PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("Viewing Student Data list");
        actionMessage.flush();

        Parent Tpage= FXMLLoader.load(getClass().getResource("ContactsStudent.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void ContactTeacher(ActionEvent event) throws IOException {
        PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("Viewing Teacher Data list");
        actionMessage.flush();

        Parent Tpage= FXMLLoader.load(getClass().getResource("ContactsTeacher.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
