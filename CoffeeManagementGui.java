import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CoffeeManagementGui {

    public static ArrayList<OrderList> orderlist = new ArrayList<OrderList>(25);
    public static ArrayList<Coffee> coffee = new ArrayList<Coffee>(20);
    public static void mainMenu(Stage primaryStage) {

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

        Label dateNow = new Label(currentDate, new ImageView("Images/date.png"));
        Label time = new Label(currentTime, new ImageView("Images/time.png"));
        dateNow.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 18));
        time.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 18));
        hb.getChildren().addAll(dateNow, time);
        hb.setAlignment(Pos.CENTER);

        Text menu = new Text("Menu");
        menu.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 23));

        header.getChildren().addAll(line1, title, line2, hb, menu);
        pane.setTop(header);

        /**Menu's Choice Section**/
        GridPane menuSec = new GridPane();
        menuSec.setPadding(new Insets(30));
        menuSec.setAlignment(Pos.TOP_CENTER);
        menuSec.setHgap(20);
        menuSec.setVgap(20);

        DropShadow shadow = new DropShadow();

        Button[] menuChoice = {new Button("Order", new ImageView("Images/order.png")),
                new Button("Order List", new ImageView("Images/orderlist.png")),
                new Button("Coffee", new ImageView("Images/coffee.png")),
                new Button("Staff", new ImageView("Images/staff.png")),
                new Button("Administrator", new ImageView("Images/administrator.png")),
                new Button("Exit Program", new ImageView("Images/exit.png"))};

        Button exit = new Button("Exit Program", new ImageView("Images/exit.png"));

        for(int j = 0; j < menuChoice.length; j++ ) {
            menuChoice[j].setFont(Font.font("Courier", FontWeight.BOLD , FontPosture.REGULAR, 15));
            menuChoice[j].setPrefSize(150, 60);
        }

        menuSec.add(menuChoice[0], 0, 0);
        menuSec.add(menuChoice[1], 0, 1);
        menuSec.add(menuChoice[2], 1, 0);
        menuSec.add(menuChoice[3], 1, 1);
        menuSec.add(menuChoice[4], 2, 0);
        menuSec.add(menuChoice[5], 2, 1);
        pane.setCenter(menuSec);
//		pane.setBottom(exit);

        /**Choice 1: Order**/
        //When user move the mouse to the button will have shadow effect
        menuChoice[0].addEventHandler(MouseEvent.MOUSE_ENTERED, e->{
            menuChoice[0].setEffect(shadow);
        });

        menuChoice[0].addEventHandler(MouseEvent.MOUSE_EXITED, e->{
            menuChoice[0].setEffect(null);
        });

        menuChoice[0].setOnAction(e->{
            primaryStage.close();
            OrderGui.main(orderlist, coffee);
        });

        //Add the pane to the scene and add the scene to the stage
        Scene scene = new Scene(pane, 700, 500);
        primaryStage.setTitle("Coffee Shop Management System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}