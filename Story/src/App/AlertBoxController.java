package App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlertBoxController {

    @FXML
    private Button closeButton;

    @FXML
    private Text errorText;

    private String globalMessage;

    @FXML
    void closeButtonClicked(MouseEvent event) {
        Stage currentStage = (Stage) this.closeButton.getScene().getWindow();
        currentStage.close();
    }


    public void passMessage(String message) {
        globalMessage = message;
        this.errorText.setText(message);
    }

}
