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

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static sample.Main.socket;

public class StudentHome {

    @FXML
    private Label stName;

    @FXML
    private Button xm;

    @FXML
    private Button rnk;

    @FXML
    private Button hstry;

    @FXML
    private Button nb;

    @FXML
    private Button conTeach;

    @FXML
    private Button conST;

    @FXML
    private Button help;

    @FXML
    private Button lo;

    @FXML
    void GetHelp(ActionEvent event) throws IOException {

        PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("Seeking help");
        actionMessage.flush();

        Parent Tpage= FXMLLoader.load(getClass().getResource("HelpStudent.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void LogOut(ActionEvent event) throws IOException {

        /*PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("logout");
        actionMessage.flush();*/

        Parent Tpage= FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();



    }

    @FXML
    void ContactWithStudents(ActionEvent event) throws IOException {

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
    void ContactWithTeacher(ActionEvent event) throws IOException {

        PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("Viewing Teacher Data list");
        actionMessage.flush();

        Parent Tpage= FXMLLoader.load(getClass().getResource("ContactsTeacher.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();
    }



    @FXML
    void SeeHistory(ActionEvent event) {


    }

    @FXML
    void SeeNotice(ActionEvent event) throws IOException {

        /*PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("Viewing Notice Board");
        actionMessage.flush();*/


        Parent Tpage= FXMLLoader.load(getClass().getResource("NoticeOut.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void SeeRank(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("AnswerPage.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void giveExam(ActionEvent event) throws IOException {


        /*PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("Preparing for exam");
        actionMessage.flush();*/


      /*  Parent Tpage= FXMLLoader.load(getClass().getResource("BeforeAnswer.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();*/

        Parent Tpage= FXMLLoader.load(getClass().getResource("BeforeAnswer.fxml"));


        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
