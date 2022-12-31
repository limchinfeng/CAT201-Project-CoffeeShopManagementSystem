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


        ToggleGroup coffeeGroup = new ToggleGroup();
        RadioButton [] coffeeButton = new RadioButton[10];
        Text coffeeTitle = new Text(320, 100, "Coffee");
        Text coffeePrice = new Text(320, 100, "refer to coffee button");
        coffeeTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 23));
        coffeePrice.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        coffeeColumn.getChildren().addAll(coffeeTitle,coffeePrice);
        for (int j = 0; j < coffee.size(); j++)
        {
            coffeeButton[j] = new RadioButton(coffee.get(j).getCoffee());
            coffeeButton[j].setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
            coffeeColumn.getChildren().add(coffeeButton[j]);
            coffeeButton[j].setToggleGroup(coffeeGroup);
        }

        String [] size = {"Small","Medium","Large"};
        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton [] sizeButton = new RadioButton[10];
        Text sizeTitle = new Text(320, 100, "Size");
        Text sizePrice = new Text(320, 100, "S+RM0,M+RM2,L+RM4");
        sizeTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 23));
        sizePrice.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        sizeColumn.getChildren().addAll(sizeTitle,sizePrice);
        for (int j = 0; j < size.length; j++)
        {
            sizeButton[j] = new RadioButton(size[j]);
            sizeButton[j].setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
            sizeColumn.getChildren().add(sizeButton[j]);
            sizeButton[j].setToggleGroup(sizeGroup);
        }

        String [] type = {"Hot","Cold"};
        ToggleGroup typeGroup = new ToggleGroup();
        RadioButton [] typeButton = new RadioButton[10];
        Text typeTitle = new Text(320, 100, "Type");
        Text typePrice = new Text(320, 100, "H+RM0, C+RM0");
        typeTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 23));
        typePrice.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        typeColumn.getChildren().addAll(typeTitle,typePrice);
        for (int j = 0; j < type.length; j++)
        {
            typeButton[j] = new RadioButton(type[j]);
            typeButton[j].setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
            typeColumn.getChildren().add(typeButton[j]);
            typeButton[j].setToggleGroup(typeGroup);
        }

        String [] addOn = {"Caramel","Mocha","Double Chocolate","Strawberry",
                "Whipped Cream","Chocolate Syrup","Berries"};
        RadioButton [] addOnButton = new RadioButton[10];
        Text addOnTitle = new Text(320, 100, "Add On");
        Text addOnPrice = new Text(320, 100, "+RM1 each");
        addOnTitle.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 23));
        addOnPrice.setFont(Font.font("Courier", FontWeight.LIGHT, FontPosture.REGULAR, 10));
        addOnColumn.getChildren().addAll(addOnTitle,addOnPrice);
        for (int j = 0; j < addOn.length; j++)
        {
            addOnButton[j] = new RadioButton(addOn[j]);
            addOnButton[j].setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
            addOnColumn.getChildren().add(addOnButton[j]);
        }


        Button mainMenu = new Button("Back to Menu", new ImageView("Images/home.png"));

        showCoffee.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        deleteOrder.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        orderCoffee.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        printOrder.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        addOrder.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        orderPayment.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        orderMenu.getChildren().addAll(deleteOrder,showCoffee,orderCoffee, printOrder,addOrder,orderPayment);
        orderMenu.setAlignment(Pos.CENTER);

        header.getChildren().addAll(line1, title, line2, orderMenu);
        pane.setTop(header);
        centre.getChildren().addAll(coffeeColumn, sizeColumn, typeColumn,addOnColumn );
        pane.setCenter(centre);
        pane.setBottom(mainMenu);
    }
}
