package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.util.converter.IntegerStringConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static sample.Main.socket;

public class BeforeQuestion {
    public static String questionName=null;
    public static int ExTime=0;
   // public static int NumOQues=0;



    @FXML
    private Button btn;

    @FXML
    private Label error;

    @FXML
    private Label message;

    @FXML
    private TextField time;

    @FXML
    private TextField examname;



    @FXML
    void SeeQuestionPage(ActionEvent event) throws IOException {
        if (time.getText()!=null && examname.getText()!=null ) {


            PrintWriter Confirm=new PrintWriter(socket.getOutputStream());
            Confirm.println("SetQues");


            ExTime= Integer.parseInt(time.getText());
            //NumOQues=Integer.parseInt(numquestion.getText());
            questionName=examname.getText();
            Parent Tpage = FXMLLoader.load(getClass().getResource("QuestionSetter.fxml"));
            Scene Tscene = new Scene(Tpage);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Tscene);
            window.show();
        }
        else
        {
            error.setText("Please fill all sectors");
        }
    }

    @FXML
    void CreateQuestion(ActionEvent event) throws IOException {

        PrintWriter Confirm=new PrintWriter(socket.getOutputStream());
        Confirm.println("QuesData");
        Confirm.flush();

        InputStreamReader okMessage=new InputStreamReader(socket.getInputStream());
        BufferedReader okBf=new BufferedReader(okMessage);
        String CheckOK=okBf.readLine();

        if (CheckOK.equals("OKQuesData")) {
            PrintWriter QName = new PrintWriter(socket.getOutputStream());
            QName.println(examname.getText());
            QName.flush();
        }
    }

}
