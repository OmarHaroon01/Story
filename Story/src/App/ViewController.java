package App;

import Properties.Images;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ImageView image;

    @FXML
    private TextArea caption;

    public static Images img;

    public static void getImage(Images imageReceived){
        img = imageReceived;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image.setImage(new Image(img.getPhotoPath()));
        caption.setText(img.toString());
    }
}
