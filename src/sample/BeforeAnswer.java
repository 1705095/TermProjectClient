package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

import static sample.Main.socket;

public class BeforeAnswer {

    @FXML
    private Button home;

    @FXML
    private TextField GetQName;

    @FXML
    private TextArea QuestionName;
    static  String QN;

    //works perfectly ;)

    @FXML
    void GoToAns(ActionEvent event) throws IOException {

        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
        printWriter.println("GoAnswer");
        printWriter.flush();

        PrintWriter QuesName=new PrintWriter(socket.getOutputStream());
        QuesName.println(GetQName.getText());
        QuesName.flush();
        QN=GetQName.getText();

       InputStreamReader okMessage=new InputStreamReader(socket.getInputStream());
        BufferedReader okBf=new BufferedReader(okMessage);
        String CheckOK=okBf.readLine();

        System.out.println(CheckOK);

        if(CheckOK.equals("found"))
        {
            Parent Tpage = FXMLLoader.load(getClass().getResource("AnswerPage.fxml"));
            Scene Tscene = new Scene(Tpage);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(Tscene);
            window.show();
        }
        else
        {
            System.out.println("Error");
        }


    }

    //works perfectly

    @FXML
    void SeeQues(ActionEvent event) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("SeeQuesBeforeAns");
        printWriter.flush();
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String st;
        while (true) {
                st = bufferedReader.readLine();
                if (st.equals("null")) {
                    break;
                }
                else if (st.equals("login")||st.equals("OKSEE"))
                {

                }
                else {
                    QuestionName.appendText("\n" + st);
                }
            }


    }


    @FXML
    void BackHome(ActionEvent event) throws IOException {
        Parent Tpage = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
        Scene Tscene = new Scene(Tpage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
