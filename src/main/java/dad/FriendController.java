package dad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FriendController implements Initializable {

    @FXML
    private TextField apellidosText;

    @FXML
    private DatePicker cumpleanosDataPicker;

    @FXML
    private TextField emailText;

    @FXML
    private TextField movilText;

    @FXML
    private TextField nombreText;

    @FXML
    private GridPane root;

    public FriendController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FriendView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public DatePicker getCumpleanosDataPicker() {
        return cumpleanosDataPicker;
    }

    public void setCumpleanosDataPicker(DatePicker cumpleanosDataPicker) {
        this.cumpleanosDataPicker = cumpleanosDataPicker;
    }

    public TextField getEmailText() {
        return emailText;
    }

    public void setEmailText(TextField emailText) {
        this.emailText = emailText;
    }

    public TextField getApellidosText() {
        return apellidosText;
    }

    public void setApellidosText(TextField apellidosText) {
        this.apellidosText = apellidosText;
    }

    public TextField getMovilText() {
        return movilText;
    }

    public void setMovilText(TextField movilText) {
        this.movilText = movilText;
    }

    public TextField getNombreText() {
        return nombreText;
    }

    public void setNombreText(TextField nombreText) {
        this.nombreText = nombreText;
    }

    public GridPane getRoot() {
        return root;
    }

    public void setRoot(GridPane root) {
        this.root = root;
    }

    @FXML
    void onFotoAction(ActionEvent event) {

    }


}
