package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.PrimitiveIterator;

import static sample.Main.socket;

public class RegistrationPage {

    @FXML
    private GridPane gpane;

    @FXML
    private TextField nameText;

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private PasswordField rewritepasswordText;

    @FXML
    private DatePicker DateofBirth;

    @FXML
    private MenuButton statusSelect;

    @FXML
    private MenuItem teacher;

    @FXML
    private MenuItem student;

    @FXML
    private Button registerButton;

    @FXML
    private Button LogIn;

    @FXML
    private Label errorLabel;

    @FXML
    void getStudent(ActionEvent event) {
        statusSelect.setText("Student");
    }

    @FXML
    void getTeacher(ActionEvent event) {
        statusSelect.setText("Teacher");

    }

    @FXML
    void login(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

    @FXML
    void register(ActionEvent event) throws IOException {

        if (nameText.getText()!=null && emailText!=null && passwordText!=null && rewritepasswordText!=null && DateofBirth!=null && statusSelect!=null) {
            if ((rewritepasswordText.getText()).equals(passwordText.getText())) {
                //Socket socket = new Socket("localhost", 5000);

                PrintWriter actionMessage = new PrintWriter(socket.getOutputStream());
                actionMessage.println("Reg");
                actionMessage.flush();

                InputStreamReader okMessage = new InputStreamReader(socket.getInputStream());
                BufferedReader okBf = new BufferedReader(okMessage);
                String CheckOK = okBf.readLine();

                if (CheckOK.equals("okRegister")) {
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                    printWriter.println(nameText.getText());
                    printWriter.flush();
                    printWriter.println(emailText.getText());
                    printWriter.flush();
                    printWriter.println(passwordText.getText());
                    printWriter.flush();
                    printWriter.println(DateofBirth.getValue());
                    printWriter.flush();
                    printWriter.println(statusSelect.getText());
                    printWriter.flush();

                    if ((statusSelect.getText()).equals("Teacher")) {
                        Parent Tpage = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
                        Scene Tscene = new Scene(Tpage);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(Tscene);
                        window.show();

                    } else if ((statusSelect.getText()).equals("Student")) {
                        Parent Tpage = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
                        Scene Tscene = new Scene(Tpage);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(Tscene);
                        window.show();

                    }
                }

            } else {
                errorLabel.setText("Password Doesn't Match");
            }
        }
            else {
                errorLabel.setText("Please fill all sectors");
            }

    }

}
