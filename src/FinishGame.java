import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FinishGame {

	public static void display(Stage stage, int finalScore) {
		Stage window = new Stage();
		window.setTitle("Game Over");
		window.setMinHeight(200);
		window.setMinWidth(200);
		window.initModality(Modality.APPLICATION_MODAL);

		Label label = new Label("You have finished the game !!\nSCORE: " + finalScore);
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		label.setTextAlignment(TextAlignment.CENTER);

		Button close_btn = new Button("Close");
		close_btn.setAlignment(Pos.CENTER);
		close_btn.setOnAction(e -> {
			window.close();
			stage.close();
		});

		/*
		Button tryagain_btn = new Button("Try Again");
		tryagain_btn.setOnAction(e -> {
			Scene newScene = new Scene(parent);
			NextLevel.display(level, stage, newScene);
			stage.setScene(newScene);
			stage.show();
			window.close();
		});
		*/
		

		VBox pane = new VBox(10);
		pane.setStyle("-fx-border-color: black; -fx-background-color: azure");
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		Scene scene = new Scene(pane);

		pane.getChildren().addAll(label, close_btn);
		window.setScene(scene);
		window.show();
	}
}
