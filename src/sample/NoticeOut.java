package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static sample.Main.socket;

public class NoticeOut {

    @FXML
    private TextArea NoticeText;

    @FXML
    private Button button;

    @FXML
    private Button buttonRef;

    @FXML
    void BackToHome(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void Refresh(ActionEvent event) throws IOException {

        PrintWriter Confirm=new PrintWriter(socket.getOutputStream());
        Confirm.println("SeeNotice");
        Confirm.flush();

        InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        NoticeText.clear();

        String st;
        while (true)
        {
            st=bufferedReader.readLine();
            if (st.equals("null"))
            {
                break;
            }
            else if (st.equals("login"))
            {

            }
            else
            {
                NoticeText.appendText("\n"+st);
            }
        }



    }

}
