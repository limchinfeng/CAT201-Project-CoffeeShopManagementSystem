import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrderListGui {

    private static int index;
    @SuppressWarnings("unchecked")
    public static void main(ArrayList<OrderList> orderlist) {

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
        Text title = new Text(320, 100, "Order List Section");
        title.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 25));

        /**Button Section**/
        HBox orderListMenu = new HBox(10);
        Button newOrderRecord = new Button("Add New Order", new ImageView("Images/add.png"));
        Button showOrderList = new Button("Existing Order List", new ImageView("Images/list.png"));
        Button delOrderRecord = new Button("Delete Order Record",new ImageView("Images/delete.png"));
        Button PrintOrderList = new Button("Print",new ImageView("Images/txt.png"));
        Button mainMenu = new Button("Back to Menu", new ImageView("Images/home.png"));
        newOrderRecord.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        showOrderList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        delOrderRecord.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        PrintOrderList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        orderListMenu.getChildren().addAll(newOrderRecord, showOrderList,delOrderRecord,PrintOrderList);
        orderListMenu.setAlignment(Pos.CENTER);


        header.getChildren().addAll(line1, title, line2, orderListMenu);
        pane.setTop(header);

        HBox bottom = new HBox(5);
        bottom.getChildren().add(mainMenu);
        pane.setBottom(bottom);


        //To prompt staff's details from the user
        GridPane addOrderprompt = new GridPane();
        addOrderprompt.setPadding(new Insets(20));
        addOrderprompt.setHgap(5);
        addOrderprompt.setVgap(5);

        TextField cf = new TextField();
        TextField size = new TextField();
        TextField type = new TextField();
        TextField add = new TextField();
        TextField price = new TextField();
        Button btAdd = new Button("Add New Order");

        addOrderprompt.add(new Text("Key in the order's details"), 0, 0);
        addOrderprompt.add(new Label("Enter coffee name: "), 0, 1);
        addOrderprompt.add(cf, 1, 1);
        addOrderprompt.add(new Label("Enter coffee size: "), 0, 2);
        addOrderprompt.add(size, 1, 2);
        addOrderprompt.add(new Label("Enter coffee type: "), 0, 3);
        addOrderprompt.add(type, 1, 3);
        addOrderprompt.add(new Label("Enter coffee add on: "), 0, 4);
        addOrderprompt.add(add, 1, 4);
        addOrderprompt.add(new Label("Enter coffee price: "), 0, 5);
        addOrderprompt.add(price, 1, 5);
        addOrderprompt.add(btAdd, 1, 6);

        Scene addOrderpromptScene = new Scene(addOrderprompt);
    }
}
