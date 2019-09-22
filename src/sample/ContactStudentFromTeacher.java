package sample;

import Connectivity.ConnectionForStudentContacts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactStudentFromTeacher implements Initializable {
    // TODO: create a connection class for studentcontact, and a class for table

    @FXML
    private Button back;

    @FXML
    private TableView<ContactStudentTable> tableview;

    @FXML
    private TableColumn<ContactStudentTable, String> name;

    @FXML
    private TableColumn<ContactStudentTable, String> email;

    @FXML
    private TableColumn<ContactStudentTable, String> DoB;

    @FXML
    private TableColumn<ContactStudentTable, String> stat;

    ObservableList<ContactStudentTable>observableList= FXCollections.observableArrayList();

    @FXML
    void BacktoHome(ActionEvent event) throws IOException {

        Parent Tpage= FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            Connection connection= ConnectionForStudentContacts.getConnection();
            ResultSet rs=connection.createStatement().executeQuery("SELECT * FROM STUDENT");
            while (rs.next())
            {
                observableList.add(new ContactStudentTable(rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("birth date"),
                        rs.getString("status")));
                tableview.setItems(observableList);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ContactsStudent.class.getName()).log(Level.SEVERE,null,ex);
        }
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        DoB.setCellValueFactory(new PropertyValueFactory<>("birth date"));
        stat.setCellValueFactory(new PropertyValueFactory<>("status"));

    }
}
