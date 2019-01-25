package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GraphicalView extends Application {

    @Override
    public void start(Stage root) throws Exception {
        TilePane tile = new TilePane();
        Scene scene = new Scene(tile);

        // Configures the stage such that it is properly bordered and has restrictions
        root.setTitle("Codenames Game");
        root.setResizable(false);
        root.setScene(scene);

        // Creates the background colour for the scene
        scene.setFill(Paint.valueOf("877567"));

        // Configures the pane inside of the scene and pads appropriately
        tile.setPadding(new Insets(4, 4, 4, 4));
        tile.setVgap(4);
        tile.setHgap(4);
        tile.setPrefColumns(5);

        // Creates the children panes inside of the TilePane (parent) with 25 segments
        for (int i = 0; i < 25; i++) {
            StackPane stack = new StackPane();
            Text text = new Text("Null");
            ImageView imageview = new ImageView(new Image("/resources/CardTemplate.png"));
            stack.getChildren().addAll(imageview, text);
            tile.getChildren().add(stack);
            stack.setMargin(text, new Insets(15, 15, 15, 15));
            stack.setAlignment(text, Pos.BOTTOM_CENTER);
        }

        // Shows the final Scene onto the Stage
        root.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
