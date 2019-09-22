package sample;

import Connectivity.ConnectionForTeacherContacts;
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

import javax.naming.Name;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactTeacherFromTeacher implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TableView<ContactTeacherTable> tableview;

    @FXML
    private TableColumn<ContactTeacherTable, String> name;

    @FXML
    private TableColumn<ContactTeacherTable, String> email;

    @FXML
    private TableColumn<ContactTeacherTable, String> DoB;

    @FXML
    private TableColumn<ContactTeacherTable, String> stat;

    ObservableList<ContactTeacherTable> observableList= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            Connection connection=ConnectionForTeacherContacts.getConnection();
            ResultSet rs=connection.createStatement().executeQuery("SELECT * FROM TEACHER");
            while (rs.next())
            {
                observableList.add(new ContactTeacherTable(rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("birthdate"),
                        rs.getString("status")));
                tableview.setItems(observableList);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ContactsTeacher.class.getName()).log(Level.SEVERE,null,ex);

        }
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        DoB.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        stat.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @FXML
    void BacktoHome(ActionEvent event) throws IOException {
        Parent Tpage= FXMLLoader.load(getClass().getResource("TeacherHome.fxml"));
        Scene Tscene=new Scene(Tpage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Tscene);
        window.show();

    }

}
