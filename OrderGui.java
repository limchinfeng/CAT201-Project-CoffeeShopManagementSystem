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


        //Payment
        GridPane paymentOrder = new GridPane();
        paymentOrder.setPadding(new Insets(20));
        paymentOrder.setHgap(5);
        paymentOrder.setVgap(5);

        TextField paymentAmount = new TextField();

        Button btPayment = new Button("Pay");
        Button btPrint = new Button("Print");

        paymentOrder.add(new Text("Payment"), 0, 0);
        paymentOrder.add(new Text("Please enter payment amount :RM"), 0, 1);
        paymentOrder.add(paymentAmount, 1, 1);
        paymentOrder.add(btPrint,2,2);
        paymentOrder.add(btPayment, 0, 2);

        Scene paymentScene = new Scene(paymentOrder);

        //Delete Coffee details from the user input
        GridPane delOrder = new GridPane();
        delOrder.setPadding(new Insets(20));
        delOrder.setHgap(5);
        delOrder.setVgap(5);

        TextField delname = new TextField();
        Button btDel = new Button("Delete");

        delOrder.add(new Text("Please enter the order index to be deleted"), 0, 0);
        delOrder.add(delname, 0, 1);
        delOrder.add(btDel, 0, 2);

        Scene delScene = new Scene(delOrder);

        // delete single order
        deleteOrder.setOnAction(e->{

            promptStage.setScene(delScene);
            promptStage.setTitle("Delete Record");
            promptStage.show();

            btDel.setOnAction(ev->{
                for(int i = 0; i < order.size() ; i++) {
                    if (order.get(i).getIndex() == Integer.parseInt(delname.getText())) {
                        index = i;
                        order.get(0).setTotal(order.get(i).getPrice());
                        order.remove(index);
                        JOptionPane.showMessageDialog(null, "The specific Coffee's record have been deleted from "
                                + "the list. You can check the list by clicking the Existing Coffees List button");
                        break;
                    }
                }
                promptStage.close();
            });

        });

        showCoffee.setOnAction(e->{

            /**Table view of Coffee's details**/
            TableView<Coffee> CoffeeTable = new TableView<Coffee>();
            TableColumn<Coffee, String> column1 = new TableColumn<Coffee, String>("Coffee");
            column1.setCellValueFactory(new PropertyValueFactory<Coffee, String>("coffee"));
            column1.setPrefWidth(340);
            column1.setResizable(false);

            TableColumn<Coffee, Integer> column2 = new TableColumn<Coffee, Integer>("Price");
            column2.setCellValueFactory(new PropertyValueFactory<Coffee, Integer>("price"));
            column2.setPrefWidth(330);
            column2.setResizable(false);

            CoffeeTable.getColumns().addAll(column1, column2);

            for(int i = 0; i < coffee.size(); i ++) {
                CoffeeTable.getItems().add(coffee.get(i));
            }

            VBox table = new VBox(CoffeeTable);
            table.setPadding(new Insets(8));
            pane.setCenter(table);

        });

        // show order page
        orderCoffee.setOnAction(e->{
            pane.setCenter(centre);
        });


        // current order
        printOrder.setOnAction(e->{

            /**Table view of order list's details**/
            TableView<Order> OrderTable = new TableView<Order>();

            TableColumn<Order, Integer> column1 = new TableColumn<Order, Integer>("Index");
            column1.setCellValueFactory(new PropertyValueFactory<Order, Integer>("index"));
            column1.setPrefWidth(50);
            column1.setResizable(false);

            TableColumn<Order, String> column2 = new TableColumn<Order, String>("Coffee");
            column2.setCellValueFactory(new PropertyValueFactory<Order, String>("coffee"));
            column2.setPrefWidth(140);
            column2.setResizable(false);

            TableColumn<Order, String> column3 = new TableColumn<Order, String>("Size");
            column3.setCellValueFactory(new PropertyValueFactory<Order, String>("size"));
            column3.setPrefWidth(100);
            column3.setResizable(false);

            TableColumn<Order, String> column4 = new TableColumn<Order, String>("Type");
            column4.setCellValueFactory(new PropertyValueFactory<Order, String>("type"));
            column4.setPrefWidth(100);
            column4.setResizable(false);

            TableColumn<Order, String> column5 = new TableColumn<Order, String>("Add On");
            column5.setCellValueFactory(new PropertyValueFactory<Order, String>("add"));
            column5.setPrefWidth(180);
            column5.setResizable(false);

            TableColumn<Order, Double> column6 = new TableColumn<Order, Double>("Price");
            column6.setCellValueFactory(new PropertyValueFactory<Order, Double>("price"));
            column6.setPrefWidth(100);
            column6.setResizable(false);

            OrderTable.getColumns().addAll(column1, column2, column3, column4, column5, column6);

            for(int i = 0; i < order.size(); i ++) {
                OrderTable.getItems().add(order.get(i));
            }

            String totalPrice="";
            if(order.isEmpty())
            {
                totalPrice = "Total : RM0.00";
            }
            else {
                totalPrice = "Total : RM" + Double.toString(order.get(0).getTotal());
            }

            System.out.println(totalPrice);
            Label totalOrder = new Label(totalPrice, new ImageView("Images/price.png"));

            VBox table = new VBox(5);
            table.setPadding(new Insets(8));
            table.getChildren().addAll(totalOrder, OrderTable);
            pane.setCenter(table);

        });

        // add order
        addOrder.setOnAction(e->{
            double total=0;
            int AddOn = 0;
            String c="", t="", s="", a=".";

            for(int j=0; j<coffee.size(); j++)
            {
                if(coffeeButton[j].isSelected())
                {
                    c = coffeeButton[j].getText();
                    total+= coffee.get(j).getPrice();
                    break;
                }
            }

            for(int j=0; j<type.length; j++)
            {
                if(typeButton[j].isSelected())
                {
                    t = typeButton[j].getText();
                    break;
                }
            }

            for(int j=0; j<size.length; j++)
            {
                if(sizeButton[j].isSelected())
                {
                    s = sizeButton[j].getText();

                    if(s == "Small")
                    {
                        break;
                    }
                    else if(s == "Medium")
                    {
                        total += 2;
                    }
                    else
                    {
                        total += 4;
                    }
                }
            }

            for(int j=0; j<addOn.length; j++)
            {
                if(addOnButton[j].isSelected()) {
                    AddOn += 1;
                    a = addOnButton[j].getText()+","+a;
                }
            }
            total+= AddOn;
            if(total != 0 && c!="" && s!="" && t!="")
                order.add(new Order(c,s,t,a,total));

            System.out.println(c +" "+s+" "+t+" "+a+" "+total);

        });


        orderPayment.setOnAction(e->{
            double total = 0;
            for(int j=0; j< order.size(); j++)
            {
                total += order.get(j).getPrice();
            }

            promptStage.setScene(paymentScene);
            promptStage.setTitle("Payment : RM" + total);
            promptStage.show();

            btPayment.setOnAction(ev->{
                double T=0;
                for(int j=0; j< order.size(); j++)
                {
                    T += order.get(j).getPrice();
                }
                double customerPayment = Double.parseDouble(paymentAmount.getText());
                double remainder = customerPayment - T;
                String c="", t="", s="", a=".";
                double p=0.0;

                if (remainder < 0)
                {
                    JOptionPane.showMessageDialog(null, "Your payment should be more than total price : RM" + T + ". Please pay again");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Thank you! Remainder :RM" + remainder);
                    for(int j=0; j<order.size(); j++)
                    {
                        c = order.get(j).getCoffee();
                        t = order.get(j).getType();
                        s = order.get(j).getSize();
                        a = order.get(j).getAdd();
                        p = order.get(j).getPrice();
                        orderlist.add(new OrderList(c, t, s, a, p));
                    }
                    promptStage.close();
                    stage.close();
                    CoffeeManagementGui.mainMenu(stage);
                }
            });

            btPrint.setOnAction(ev->{
                try {
                    FileWriter writefile = new FileWriter("txt/Order Record.txt");

                    for(int i = 0; i < order.size() ; i++) {
                        writefile.write(order.get(i).getCoffee()+"\t"+ order.get(i).getSize()+"\t"+
                                order.get(i).getType()+"\t"+ order.get(i).getAdd()+"\t"+order.get(i).getPrice()+"\n");
                    }

                    writefile.close();
                    JOptionPane.showMessageDialog(null, "Successfully write information into the text file.");
                }

                catch (IOException err) {
                    JOptionPane.showMessageDialog(null, "An error occurred when writing into the file.");
                    err.printStackTrace();
                }
            });

        });


        mainMenu.setOnAction(e->{
            stage.close();
            CoffeeManagementGui.mainMenu(stage);
        });


        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Order Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    
}
