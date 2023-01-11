import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class StaffGui {

    public static void main(ArrayList<Staff> staff) {
        Stage stage = new Stage();
        Stage promptStage = new Stage();


        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        /**Header Section**/
        VBox header = new VBox(5);
        header.setPadding(new Insets(10));
        header.setAlignment(Pos.CENTER);
        Separator line1 = new Separator();
        Separator line2 = new Separator();
        Text title = new Text(320, 100, "Staff Section");
        title.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 25));
//        header.getChildren().addAll(line1, title);

        /**Button Section**/
        HBox staffMenu = new HBox(10);
        Button newStaff = new Button("Add New Staff", new ImageView("Images/add.png"));

        newStaff.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));

        staffMenu.getChildren().addAll(newStaff);
        staffMenu.setAlignment(Pos.CENTER);
        pane.setTop(header);

        header.getChildren().addAll(line1, title, line2, staffMenu);
        pane.setTop(header);
        

        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Order Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
