import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InformationWindow {

	public static void display() {

		// Stage
		Stage window = new Stage();
		window.setTitle("General Informations");
		window.setMinHeight(300);
		window.setMinWidth(200);
		window.initModality(Modality.APPLICATION_MODAL);

		// Blue Box Image
		Image blue = new Image("blueBox.png");
		ImageView blueBox = new ImageView(blue);

		// Pink Box Image
		Image pink = new Image("pinkBox.png");
		ImageView pinkBox = new ImageView(pink);

		// White Box Image
		Image white = new Image("whiteBox.png");
		ImageView whiteBox = new ImageView(white);

		// Gray Box Image
		Image gray = new Image("grayBox.png");
		ImageView grayBox = new ImageView(gray);

		// Blue Box Information Label
		Label blueInfo = new Label(
				"Mirror Type Box:\nDurability (life) value is 1. \nIt returns to the empty (white) box type if the click occurs.");
		blueInfo.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

		// Pink Box Information Label
		Label pinkInfo = new Label(
				"Wood Type Box:\nDurability (life) value is 2. \nIt returns to the mirror (blue) box type if the click occurs.");
		pinkInfo.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

		// White Box Information Label
		Label whiteInfo = new Label("Empty Type Box:\nIt cannot be destroyed");
		whiteInfo.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

		// Gray Box Information Label
		Label grayInfo = new Label("Wall Type Box:\nIt cannot be destroyed");
		grayInfo.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

		// Point Information Labels
		Label PointTitle = new Label("Point\nTable");
		PointTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		PointTitle.setTextAlignment(TextAlignment.CENTER);

		Label points = new Label(
				"1 box destroy:  -3 points\n2 box destroy:  -1 points\n3 box destroy: +1 points\n4 box destroy: +2 points\n5 box destroy: +4 points");
		points.setFont(Font.font("Verdana", FontWeight.BOLD, 10));

		// Pane
		GridPane pane = new GridPane();
		pane.setStyle("-fx-border-color: black; -fx-background-color: azure");
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(10);
		pane.setHgap(10);

		// Grid
		GridPane.setConstraints(blueBox, 0, 0);
		GridPane.setConstraints(blueInfo, 1, 0);
		GridPane.setConstraints(pinkBox, 0, 1);
		GridPane.setConstraints(pinkInfo, 1, 1);
		GridPane.setConstraints(whiteBox, 0, 2);
		GridPane.setConstraints(whiteInfo, 1, 2);
		GridPane.setConstraints(grayBox, 0, 3);
		GridPane.setConstraints(grayInfo, 1, 3);
		GridPane.setConstraints(PointTitle, 0, 5);
		GridPane.setConstraints(points, 1, 5);

		pane.getChildren().addAll(blueBox, pinkBox, whiteBox, grayBox, blueInfo, pinkInfo, whiteInfo, grayInfo,
				PointTitle, points);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.show();
	}
}
