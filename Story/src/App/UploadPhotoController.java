package App;

import Properties.Images;
import Utilities.DataValidator;
import Utilities.Serializer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class UploadPhotoController implements Initializable {

    @FXML
    private TextArea captionField;

    @FXML
    private ImageView imageView;

    @FXML
    private ToggleButton choosePhotoButton;

    @FXML
    private ToggleGroup privacy1;

    @FXML
    private ToggleButton publicButton;

    @FXML
    private ToggleGroup privacy;

    @FXML
    private ToggleButton privateButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button uploadButton;


    private String photoPath = null;
    @FXML
    void cancelButtonClicked(MouseEvent event) {
        Stage currentStage = (Stage) this.cancelButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void choosePhotoButtonClicked(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage mainWindow = (Stage) this.choosePhotoButton.getScene().getWindow();
        File choosenProfilePhoto = fileChooser.showOpenDialog(mainWindow);

        if (choosenProfilePhoto != null) {
            photoPath = "file://" + choosenProfilePhoto.toURI().getPath();
            Image image = new Image("file://" + choosenProfilePhoto.toURI().getPath());
            imageView.setImage(image);
        }
    }

    @FXML
    void privateButtonClicked(MouseEvent event) {
        this.privateButton.setStyle("-fx-background-color: #00ff44; -fx-background-radius: 15px; " +
                "-fx-border-color: #9100a8; -fx-border-radius: 15px ");
        this.publicButton.setStyle("-fx-background-color:  #C0DAF3; -fx-background-radius: 15px;" +
                "-fx-border-color: #9100a8; -fx-border-radius: 15px ");
    }

    @FXML
    void publicButtonClicked(MouseEvent event) {
        this.privateButton.setStyle("-fx-background-color: #C0DAF3; -fx-background-radius: 15px;" +
                "-fx-border-color: #9100a8; -fx-border-radius: 15px ");
        this.publicButton.setStyle("-fx-background-color:  #00ff44; -fx-background-radius: 15px;" +
                "-fx-border-color: #9100a8; -fx-border-radius: 15px ");
    }

    @FXML
    void uploadButtonClicked(MouseEvent event) {
        String privacy = null;

        if (this.publicButton.isSelected()){
            privacy = "Public";
        } else if (this.privateButton.isSelected()){
            privacy = "Private";
        }
        try{
            DataValidator.validatePhotoUpload(this.photoPath, privacy);

            Images image = new Images(photoPath, Utility.currentUser.getUserName(),
                            this.captionField.getText(), privacy);

            Utility.currentUser.addImage(image);

            Serializer.serialize();

            if (privacy.equals("Public")) {
                Serializer.imageList.add(image);
                Serializer.serialize();
            }

            Stage currentStage = (Stage) this.uploadButton.getScene().getWindow();
            Utility.errorMessageHelper(currentStage, "Image uploaded Successfully!!");
            currentStage.close();

        } catch (Exception e){
            Stage currentStage = (Stage) this.uploadButton.getScene().getWindow();
            Utility.errorMessageHelper(currentStage, e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File f = new File("./resources/default_addImage.png");
        this.imageView.setImage(new Image("File://" + f.toURI().getPath()));


    }
}
