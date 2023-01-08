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


        //Delete lab details from the user input
        GridPane delOrder = new GridPane();
        delOrder.setPadding(new Insets(20));
        delOrder.setHgap(5);
        delOrder.setVgap(5);

        TextField delname = new TextField();
        Button btDel = new Button("Delete");

        delOrder.add(new Text("Please enter the order list index to be deleted"), 0, 0);
        delOrder.add(delname, 0, 1);
        delOrder.add(btDel, 0, 2);

        Scene delOrderScene = new Scene(delOrder);

        newOrderRecord.setOnAction(e->{

            promptStage.setScene(addOrderpromptScene);
            promptStage.setTitle("New Order Details");
            promptStage.show();

            btAdd.setOnAction(ev->{
                double p=0;
                String c="", t="", s="", a=".";
                c = cf.getText();
                s = size.getText();
                t = type.getText();
                a = add.getText();
                p = Double.parseDouble(price.getText());
                orderlist.add(new OrderList(c,s,t,a,p));
                JOptionPane.showMessageDialog(null, "The new order's record have been added to "
                        + "the list. You can check the list by clicking the Existing Orders List button");
                promptStage.close();
            });
        });

        showOrderList.setOnAction(e->{

            /**Table view of order list's details**/
            TableView<OrderList> OrderListTable = new TableView<OrderList>();

            TableColumn<OrderList, Integer> column1 = new TableColumn<OrderList, Integer>("Index");
            column1.setCellValueFactory(new PropertyValueFactory<OrderList, Integer>("index"));
            column1.setPrefWidth(50);
            column1.setResizable(false);

            TableColumn<OrderList, String> column2 = new TableColumn<OrderList, String>("Coffee");
            column2.setCellValueFactory(new PropertyValueFactory<OrderList, String>("coffee"));
            column2.setPrefWidth(140);
            column2.setResizable(false);

            TableColumn<OrderList, String> column3 = new TableColumn<OrderList, String>("Size");
            column3.setCellValueFactory(new PropertyValueFactory<OrderList, String>("size"));
            column3.setPrefWidth(100);
            column3.setResizable(false);

            TableColumn<OrderList, String> column4 = new TableColumn<OrderList, String>("Type");
            column4.setCellValueFactory(new PropertyValueFactory<OrderList, String>("type"));
            column4.setPrefWidth(100);
            column4.setResizable(false);

            TableColumn<OrderList, String> column5 = new TableColumn<OrderList, String>("Add On");
            column5.setCellValueFactory(new PropertyValueFactory<OrderList, String>("add"));
            column5.setPrefWidth(180);
            column5.setResizable(false);

            TableColumn<OrderList, Double> column6 = new TableColumn<OrderList, Double>("Price");
            column6.setCellValueFactory(new PropertyValueFactory<OrderList, Double>("price"));
            column6.setPrefWidth(100);
            column6.setResizable(false);

            OrderListTable.getColumns().addAll(column1, column2, column3, column4, column5, column6);

            for(int i = 0; i < orderlist.size(); i ++) {
                OrderListTable.getItems().add(orderlist.get(i));
            }

            String TotalAmount="";
            if(orderlist.isEmpty())
            {
                TotalAmount = "Total : RM0.00";
            }
            else {
                TotalAmount = "Total : RM" + Double.toString(orderlist.get(0).getTotal());
            }
            Label totalOrderAmount = new Label(TotalAmount, new ImageView("Images/price.png"));

            VBox table = new VBox(5);
            table.setPadding(new Insets(8));
            table.getChildren().addAll(totalOrderAmount,OrderListTable);
            pane.setCenter(table);
        });

        delOrderRecord.setOnAction(e->{
            promptStage.setScene(delOrderScene);
            promptStage.setTitle("Delete Record");
            promptStage.show();

            btDel.setOnAction(ev->{
                for(int i = 0; i < orderlist.size() ; i++) {
                    if (orderlist.get(i).getIndex() == Integer.parseInt(delname.getText())) {
                        index = i;
                        orderlist.get(index).setTotal(orderlist.get(index).getPrice());
                        orderlist.remove(index);
                        JOptionPane.showMessageDialog(null, "The specific order's record have been deleted from "
                                + "the list. You can check the list by clicking the Existing Orders List button");
                        break;
                    }
                }
//                JOptionPane.showMessageDialog(null, "The specific order's record have been deleted from "
//                        + "the list. You can check the list by clicking the Existing Orders List button");
                promptStage.close();
            });
        });


        // write order list to text file
        PrintOrderList.setOnAction(e->{
            try {
                FileWriter writefile = new FileWriter("txt/Order List Record.txt");

                for(int i = 0; i < orderlist.size() ; i++) {
                    writefile.write(orderlist.get(i).getCoffee()+"\t"+ orderlist.get(i).getSize()+"\t"+
                            orderlist.get(i).getType()+"\t"+ orderlist.get(i).getAdd()+"\t"+orderlist.get(i).getPrice()+"\n");
                }

                writefile.close();
                JOptionPane.showMessageDialog(null, "Successfully write information into the text file.");
            }

            catch (IOException ev) {
                JOptionPane.showMessageDialog(null, "An error occurred when writing into the file.");
                ev.printStackTrace();
            }
        });


        mainMenu.setOnAction(e->{
            stage.close();
            CoffeeManagementGui.mainMenu(stage);
        });


        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Order List Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


}