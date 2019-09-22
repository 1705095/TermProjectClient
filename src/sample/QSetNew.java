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
import javafx.stage.Stage;

import java.io.IOException;

public class QSetNew {

    @FXML
    private TextArea textArea;

    @FXML
    private Button back;

    @FXML
    private Button sub;

    @FXML
    private Label QName;

    @FXML
    private Label errorOUT;

    @FXML
    private Label submitError;
    int i=0;

    @FXML
    void BackHome(ActionEvent event) throws IOException {
        if (i<20 ||i>20)
        {
            errorOUT.setText("Please add 20 Questions");
        }
        else
        {
            Parent Tpage= FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
            Scene Tscene=new Scene(Tpage);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(Tscene);
            window.show();;
        }


    }

    @FXML
    void SubmitQuestion(ActionEvent event) {


    }

}
