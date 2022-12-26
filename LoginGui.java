import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LoginGui extends Application {

    public void start(Stage primaryStage) throws Exception {
        login(primaryStage);
    }

    public static void login(Stage primaryStage) {

        Stage stage = new Stage();
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));
        pane.setStyle("-fx-background-color: #ecf4f4");

        /**Header Section**/
        VBox header = new VBox(5);
        header.setPadding(new Insets(10));
        header.setAlignment(Pos.CENTER);

        HBox hb = new HBox(350);
        Separator line1 = new Separator();
        Separator line2 = new Separator();
        Text title = new Text(320, 100, "*****  CAT201 Project - Coffee Shop Management System  *****");
        title.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Get current date
        Date date = new Date();
        String timeFormatString = "hh:mm:ss";
        DateFormat timeFormat = new SimpleDateFormat(timeFormatString);
        String currentTime = timeFormat.format(date);

        //Get current time
        String dateFormatString = "MMM d yyyy";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        String currentDate = dateFormat.format(date);

        //
        Label dateNow = new Label(currentDate, new ImageView("Images/date.png"));
        Label time = new Label(currentTime, new ImageView("Images/time.png"));
        dateNow.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 18));
        time.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 18));
        hb.getChildren().addAll(dateNow, time);
        hb.setAlignment(Pos.CENTER);

        Text lg = new Text("Login");
        lg.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 40));

        header.getChildren().addAll(line1, title, line2, hb, lg);
        pane.setTop(header);

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
