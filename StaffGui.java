import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
public class StaffGui {
    public static void main(ArrayList<Staff> staff) {
        Stage stage = new Stage();
        Stage promptStage = new Stage();

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        
        pane.setStyle("-fx-background-color: #ecf4f4");
        Scene scene = new Scene(pane, 700, 500);
        stage.setTitle("Order Section");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
