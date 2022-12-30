import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrderGui {

    private static int index;
    public static void main(ArrayList<OrderList> orderlist, ArrayList<Coffee> coffee) {

        ArrayList<Order> order = new ArrayList<Order>(25);

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
        Text title = new Text(320, 100, "Order Section");
        title.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 25));


        /**Button Section**/
        HBox orderMenu = new HBox(10);
        VBox coffeeColumn = new VBox(20);
        VBox sizeColumn = new VBox(20);
        VBox typeColumn = new VBox(20);
        VBox addOnColumn = new VBox(20);
        Button deleteOrder = new Button("Delete", new ImageView("Images/delete.png"));
        Button showCoffee = new Button("Coffee", new ImageView("Images/coffee.png"));
        Button orderCoffee = new Button("Order", new ImageView("Images/menu.png"));
        Button printOrder = new Button("Current Order", new ImageView("Images/list.png"));
        Button addOrder = new Button("Add",new ImageView("Images/add.png"));
        Button orderPayment = new Button("Payment",new ImageView("Images/payment.png"));

        /**Center Section**/
        HBox centre = new HBox(10);
        centre.setSpacing(50);
        centre.setAlignment(Pos.CENTER);

    }
}
