import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class LoginGui extends Application {

    public static ArrayList<Administrator> admin = new ArrayList<Administrator>(25);

    public void start(Stage primaryStage) throws Exception {
        login(primaryStage);
    }

    public static void login(Stage primaryStage) {

        // add test username and password into array list
        if (admin.isEmpty()) {
            admin.add(new Administrator(157968,157968));
            admin.add(new Administrator(123,123));
            admin.add(new Administrator(1,1));
        }

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

        GridPane prompt = new GridPane();
        prompt.setPadding(new Insets(20));
        prompt.setHgap(15);
        prompt.setVgap(15);

        TextField username = new TextField();
        TextField password = new TextField();
        Button btLogin = new Button("Login");
        btLogin.setFont(Font.font("Courier", FontWeight.BOLD , FontPosture.REGULAR, 15));
        btLogin.setPrefSize(100, 50);


        prompt.add(new Label("Username: "), 0, 0);
        prompt.add(username, 1, 0);
        prompt.add(new Label("Password: "), 0, 1);
        prompt.add(password, 1, 1);
        prompt.add(btLogin, 1, 2);

        prompt.setAlignment(Pos.CENTER);
        pane.setCenter(prompt);

        Button exit = new Button("Exit Program", new ImageView("Images/exit.png"));
        pane.setBottom(exit);


        /**Login Button Function**/
        btLogin.setOnAction(ev->{

            try{
                int usrn = Integer.parseInt(username.getText());
                int pswd = Integer.parseInt(password.getText());
                boolean login = false;
                for(int j=0; j<admin.size(); j++)
                {
                    if(admin.get(j).getUsername() == usrn && admin.get(j).getPassword() == pswd)
                    {
                        login = true;
                        break;
                    }
                }

                if(login)
                {
                    primaryStage.close();
                    CoffeeManagementGui.mainMenu(stage);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong ");
                }
            } catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Username and Password should be Integer");
            }
        });


        /** Exit**/
        exit.setOnAction(e -> {
            primaryStage.close();
            CoffeeManagementGui.mainMenu(stage);
        });


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
