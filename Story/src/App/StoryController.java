package App;

import Utilities.DataValidator;
import Utilities.Serializer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoryController implements Initializable {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label captchaLabel;

    @FXML
    private TextField captchaField;

    @FXML
    private Button loginButton;

    @FXML
    private Text signupPage;


    @FXML
    void loginButtonClicked(MouseEvent event) {
        String userName = this.usernameField.getText();
        String password = this.passwordField.getText();
        String captchaField = this.captchaField.getText();

        try{
            DataValidator.validateLogin(userName,password, captchaField, this.captchaLabel.getText());
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Profile.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage)this.loginButton.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.setTitle("Story");
            primaryStage.sizeToScene();
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            Stage currentStage = (Stage) this.loginButton.getScene().getWindow();
            Utility.errorMessageHelper(currentStage, e.getMessage());
            this.captchaLabel.setText(captchaGenerator());
            e.printStackTrace();
        }
    }

    @FXML
    void signupPageClicked(MouseEvent event) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.loginButton.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private static String captchaGenerator(){
        String captcha = "";

        for (int i = 0; i < 5; i++){
            captcha += (char)((Math.random() * 26) + 'A');
        }

        return captcha;

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image background = new Image(getClass().getResourceAsStream("bg1.jpg"));
        backgroundImageView.setImage(background);

        Serializer.initializeDatabase();



        this.captchaLabel.setText(captchaGenerator());

    }
}
