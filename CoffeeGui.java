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


        //To prompt staff's details from the user
        GridPane coffeePrompt = new GridPane();
        coffeePrompt.setPadding(new Insets(20));
        coffeePrompt.setHgap(5);
        coffeePrompt.setVgap(5);

        TextField cf = new TextField();
        TextField price = new TextField();
        Button btAdd = new Button("Add Coffee");

        coffeePrompt.add(new Text("Key in the coffee's details"), 0, 0);
        coffeePrompt.add(new Label("Enter coffee name: "), 0, 1);
        coffeePrompt.add(cf, 1, 1);
        coffeePrompt.add(new Label("Enter coffee price: "), 0, 2);
        coffeePrompt.add(price, 1, 2);
        coffeePrompt.add(btAdd, 1, 3);

        Scene addCoffeeScene = new Scene(coffeePrompt);


        //Delete Coffee details from the user input
        GridPane delCoffee = new GridPane();
        delCoffee.setPadding(new Insets(20));
        delCoffee.setHgap(5);
        delCoffee.setVgap(5);

        TextField delname = new TextField();
        Button btDel = new Button("Delete");

        delCoffee.add(new Text("Please enter the coffee name to be deleted"), 0, 0);
        delCoffee.add(delname, 0, 1);
        delCoffee.add(btDel, 0, 2);

        Scene delCoffeeScene = new Scene(delCoffee);


        newCoffee.setOnAction(e->{

            promptStage.setScene(addCoffeeScene);
            promptStage.setTitle("Coffee Details");
            promptStage.show();

            btAdd.setOnAction(ev->{
                String c = cf.getText();
                double p = Double.parseDouble(price.getText());
                coffee.add(new Coffee(c,p));
                JOptionPane.showMessageDialog(null, "The new Coffee's record have been added to "
                        + "the list. You can check the list by clicking the Existing Coffees List button");
                promptStage.close();
            });
        });


        showCoffeeList.setOnAction(e->{

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


        deleteCoffee.setOnAction(e->{
            promptStage.setScene(delCoffeeScene);
            promptStage.setTitle("Delete Record");
            promptStage.show();

            btDel.setOnAction(ev->{
                for(int i = 0; i < coffee.size() ; i++) {
                    if (coffee.get(i).getCoffee().equals(delname.getText())) {
                        index = i;
                        coffee.remove(index);
                    }
                }
                JOptionPane.showMessageDialog(null, "The specific Coffee's record have been deleted from "
                        + "the list. You can check the list by clicking the Existing Coffees List button");
                promptStage.close();
            });
        });
    }
}
