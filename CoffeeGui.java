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
    }
}
