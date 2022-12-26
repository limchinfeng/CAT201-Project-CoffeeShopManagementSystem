import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class LoginGui extends Application {

    public void start(Stage primaryStage) throws Exception {
        login(primaryStage);
    }

    public static void login(Stage primaryStage) {

        Stage stage = new Stage();
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setStyle("-fx-background-color: #ecf4f4");



        //Add the pane to the scene and add the scene to the stage
        Scene scene = new Scene(pane, 700, 500);
        primaryStage.setTitle("Login System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
