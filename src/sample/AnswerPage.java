package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static sample.Main.socket;

public class AnswerPage {

    @FXML
    private TextField a1;

    @FXML
    private TextField a2;

    @FXML
    private TextField a3;

    @FXML
    private TextField a4;

    @FXML
    private TextField a5;

    @FXML
    private TextField a6;

    @FXML
    private TextField a7;

    @FXML
    private TextField a8;

    @FXML
    private TextField a9;

    @FXML
    private TextField a10;

    @FXML
    private TextField a11;

    @FXML
    private TextField a12;

    @FXML
    private TextField a13;

    @FXML
    private TextField a14;

    @FXML
    private TextField a15;

    @FXML
    private TextField a16;

    @FXML
    private TextField a17;

    @FXML
    private TextField a18;

    @FXML
    private TextField a19;

    @FXML
    private TextField a20;

    @FXML
    private TextArea QuestionSet;

    @FXML
    private Label time;

    @FXML
    private Button show;
    static  long AfterTT,tt;



    @FXML
    void ShowQues(ActionEvent event) throws IOException, InterruptedException {
        PrintWriter Confirm=new PrintWriter(socket.getOutputStream());
        Confirm.println("SeeQuestion");
        Confirm.flush();


       // x=timer();



        InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String st;
        while (true)
        {
            st=bufferedReader.readLine();
            if (st.equals("null"))
            {
                break;
            }
            else if (st.equals("GoAnswer"))
            {

            }
            else
            {
                QuestionSet.appendText("\n"+st);
            }
        }
        tt=System.currentTimeMillis();
        AfterTT=System.currentTimeMillis()+(60*1000);



    }


    @FXML
    void submit(ActionEvent event) throws IOException, InterruptedException {
        long SubmitTT=System.currentTimeMillis();
        System.out.println(SubmitTT);
        System.out.println(AfterTT);
        if (AfterTT<=SubmitTT) {

            time.setText("TimeOUT");
            //Thread.sleep(1000);
            Parent Tpage = FXMLLoader.load(getClass().getResource("TimeOUTPAGE.fxml"));
            Scene Tscene = new Scene(Tpage);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Tscene);
            window.show();
        }
        else
        {
            PrintWriter pp = new PrintWriter(socket.getOutputStream());
            pp.println("submitAns");
            pp.flush();
            String str = a1.getText() + a2.getText() + a3.getText() + a4.getText() + a5.getText() + a6.getText() + a7.getText() + a8.getText() + a9.getText() + a10.getText() + a11.getText() + a12.getText()
                    + a13.getText() + a14.getText() + a15.getText() + a16.getText() + a17.getText() + a18.getText() + a19.getText() + a20.getText();

            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(str);
            printWriter.flush();

            Parent Tpage = FXMLLoader.load(getClass().getResource("AfterExam.fxml"));
            Scene Tscene = new Scene(Tpage);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Tscene);
            window.show();


        }



    }

    @FXML
    void Help(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("HowToAns.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
