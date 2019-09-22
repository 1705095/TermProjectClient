package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static sample.Main.socket;

public class LogInPage {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private MenuButton menubar;

    @FXML
    private MenuItem Teacher;

    @FXML
    private MenuItem Student;


    @FXML
    void getStat(ActionEvent event) {

    }

    @FXML
    private Label errorout;

    @FXML
    void getStudent(ActionEvent event) {
        menubar.setText("Student");

    }

    @FXML
    void getTeacher(ActionEvent event) {
        menubar.setText("Teacher");

    }

    @FXML
    void loginclicked(ActionEvent event) throws IOException {
        //Socket socket=new Socket("localhost",5000);

        PrintWriter actionMessage=new PrintWriter(socket.getOutputStream());
        actionMessage.println("login");
        actionMessage.flush();

        InputStreamReader okMessage=new InputStreamReader(socket.getInputStream());
        BufferedReader okBf=new BufferedReader(okMessage);
        String CheckOK=okBf.readLine();
        if (CheckOK.equals("OKlogin")) {
            String emailStr = email.getText();
            String passwordStr = password.getText();
            String Stat = menubar.getText();
            String Outstr = Stat + emailStr + passwordStr;
            String sub = Outstr.substring(0, 7);


            PrintWriter OUT = new PrintWriter(socket.getOutputStream());
            OUT.println(Outstr);
            OUT.flush();


            InputStreamReader checkin = new InputStreamReader(socket.getInputStream());
            BufferedReader checkbf = new BufferedReader(checkin);
            String Check = checkbf.readLine();
            if (Check.equals("found") && sub.equals("Teacher")) {
                Parent Tpage = FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
                Scene Tscene = new Scene(Tpage);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Tscene);
                window.show();

            } else if (Check.equals("found") && sub.equals("Student")) {
                Parent Tpage = FXMLLoader.load(getClass().getResource("StudentHome.fxml"));
                Scene Tscne = new Scene(Tpage);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Tscne);
                window.show();
            } else {
                errorout.setText("Can't Log In, You have to register");
            }
        }
        else
        {
            errorout.setText("Server Problem");
        }




    }

    @FXML
    void signupclicked(ActionEvent event) throws IOException {
        Parent Tpage=FXMLLoader.load(getClass().getResource("RegistrationPage.fxml"));
        Scene Tscne=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscne);
        window.show();


    }

}
