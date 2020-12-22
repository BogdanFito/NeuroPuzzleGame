package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Neuro Puzzle");


        primaryStage.setScene(new Scene(root,1376,768 ));

        primaryStage.getIcons().add(new Image("resources/icon.png"));
        primaryStage.setResizable(false);
        //primaryStage.setMaximized(true);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
