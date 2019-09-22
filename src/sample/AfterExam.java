package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static sample.BeforeAnswer.QN;
import static sample.Main.socket;

public class AfterExam {

    @FXML
    private Label date;

    @FXML
    private Label examname;

    @FXML
    private Label markob;

    @FXML
    private Label rightans;

    @FXML
    private Label wrongans;

    @FXML
    private Label grade;

    @FXML
    private Button homebutton;

    @FXML
    private Label timeOUT;

    @FXML
    private Button res;

    @FXML
    void BackToHome(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();


    }

    @FXML
    void SeeResult(ActionEvent event) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date.setText(String.valueOf(now));

        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
        printWriter.println("SeeMarks");
        printWriter.flush();

        InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        //String ajara=bufferedReader.readLine();

        String mark=bufferedReader.readLine();
        String Mark=bufferedReader.readLine();
        String RA=bufferedReader.readLine();
        rightans.setText(RA);
        markob.setText(Mark);
        int WA=20-Integer.parseInt(RA);
        wrongans.setText(String.valueOf(WA));

        examname.setText(QN);

        /*if (mark.equals("submitAns")) {

            //markob.setText(mark);
            rightans.setText(correctans);
            wrongans.setText(wa);
            System.out.println(mark);
            System.out.println(correctans);
            System.out.println(wa);
        }*/




    }

}
