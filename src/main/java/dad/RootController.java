package dad;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    private final FriendController friendController = new FriendController();

    private final ListProperty<Friend> friends = new SimpleListProperty<>(FXCollections.observableArrayList(
            friend -> new Observable[] { friend.nameProperty(), friend.surnameProperty() }
    ));
    private final ObjectProperty<Friend> selectedFriend = new SimpleObjectProperty<>();

    @FXML
    private Button enemyButtom;

    @FXML
    private Button friendButtom;

    @FXML
    private ListView<Friend> frindList;



    @FXML
    private BorderPane root;

    @FXML
    private VBox emptyBox;

    public RootController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        frindList.itemsProperty().bind(friends);
        selectedFriend.bind(frindList.getSelectionModel().selectedItemProperty());
        enemyButtom.disableProperty().bind(selectedFriend.isNull());

        selectedFriend.addListener(this::onSelectedFriendChanged);



    }

    private void onSelectedFriendChanged(ObservableValue<? extends Friend> o, Friend ov, Friend nv) {
        if (nv == null) {
            root.setCenter(emptyBox);
        } else {
            root.setCenter(friendController.getRoot());
        }
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    @FXML
    void onEnemyAction(ActionEvent event) {

        friends.remove(selectedFriend.get());

    }

    @FXML
    void onFriendAction(ActionEvent event) {

        Friend friend = new Friend();
        friend.setName("Nombre");
        friend.setSurname("Apellidos");
        friends.add(friend);
        frindList.getSelectionModel().select(friend);

    }

    public Button getEnemyButtom() {
        return enemyButtom;
    }

    public ListView<?> getFrindList() {
        return frindList;
    }

    public Button getFriendButtom() {
        return friendButtom;
    }

    public void setFriendButtom(Button friendButtom) {
        this.friendButtom = friendButtom;
    }
}
