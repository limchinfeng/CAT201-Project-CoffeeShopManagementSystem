import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

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

public class CoffeeGui {
    private static int index;
    @SuppressWarnings("unchecked")
    public static void main(ArrayList<Coffee> coffee) {

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
        Text title = new Text(320, 100, "Coffee Section");
        title.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 25));

        /**Button Section**/
        HBox CoffeeMenu = new HBox(10);
        Button newCoffee = new Button("Add New Coffee", new ImageView("Images/add.png"));
        Button showCoffeeList = new Button("Existing Coffee List", new ImageView("Images/list.png"));
        Button deleteCoffee = new Button("Delete Coffee Record",new ImageView("Images/delete.png"));
        Button printCoffeeList = new Button("Print",new ImageView("Images/txt.png"));
        Button mainMenu = new Button("Back to Menu", new ImageView("Images/home.png"));
        newCoffee.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        showCoffeeList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        deleteCoffee.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        printCoffeeList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        CoffeeMenu.getChildren().addAll(newCoffee, showCoffeeList,deleteCoffee,printCoffeeList);
        CoffeeMenu.setAlignment(Pos.CENTER);

        header.getChildren().addAll(line1, title, line2, CoffeeMenu);
        pane.setTop(header);
        pane.setBottom(mainMenu);
    }
}
