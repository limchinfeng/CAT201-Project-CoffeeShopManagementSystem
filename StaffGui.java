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

    private static int index;
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
        Button showStaffList = new Button("Existing Staffs List", new ImageView("Images/list.png"));
        Button delStaff = new Button("Delete staff Record", new ImageView("Images/delete.png"));
        Button printStaffList = new Button("Print", new ImageView("Images/txt.png"));
        Button mainMenu = new Button("Back to Menu", new ImageView("Images/home.png"));

        newStaff.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        showStaffList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        delStaff.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        printStaffList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        staffMenu.getChildren().addAll(newStaff, showStaffList, delStaff, printStaffList);
        staffMenu.setAlignment(Pos.CENTER);

        header.getChildren().addAll(line1, title, line2, staffMenu);
        pane.setTop(header);
        pane.setBottom(mainMenu);

        //To prompt staff's details from the user
        GridPane staffPrompt = new GridPane();
        staffPrompt.setPadding(new Insets(20));
        staffPrompt.setHgap(5);
        staffPrompt.setVgap(5);

        TextField id = new TextField();
        TextField name = new TextField();
        TextField designation = new TextField();
        TextField sex = new TextField();
        TextField salary = new TextField();
        Button btAdd = new Button("Add staff");

        staffPrompt.add(new Text("Key in the staff's details"), 0, 0);
        staffPrompt.add(new Label("Enter Staff ID: "), 0, 1);
        staffPrompt.add(id, 1, 1);
        staffPrompt.add(new Label("Enter Staff Name: "), 0, 2);
        staffPrompt.add(name, 1, 2);
        staffPrompt.add(new Label("Enter Staff Designation: "), 0, 3);
        staffPrompt.add(designation, 1, 3);
        staffPrompt.add(new Label("Enter Staff Sex: "), 0, 4);
        staffPrompt.add(sex, 1, 4);
        staffPrompt.add(new Label("Enter Staff Salary: "), 0, 5);
        staffPrompt.add(salary, 1, 5);
        staffPrompt.add(btAdd, 1, 6);

        Scene addStaffPromptScene = new Scene(staffPrompt);

        //To prompt staff detail to be deleted
        GridPane deleteStaff = new GridPane();
        deleteStaff.setPadding(new Insets(20));
        deleteStaff.setHgap(5);
        deleteStaff.setVgap(5);

        TextField delname = new TextField();
        Button btDel = new Button("Delete");

        deleteStaff.add(new Text("Please enter the staff's ID to be deleted"), 0, 0);
        deleteStaff.add(delname, 0, 1);
        deleteStaff.add(btDel, 0, 2);

        Scene delStaffScene = new Scene(deleteStaff);

        newStaff.setOnAction(e->{

            promptStage.setScene(addStaffPromptScene);
            promptStage.setTitle("Staff Details");
            promptStage.show();

            btAdd.setOnAction(ev->{
                String Id = id.getText();
                String n = name.getText();
                String d = designation.getText();
                String s = sex.getText();
                int sly = Integer.parseInt(salary.getText());
                staff.add(new Staff(Id,n,d,s,sly));
                JOptionPane.showMessageDialog(null, "The new staff's record have been added to "
                        + "the list. You can check the list by clicking the Existing Staffs List button");
                promptStage.close();
            });
        });

        showStaffList.setOnAction(e->{

            /**Table view of staff's details**/
            TableView<Staff> staffTable = new TableView<Staff>();
            TableColumn<Staff, String> column1 = new TableColumn<Staff, String>("ID");
            column1.setCellValueFactory(new PropertyValueFactory<Staff, String>("id"));
            column1.setPrefWidth(70);
            column1.setResizable(false);

            TableColumn<Staff, String> column2 = new TableColumn<Staff, String>("Name");
            column2.setCellValueFactory(new PropertyValueFactory<Staff, String>("name"));
            column2.setPrefWidth(200);
            column2.setResizable(false);

            TableColumn<Staff, String> column3 = new TableColumn<Staff, String>("Designation");
            column3.setCellValueFactory(new PropertyValueFactory<Staff, String>("designation"));
            column3.setPrefWidth(140);
            column3.setResizable(false);

            TableColumn<Staff, String> column4 = new TableColumn<Staff, String>("Sex");
            column4.setCellValueFactory(new PropertyValueFactory<Staff, String>("sex"));
            column4.setPrefWidth(130);
            column4.setResizable(false);

            TableColumn<Staff, Integer> column5 = new TableColumn<Staff, Integer>("Salary");
            column5.setCellValueFactory(new PropertyValueFactory<Staff, Integer>("salary"));
            column5.setPrefWidth(130);
            column5.setResizable(false);

            staffTable.getColumns().addAll(column1, column2, column3, column4, column5);


            for(int i = 0; i < staff.size(); i ++) {
                staffTable.getItems().add(staff.get(i));
            }


            VBox table = new VBox(staffTable);
            table.setPadding(new Insets(8));
            pane.setCenter(table);
        });
        
        delStaff.setOnAction(e->{
            promptStage.setScene(delStaffScene);
            promptStage.setTitle("Delete Record");
            promptStage.show();

            btDel.setOnAction(ev->{
                for(int i = 0; i < staff.size() ; i++) {
                    if (staff.get(i).getId().equals(delname.getText())) {
                        index = i;
                        staff.remove(index);
                    }
                }
                JOptionPane.showMessageDialog(null, "The specific staff's record have been deleted from "
                        + "the list. You can check the list by clicking the Existing Staffs List button");
                promptStage.close();
            });
        });

        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Order Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
