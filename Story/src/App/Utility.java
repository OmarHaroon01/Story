package App;

import Properties.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Utility {

    public static User currentUser = null;

    public static void errorMessageHelper(Stage parentStage, String message) {
        try {
            FXMLLoader loader = new FXMLLoader(Utility.class.getResource("AlertBox.fxml"));
            AnchorPane root = (AnchorPane) loader.load();
            AlertBoxController alertBoxController = (AlertBoxController)loader.getController();
            alertBoxController.passMessage(message);

            Stage errorStage = new Stage();
            Scene newScene = new Scene(root);
            errorStage.setScene(newScene);
            errorStage.sizeToScene();
            errorStage.initOwner(parentStage);
            errorStage.initModality(Modality.APPLICATION_MODAL);
            errorStage.setResizable(false);
            errorStage.showAndWait();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
