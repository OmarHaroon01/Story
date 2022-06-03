package App;

import Utilities.Serializer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyUploadController implements Initializable {

    @FXML
    private ImageView logo;

    @FXML
    private Label profileLabel;

    @FXML
    private Label storiesLabel;

    @FXML
    private Button uploadNewButton;

    @FXML
    private Button logoutButton;

    @FXML
    private VBox vBox;

    @FXML
    void logoutButtonClicked(MouseEvent event) throws IOException {
        Utility.currentUser = null;
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.logoutButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void profileLabelClicked(MouseEvent event) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.logoutButton.getScene().getWindow();
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
        Stage primaryStage = (Stage)this.storiesLabel.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void uploadNewButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Utility.class.getResource("UploadPhoto.fxml"));
        AnchorPane root = (AnchorPane) loader.load();
        Stage currentStage = (Stage) this.logoutButton.getScene().getWindow();
        Stage errorStage = new Stage();
        Scene newScene = new Scene(root);
        errorStage.setScene(newScene);
        errorStage.sizeToScene();
        errorStage.initOwner(currentStage);
        errorStage.initModality(Modality.APPLICATION_MODAL);
        errorStage.setResizable(false);
        errorStage.showAndWait();
        AnchorPane roots = (AnchorPane) FXMLLoader.load(getClass().getResource("MyUpload.fxml"));
        Scene scene = new Scene(roots);
        Stage primaryStage = (Stage)this.logoutButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File f = new File("./resources/logo.png");
        this.logo.setImage(new Image("File://" + f.toURI().getPath()));
        setImageInOrder();
    }

    public void setImageInOrder(){

        int cnt = 0;
        HBox hbox = null;
        int size = Utility.currentUser.getUsersImage().size();
        while(cnt < Utility.currentUser.getUsersImage().size()){
            if (cnt % 3 == 0){
                hbox = new HBox();
                hbox.setPadding(new Insets(20, 0, 0 ,0));
                hbox.setSpacing(20);
                vBox.getChildren().add(hbox);
            }
            ImageView imageView = new ImageView();
            Image image = new Image(Utility.currentUser.getUsersImage().get(size - cnt - 1).getPhotoPath());
            imageView.setImage(image);
            imageView.setFitWidth(200);
            imageView.setFitHeight(250);
            int finalCnt = cnt;
            imageView.setOnMouseClicked(new EventHandler() {
                @Override
                public void handle(Event event) {
                    try {
                        ViewController.getImage(Utility.currentUser.getUsersImage().get(size - finalCnt - 1));
                        FXMLLoader loader = new FXMLLoader(Utility.class.getResource("View.fxml"));
                        AnchorPane root = (AnchorPane) loader.load();
                        Stage currentStage = (Stage) imageView.getScene().getWindow();
                        Stage errorStage = new Stage();
                        Scene newScene = new Scene(root);
                        errorStage.setScene(newScene);
                        errorStage.sizeToScene();
                        errorStage.initOwner(currentStage);
                        errorStage.initModality(Modality.APPLICATION_MODAL);
                        errorStage.setResizable(false);
                        errorStage.showAndWait();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            hbox.getChildren().add(imageView);
            cnt++;
        }
    }
}
