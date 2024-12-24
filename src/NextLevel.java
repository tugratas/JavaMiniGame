import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NextLevel {

	public static void display(int level, Stage stage, Scene newScene){

		Stage window = new Stage();
		window.setTitle("Next Level");
		window.initModality(Modality.APPLICATION_MODAL);
		Button btn = new Button("Next Level");
		window.setMinWidth(200);
		window.setMinHeight(200);
		btn.setOnAction(e -> {
			stage.setScene(newScene);
			stage.show();
			window.close();
		});
		
		/*
		Image image = new Image(new FileInputStream("//blueBox.jpg"));
		ImageView aa = new ImageView(image);
		aa.setX(50); 
	    aa.setY(25);
	    aa.setFitHeight(50); 
	    aa.setFitWidth(50); 

		*/

		Label text = new Label("Congratulations!!\nYou have completed Level " + (level - 1));
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		text.setTextAlignment(TextAlignment.CENTER);

		VBox pane = new VBox(20);
		pane.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-border-color: black; -fx-background-color: azure");
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(text, btn);

		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
	}
}
