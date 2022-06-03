package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;

public class Story extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Story.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Story");
            primaryStage.sizeToScene();
            File f = new File("./resources/logo.png");
            primaryStage.getIcons().add(new Image("File://" + f.toURI().getPath()));
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

}
