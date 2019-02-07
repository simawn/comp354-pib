package view;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VerboseView {
    private static VerboseView viewer = new VerboseView();
    private VBox vbox;
    private Stage stage;

    private VerboseView() {
        ScrollPane pane = new ScrollPane();

        vbox = new VBox();

        vbox.getChildren().add(new Text("Game Started"));
        vbox.setFillWidth(true);
        pane.setContent(vbox);

        Scene scene = new Scene(pane, 500, 500);
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.V) {
                open();
            }
        });

        pane.vvalueProperty().bind(vbox.heightProperty());

        stage = new Stage();
        stage.setTitle("Codenames - Verbose");
        stage.setScene(scene);
    }

    public static void log(String arg) {
        Text t = new Text(arg);
        if (arg.contains("Blue")) {
            t.setFill(Color.BLUE);
        } else if (arg.contains("Red")) {
            t.setFill(Color.RED);
        }
        viewer.vbox.getChildren().add(t);
    }

    public static void open() {
        if (!viewer.stage.isShowing()) {
            viewer.stage.show();
        } else {
            viewer.stage.hide();
        }
    }
}
