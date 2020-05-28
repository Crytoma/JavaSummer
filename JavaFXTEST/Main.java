package JavaFXTEST;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    Button button1;

    public static void main(String[] args) 
    {
        launch(args);
    }

  //  --module-path C:\Users\User\Desktop\Java_Files\javafx-sdk-14.0.1\lib --add-modules=javafx.controls


/*
JavaFX:
The window is called the STAGE.
Content inside the STAGE is the SCENE.
*/

    @Override
    public void start(Stage primaryStage) throws Exception 
    {

        primaryStage.setTitle("Basic Window Title");
        button1 = new Button();
        button1.setText("Click the button");

        StackPane layout = new StackPane();
        layout.getChildren().add(button1);

        Scene scene = new Scene(layout, 300, 250);

        primaryStage.setScene(scene);

        primaryStage.show();

    }
}