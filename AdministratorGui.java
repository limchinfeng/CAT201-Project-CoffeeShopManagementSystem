import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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


        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Administrator Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
