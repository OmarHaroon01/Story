package App;

import Utilities.Serializer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jdk.jshell.execution.Util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private ImageView logoImage;

    @FXML
    private Label myUploadsLabel;

    @FXML
    private Label storiesLabel;

    @FXML
    private Button logoutButton;

    @FXML
    private ImageView profilePictureImage;

    @FXML
    private Button editProfilePictureButton;

    @FXML
    private Label fullnameLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label totalUploadsLabel;

    @FXML
    void editProfilePictureButtonClicked(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage mainWindow = (Stage) this.editProfilePictureButton.getScene().getWindow();
        File choosenProfilePhoto = fileChooser.showOpenDialog(mainWindow);

        if (choosenProfilePhoto != null) {
            Utility.currentUser.setPhotoPath("file://" + choosenProfilePhoto.toURI().getPath());
            Image image = new Image(Utility.currentUser.getPhotoPath());
            profilePictureImage.setImage(image);
        }
        Serializer.serialize();
    }

    @FXML
    void logoutButtonClicked(MouseEvent event) throws IOException {
        Utility.currentUser = null;
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.editProfilePictureButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void myUploadsLabelClicked(MouseEvent event) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MyUpload.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.editProfilePictureButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void storiesLabelClicked(MouseEvent event) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Wall.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.editProfilePictureButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fullnameLabel.setText(Utility.currentUser.getFullName());
        this.userNameLabel.setText(Utility.currentUser.getUserName());
        this.emailLabel.setText(Utility.currentUser.getEmail());
        this.genderLabel.setText(Utility.currentUser.getGender());
        this.totalUploadsLabel.setText(String.valueOf(Utility.currentUser.getUsersImage().size()));
        File f = new File("./resources/logo.png");
        this.logoImage.setImage(new Image("File://" + f.toURI().getPath()));
        this.profilePictureImage.setImage(new Image(Utility.currentUser.getPhotoPath()));
    }
}
