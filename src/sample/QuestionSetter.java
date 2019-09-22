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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//import static sample.BeforeQuestion.NumOQues;
import static sample.Main.socket;

public class QuestionSetter {

    @FXML
    private GridPane grid;

    @FXML
    private TextField question;

    @FXML
    private TextField opA;

    @FXML
    private TextField opB;

    @FXML
    private TextField opC;

    @FXML
    private TextField opD;

    @FXML
    private TextField CA;

    @FXML
    private TextArea look;

    @FXML
    private Button btn;

    @FXML
    private Button back;

    @FXML
    private Label error;

    int i=1;

    @FXML
    void SubmitClicked(ActionEvent event) throws IOException {

        look.setEditable(false);


        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
        printWriter.println("SetQues");
        printWriter.flush();


        /*InputStreamReader okMessage=new InputStreamReader(socket.getInputStream());
        BufferedReader okBf=new BufferedReader(okMessage);
        String CheckOK=okBf.readLine();*/


          /*  if (i <=NumOQues) {
                PrintWriter printNum = new PrintWriter(socket.getOutputStream());
                PrintWriter printQ = new PrintWriter(socket.getOutputStream());
                PrintWriter printA = new PrintWriter(socket.getOutputStream());
                PrintWriter printB = new PrintWriter(socket.getOutputStream());
                PrintWriter printC = new PrintWriter(socket.getOutputStream());
                PrintWriter printD = new PrintWriter(socket.getOutputStream());
                PrintWriter printCA = new PrintWriter(socket.getOutputStream());
                String num = Integer.toString(i);

                look.appendText("\n" + num + "." + question.getText());
                look.appendText("\n" + "a. " + opA.getText());
                look.appendText("\n" + "b. " + opB.getText());
                look.appendText("\n" + "c. " + opC.getText());
                look.appendText("\n" + "d. " + opD.getText());
                look.appendText("\n" + "correct ans: " + CA.getText());

                printNum.println(num);
                printNum.flush();
                printQ.println(question.getText());
                printQ.flush();
                printA.println(opA.getText());
                printA.flush();
                printB.println(opB.getText());
                printB.flush();
                printC.println(opC.getText());
                printC.flush();
                printD.println(opD.getText());
                printD.flush();
                printCA.println(CA.getText());
                printCA.flush();

                question.clear();
                opA.clear();
                opB.clear();
                opC.clear();
                opD.clear();
                CA.clear();

                i++;
            } else if (i > NumOQues) {
                error.setText("NO MORE QUESTIONS");
            }*/

        if(i<=20) {
            /*Socket ss=new Socket("localhost",5000);*/
            PrintWriter printNum=new PrintWriter(socket.getOutputStream());
            PrintWriter printQ=new PrintWriter(socket.getOutputStream());
            PrintWriter printA=new PrintWriter(socket.getOutputStream());
            PrintWriter printB=new PrintWriter(socket.getOutputStream());
            PrintWriter printC=new PrintWriter(socket.getOutputStream());
            PrintWriter printD=new PrintWriter(socket.getOutputStream());
            PrintWriter printCA=new PrintWriter(socket.getOutputStream());

            PrintWriter WriteToServer=new PrintWriter(socket.getOutputStream());
            String num=Integer.toString(i);
            look.appendText("\n"+num +"."+ question.getText());
            look.appendText("\n" +"a. "+ opA.getText());
            look.appendText("\n" +"b. "+ opB.getText());
            look.appendText("\n" +"c. "+ opC.getText());
            look.appendText("\n" +"d. "+ opD.getText());
            look.appendText("\n" +"correct ans: "+ CA.getText());

          //  String string=String.valueOf(i)+". "+question.getText()+" "+"a. "+opA.getText()+" "+"b. "+opB.getText()+" "+"c. "+opC.getText()+" "+"d. "+ opD.getText();
          //  System.out.println(string);

           // WriteToServer.println(string);
          //  WriteToServer.flush();


           printNum.println(num);
            printNum.flush();
            printQ.println(question.getText());
            printQ.flush();
            printA.println(opA.getText());
            printA.flush();
            printB.println(opB.getText());
            printB.flush();
            printC.println(opC.getText());
            printC.flush();
            printD.println(opD.getText());
            printD.flush();
            printCA.println(CA.getText());
            printCA.flush();
            i++;

            question.clear();
            opA.clear();
            opB.clear();
            opC.clear();
            opD.clear();
            CA.clear();
       }
        if(i>20)
        {
            error.setText("NO MORE QUESTIONS");
        }




    }

    @FXML
    void backhome(ActionEvent event) throws IOException {
        Parent Tpage = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        Scene Tscene = new Scene(Tpage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
