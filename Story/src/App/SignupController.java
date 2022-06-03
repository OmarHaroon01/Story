package App;

import Properties.User;
import Utilities.DataValidator;
import Utilities.Serializer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordFiled;

    @FXML
    private RadioButton maleButton;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton femaleButton;

    @FXML
    private Button signupButton;

    @FXML
    private Text loginPage;

    @FXML
    void loginPageClicked(MouseEvent event) throws IOException {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)this.loginPage.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Story");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void signupButtonClicked(MouseEvent event) {
        String fullName = this.fullNameField.getText(), userName = this.usernameField.getText(),
                email = this.emailField.getText(), password = this.passwordField.getText(),
                confirmPassword = this.confirmPasswordFiled.getText(), gender = null;
        if(maleButton.isSelected()){
            gender = "Male";
        } else if (femaleButton.isSelected()){
            gender = "Female";
        }
        try{
            DataValidator.validateNewUser(fullName, userName, email, password, confirmPassword, gender);
            User newUser = new User(fullName, userName, email, gender, password);

            Serializer.userList.add(newUser);
            Serializer.serialize();

            Stage currentStage = (Stage) this.femaleButton.getScene().getWindow();
            Utility.errorMessageHelper(currentStage, "Account created Successfully!!");

            loginPageClicked(null);

        }catch (Exception e){
            Stage currentStage = (Stage) this.femaleButton.getScene().getWindow();
            Utility.errorMessageHelper(currentStage, e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image background = new Image(getClass().getResourceAsStream("bg1.jpg"));
        backgroundImageView.setImage(background);
    }
}
