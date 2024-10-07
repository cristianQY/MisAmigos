package dad;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FriendController implements Initializable {

    private ObjectProperty<Friend> friend = new SimpleObjectProperty<>();

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
    private ImageView fotoView;

    @FXML
    private Button fotoButtom;

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

        friend.addListener(this::onFriendChanged);

    }

    private void onFriendChanged(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {

        if (ov != null) {

            nombreText.textProperty().unbindBidirectional(ov.nameProperty());
            apellidosText.textProperty().unbindBidirectional(ov.surnameProperty());
            cumpleanosDataPicker.valueProperty().unbindBidirectional(ov.birthDateProperty());
            movilText.textProperty().unbindBidirectional(ov.phoneNumberProperty());
            emailText.textProperty().unbindBidirectional(ov.phoneNumberProperty());
            fotoView.imageProperty().unbindBidirectional(ov.photoProperty());

        }
        if (nv != null) {

            nombreText.textProperty().bindBidirectional(nv.nameProperty());
            apellidosText.textProperty().bindBidirectional(nv.surnameProperty());
            cumpleanosDataPicker.valueProperty().bindBidirectional(nv.birthDateProperty());
            movilText.textProperty().bindBidirectional(nv.phoneNumberProperty());
            emailText.textProperty().bindBidirectional(nv.phoneNumberProperty());
            fotoView.imageProperty().bindBidirectional(nv.photoProperty());

        }
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

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar foto");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("imagen", "*.png", "*.jpg", "*jpeg"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los ficheros", "*.*"));
        File imageFile = fileChooser.showOpenDialog(getRoot().getScene().getWindow());
        if (imageFile != null) {
            Image photo = new Image(imageFile.toURI().toString());
            friend.get().setPhoto(photo);
        }

    }

    public Friend getFriend() {
        return friend.get();
    }

    public ObjectProperty<Friend> friendProperty() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend.set(friend);
    }


}
