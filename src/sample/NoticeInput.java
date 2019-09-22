package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;

import static sample.Main.socket;

public class NoticeInput {

    @FXML
    private TextArea notice;

    @FXML
    private Button sendb;

    @FXML
    private Button bck;


    @FXML
    void SendClicked(ActionEvent event) throws IOException {
        String str=notice.getText();
        System.out.println(str);
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
        printWriter.println(notice.getText());
        printWriter.flush();
        notice.clear();





    }
    @FXML
    void BackButton(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
