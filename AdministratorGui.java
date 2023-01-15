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

public class AdministratorGui {
    public static void main(ArrayList<Administrator> administrator) {

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
        Text title = new Text(320, 100, "Administrator Section");
        title.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 25));

        /**Button Section**/
        HBox AdministratorMenu = new HBox(10);
        Button newAdministrator = new Button("Add New Admin", new ImageView("Images/add.png"));
        Button showAdministratorList = new Button("Administrator List", new ImageView("Images/list.png"));
        Button deleteAdministrator = new Button("Delete Admin",new ImageView("Images/delete.png"));
        Button printAdministrator = new Button("Print",new ImageView("Images/txt.png"));
        Button mainMenu = new Button("Back to Menu", new ImageView("Images/home.png"));
        newAdministrator.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        showAdministratorList.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        deleteAdministrator.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        printAdministrator.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
        AdministratorMenu.getChildren().addAll(newAdministrator, showAdministratorList,deleteAdministrator,printAdministrator);
        AdministratorMenu.setAlignment(Pos.CENTER);

        header.getChildren().addAll(line1, title, line2, AdministratorMenu);
        pane.setTop(header);
        pane.setBottom(mainMenu);


        /** Scene to prompt the user to enter the new administrator's details **/
        GridPane administratorPrompt = new GridPane();
        administratorPrompt.setPadding(new Insets(20));
        administratorPrompt.setHgap(5);
        administratorPrompt.setVgap(5);

        TextField usrn = new TextField();
        TextField pswd = new TextField();
        Button btAdd = new Button("Add Administrator");

        administratorPrompt.add(new Text("Key in the Administrator's details"), 0, 0);
        administratorPrompt.add(new Label("Enter username: "), 0, 1);
        administratorPrompt.add(usrn, 1, 1);
        administratorPrompt.add(new Label("Enter password: "), 0, 2);
        administratorPrompt.add(pswd, 1, 2);
        administratorPrompt.add(btAdd, 1, 3);

        Scene addaAdministratorScene = new Scene(administratorPrompt);


        /**Scene to delete administrator record**/
        GridPane delAdministrator = new GridPane();
        delAdministrator.setPadding(new Insets(20));
        delAdministrator.setHgap(5);
        delAdministrator.setVgap(5);

        TextField delname = new TextField();
        Button btDel = new Button("Delete");

        delAdministrator.add(new Text("Please enter the username to be deleted"), 0, 0);
        delAdministrator.add(delname, 0, 1);
        delAdministrator.add(btDel, 0, 2);

        Scene delAdministratorScene = new Scene(delAdministrator);


        /** Action listener to add new administrator **/
        newAdministrator.setOnAction(e->{

            promptStage.setScene(addaAdministratorScene);
            promptStage.setTitle("Administrator Details");
            promptStage.show();

            btAdd.setOnAction(ev->{

                int u = Integer.parseInt(usrn.getText());
                int p = Integer.parseInt(pswd.getText());
                administrator.add(new Administrator(u,p));
                JOptionPane.showMessageDialog(null, "The new Administrator's record have been added to "
                        + "the list. You can check the list by clicking the Existing Administrators List button");
                promptStage.close();
            });
        });


        /** Action listener to show all the administrator in table**/
        showAdministratorList.setOnAction(e->{

            /**Table view of Administrator's details**/
            TableView<Administrator> AdministratorTable = new TableView<Administrator>();
            TableColumn<Administrator, Integer> column1 = new TableColumn<Administrator, Integer>("Username");
            column1.setCellValueFactory(new PropertyValueFactory<Administrator, Integer>("username"));
            column1.setPrefWidth(340);
            column1.setResizable(false);

            TableColumn<Administrator, Integer> column2 = new TableColumn<Administrator, Integer>("Password");
            column2.setCellValueFactory(new PropertyValueFactory<Administrator, Integer>("password"));
            column2.setPrefWidth(330);
            column2.setResizable(false);

            AdministratorTable.getColumns().addAll(column1, column2);


            for(int i = 0; i < administrator.size(); i ++) {
                AdministratorTable.getItems().add(administrator.get(i));
            }

            VBox table = new VBox(AdministratorTable);
            table.setPadding(new Insets(8));
            pane.setCenter(table);
        });


        /** Action listener to delete administrator record**/
        deleteAdministrator.setOnAction(e->{
            promptStage.setScene(delAdministratorScene);
            promptStage.setTitle("Delete Record");
            promptStage.show();

            btDel.setOnAction(ev->{
                int index;
                for(int i = 0; i < administrator.size() ; i++) {
                    if (administrator.get(i).getUsername() == Integer.parseInt(delname.getText())) {
                        index = i;
                        administrator.remove(index);
                    }
                }
                JOptionPane.showMessageDialog(null, "The specific Administrator's record have been deleted from "
                        + "the list. You can check the list by clicking the Existing Administrators List button");
                promptStage.close();
            });
        });


        /** Action listener to print all the administrator in txt file**/
        printAdministrator.setOnAction(e->{
            try {
                FileWriter writefile = new FileWriter("txt/Administrator Record.txt");

                for(int i = 0; i < administrator.size() ; i++) {
                    writefile.write(administrator.get(i).getUsername()+"\t"+administrator.get(i).getPassword()+"\n");
                }

                writefile.close();
                JOptionPane.showMessageDialog(null, "Successfully write information into the text file.");
            }

            catch (IOException ev) {
                JOptionPane.showMessageDialog(null, "An error occured when writing into the file.");
                ev.printStackTrace();
            }
        });


        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Administrator Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
