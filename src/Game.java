import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Game extends Application {

	private int width = 410, height = 410;
	private int tile_size = 40;
	int level = 1, count = 0;
	int score = 0;
	public static int finalScore;
	public static int highestScore;
	static int maxScore;
	Label bottomText = new Label("Welcome to the game.\nClick on a box to get started.");
	Label topScore = new Label("0");


	private Rectangle[][] grid = new Rectangle[10][10];

	class CustomPane extends GridPane {
		private int w, h;

		public CustomPane(int level, int w, int h) {
			this.w = w;
			this.h = h;

			setPrefSize(w, h);
			setPadding(new Insets(3, 3, 3, 3));

			setStyle("-fx-border-color: black; -fx-background-color: dimgray");

			if (level == 1) {
				for (int y = 0; y < 10; y++) {
					for (int x = 0; x < 10; x++) {
						Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);
						level_1 tile = new level_1(rec, x, y);

						grid[x][y] = tile.rec;

						getChildren().add(tile);
					}
				}
			} else if (level == 2) {
				for (int y = 0; y < 10; y++) {
					for (int x = 0; x < 10; x++) {
						Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);
						level_2 tile = new level_2(rec, x, y);

						grid[x][y] = tile.rec;

						getChildren().add(tile);
					}
				}
			} else if (level == 3) {
				for (int y = 0; y < 10; y++) {
					for (int x = 0; x < 10; x++) {
						Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);
						level_3 tile = new level_3(rec, x, y);

						grid[x][y] = tile.rec;

						getChildren().add(tile);
					}
				}
			} else if (level == 4) {
				for (int y = 0; y < 10; y++) {
					for (int x = 0; x < 10; x++) {
						Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);
						level_4 tile = new level_4(rec, x, y);

						grid[x][y] = tile.rec;

						getChildren().add(tile);
					}
				}
			} else if (level == 5) {
				for (int y = 0; y < 10; y++) {
					for (int x = 0; x < 10; x++) {
						Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);
						level_5 tile = new level_5(rec, x, y);

						grid[x][y] = tile.rec;

						getChildren().add(tile);
					}
				}
			}
		}
	}

	private void check(int x, int y) {
		int point = 0;
		if (grid[x + 1][y].getFill() == Color.AQUA || grid[x + 1][y].getFill() == Color.PLUM) {
			if (grid[x + 1][y].getFill() == Color.AQUA) {
				grid[x + 1][y].setFill(Color.WHITE);
				grid[x + 1][y].setStroke(Color.LIGHTGRAY);
				point++;

			} else if (grid[x + 1][y].getFill() == Color.PLUM) {
				grid[x + 1][y].setFill(Color.AQUA);
				grid[x + 1][y].setStroke(Color.DEEPSKYBLUE);
				point++;
			}

		}
		if (grid[x - 1][y].getFill() == Color.AQUA || grid[x - 1][y].getFill() == Color.PLUM) {
			if (grid[x - 1][y].getFill() == Color.AQUA) {
				grid[x - 1][y].setFill(Color.WHITE);
				grid[x - 1][y].setStroke(Color.LIGHTGRAY);
				point++;

			} else if (grid[x - 1][y].getFill() == Color.PLUM) {
				grid[x - 1][y].setFill(Color.AQUA);
				grid[x - 1][y].setStroke(Color.DEEPSKYBLUE);
				point++;
			}

		}
		if (grid[x][y + 1].getFill() == Color.AQUA || grid[x][y + 1].getFill() == Color.PLUM) {
			if (grid[x][y + 1].getFill() == Color.AQUA) {
				grid[x][y + 1].setFill(Color.WHITE);
				grid[x][y + 1].setStroke(Color.LIGHTGRAY);
				point++;

			} else if (grid[x][y + 1].getFill() == Color.PLUM) {
				grid[x][y + 1].setFill(Color.AQUA);
				grid[x][y + 1].setStroke(Color.DEEPSKYBLUE);
				point++;
			}

		}
		if (grid[x][y - 1].getFill() == Color.AQUA || grid[x][y - 1].getFill() == Color.PLUM) {
			if (grid[x][y - 1].getFill() == Color.AQUA) {
				grid[x][y - 1].setFill(Color.WHITE);
				grid[x][y - 1].setStroke(Color.LIGHTGRAY);
				point++;

			} else if (grid[x][y - 1].getFill() == Color.PLUM) {
				grid[x][y - 1].setFill(Color.AQUA);
				grid[x][y - 1].setStroke(Color.DEEPSKYBLUE);
				point++;
			}
		}

		if (point == 0) {
			score = score - 3;
			bottomText.setText("1 box destroyed  --  -3 Points");
			topScore.setText("" + score);

		} else if (point == 1) {
			score = score - 1;
			bottomText.setText("2 box destroyed  --  -1 Points");
			topScore.setText("" + score);

		} else if (point == 2) {
			score = score + 1;
			bottomText.setText("3 box destroyed  --  +1 Points");
			topScore.setText("" + score);

		} else if (point == 3) {
			score = score + 2;
			bottomText.setText("4 box destroyed  --  +2 Points");
			topScore.setText("" + score);

		} else if (point == 4) {
			score = score + 4;
			bottomText.setText("5 box destroyed  --  +4 Points");
			topScore.setText("" + score);
		}
	}

	public boolean finishCheck() {

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				if (grid[x][y].getFill() == Color.WHITE || grid[x][y].getFill() == Color.DIMGRAY) {
					count++;
				}
			}
		}
		if (count == 100) {
			count = 0;
			return true;
		} else {
			count = 0;
			return false;
		}

	}

	private BorderPane topMenu() {
		BorderPane topMenu = new BorderPane();
		topMenu.setPadding(new Insets(5, 5, 5, 5));
		Label topLeftText = new Label("Level #" + level);
		topLeftText.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		topLeftText.setAlignment(Pos.TOP_LEFT);

		//int localScore = score;
		//Label score = new Label(String.valueOf(localScore));
		//topScore
		
		//score.setAlignment(Pos.TOP_CENTER);

		Label topRightText = new Label("HighScore: " + highestScore);
		topRightText.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		topRightText.setAlignment(Pos.TOP_RIGHT);
		topMenu.setLeft(topLeftText);
		topMenu.setCenter(topScore);
		topScore.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		topMenu.setRight(topRightText);

		return topMenu;
	}

	private BorderPane bottomMenu() {
		Button info_btn = new Button("?");
		info_btn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		info_btn.setShape(new Circle(5));
		info_btn.setOnAction(e -> {

			InformationWindow.display();

		});
		BorderPane bottomMenu = new BorderPane();
		bottomMenu.setPadding(new Insets(5, 5, 5, 5));
		bottomMenu.setLeft(bottomText);
		bottomText.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		bottomMenu.setRight(info_btn);
		return bottomMenu;
	}

	public static void main(String[] args) {
		File scores = new File("scores.txt");

		if (!scores.exists()) {
			try {
				scores.createNewFile();
				FileWriter wr = new FileWriter(scores);
				wr.append('0');
				wr.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(scores);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		while (fileScanner.hasNextInt()) {
			int localScore = fileScanner.nextInt();
			if (localScore > maxScore) {
				maxScore = localScore;
			}
		}
		highestScore = maxScore;
		fileScanner.close();

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Proje Deneme");
		Scene scene = new Scene(level1());
		stage.setScene(scene);
		stage.show();

		scene.setOnMouseClicked(e -> {

			finishCheck();
			if (finishCheck()) {

				level = 2;
				Scene scene2 = new Scene(level2());
				NextLevel.display(level, stage, scene2);

				scene2.setOnMouseClicked(e2 -> {
					finishCheck();
					if (finishCheck()) {
						level = 3;
						Scene scene3 = new Scene(level3());
						NextLevel.display(level, stage, scene3);

						scene3.setOnMouseClicked(e3 -> {
							finishCheck();
							if (finishCheck()) {
								level = 4;
								Scene scene4 = new Scene(level4());
								NextLevel.display(level, stage, scene4);

								scene4.setOnMouseClicked(e4 -> {
									finishCheck();
									if (finishCheck()) {
										level = 5;
										Scene scene5 = new Scene(level5());
										NextLevel.display(level, stage, scene5);

										scene5.setOnMouseClicked(e5 -> {
											finishCheck();
											if (finishCheck()) {
												level = 6;
												finalScore = score;

												try {
													FileWriter writer = new FileWriter("scores.txt", true);
													writer.write("\n" + finalScore);
													writer.close();
												} catch (FileNotFoundException e1) {

													e1.printStackTrace();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												FinishGame.display(stage, finalScore);
												// FinishGame.display(stage, scenee, parent);
											}
										});
									}
								});
							}
						});
					}
				});
			}

		});

	}

	// *****************************************************************************************************************
	// *****************************************************************************************************************

	// Level 1
	private Parent level1() {
		BorderPane pane = new BorderPane();
		pane.setCenter(new CustomPane(level, width, height));
		pane.setTop(topMenu());
		pane.setBottom(bottomMenu());
		return pane;
	}

	private class level_1 extends StackPane {

		private int x, y;
		private Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);

		public level_1(Rectangle rec, int x, int y) {
			this.rec = rec;
			this.x = x;
			this.y = y;

			rec.setStroke(Color.BLACK);
			rec.setStrokeWidth(2);
			rec.setFill(Color.DIMGRAY);

			if ((x == 7 && y == 1) || (x == 8 && y == 1) || (x == 8 && y == 2)) {
				rec.setFill(Color.AQUA);
				rec.setStroke(Color.DEEPSKYBLUE);
				rec.setStrokeWidth(4);
			}

			if ((x == 4 && y == 4) || (x == 4 && y == 5) || (x == 5 && y == 4) || (x == 5 && y == 5)) {
				rec.setFill(Color.WHITE);
				rec.setStroke(Color.LIGHTGRAY);
				rec.setStrokeWidth(4);
			}

			if ((x == 1 && y == 7) || (x == 1 && y == 8) || (x == 2 && y == 8)) {
				rec.setFill(Color.PLUM);
				rec.setStroke(Color.MEDIUMORCHID);
				rec.setStrokeWidth(4);
			}

			getChildren().add(rec);

			setTranslateX(x * tile_size);
			setTranslateY(y * tile_size);

			setOnMouseClicked(e -> {
				if (rec.getFill() == Color.AQUA) {
					rec.setFill(Color.WHITE);
					rec.setStroke(Color.LIGHTGRAY);
					check(x, y);
					finishCheck();
				} else if (rec.getFill() == Color.PLUM) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					check(x, y);
					finishCheck();
				}
			});
		}
	}

	// Level 2
	private Parent level2() {
		BorderPane pane = new BorderPane();
		pane.setCenter(new CustomPane(level, width, height));
		pane.setTop(topMenu());
		pane.setBottom(bottomMenu());
		return pane;
	}

	private class level_2 extends StackPane {

		private int x, y;
		private Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);

		public level_2(Rectangle rec, int x, int y) {
			this.rec = rec;
			this.x = x;
			this.y = y;

			rec.setStroke(Color.BLACK);
			rec.setStrokeWidth(2);
			rec.setFill(Color.DIMGRAY);

			if ((x == 4) || (x == 5)) {
				if (x == 4) {
					if ((y >= 1) && (y <= 7)) {
						rec.setFill(Color.AQUA);
						rec.setStroke(Color.DEEPSKYBLUE);
						rec.setStrokeWidth(4);
					}
				}
				if (x == 5) {
					if ((y >= 2) && (y <= 8)) {
						rec.setFill(Color.AQUA);
						rec.setStroke(Color.DEEPSKYBLUE);
						rec.setStrokeWidth(4);
					}
				}
			}

			if ((x == 1 && y == 1) || (x == 8 && y == 1) || (x == 1 && y == 8) || (x == 8 && y == 8)) {
				rec.setFill(Color.WHITE);
				rec.setStroke(Color.LIGHTGRAY);
				rec.setStrokeWidth(4);
			}

			if ((y == 4) || (y == 5)) {
				if (y == 4) {
					if ((x >= 1) && (x <= 7)) {
						rec.setFill(Color.PLUM);
						rec.setStroke(Color.MEDIUMORCHID);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 5) {
					if ((x >= 2) && (x <= 8)) {
						rec.setFill(Color.PLUM);
						rec.setStroke(Color.MEDIUMORCHID);
						rec.setStrokeWidth(4);
					}
				}
			}
			getChildren().add(rec);
			setTranslateX(x * tile_size);
			setTranslateY(y * tile_size);

			setOnMouseClicked(e -> {
				if (rec.getFill() == Color.AQUA) {
					rec.setFill(Color.WHITE);
					rec.setStroke(Color.LIGHTGRAY);
					check(x, y);
					finishCheck();
				} else if (rec.getFill() == Color.PLUM) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					check(x, y);
					finishCheck();
				}
			});
		}
	}

	// Level 3
	private Parent level3() {
		BorderPane pane = new BorderPane();
		pane.setCenter(new CustomPane(level, width, height));
		pane.setTop(topMenu());
		pane.setBottom(bottomMenu());
		return pane;
	}

	private class level_3 extends StackPane {

		private int x, y;
		private Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);

		public level_3(Rectangle rec, int x, int y) {
			this.rec = rec;
			this.x = x;
			this.y = y;

			rec.setStroke(Color.BLACK);
			rec.setStrokeWidth(2);
			rec.setFill(Color.DIMGRAY);

			// Blue
			if ((y >= 1) && (y <= 4)) {
				if (y == 1) {
					if ((x >= 1) && (x <= 8)) {
						rec.setFill(Color.AQUA);
						rec.setStroke(Color.DEEPSKYBLUE);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 2) {
					if ((x == 1) || (x == 8)) {
						rec.setFill(Color.AQUA);
						rec.setStroke(Color.DEEPSKYBLUE);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 3) {
					if ((x == 1) || (x == 8)) {
						rec.setFill(Color.AQUA);
						rec.setStroke(Color.DEEPSKYBLUE);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 4) {
					if (((x >= 1) && (x <= 3)) || ((x >= 6) && (x <= 8))) {
						rec.setFill(Color.AQUA);
						rec.setStroke(Color.DEEPSKYBLUE);
						rec.setStrokeWidth(4);
					}
				}
			}

			// Pink
			if ((y >= 5) && (y <= 8)) {
				if (y == 5) {
					if (((x >= 1) && (x <= 3)) || ((x >= 6) && (x <= 8))) {
						rec.setFill(Color.PLUM);
						rec.setStroke(Color.MEDIUMORCHID);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 6) {
					if ((x == 1) || (x == 8)) {
						rec.setFill(Color.PLUM);
						rec.setStroke(Color.MEDIUMORCHID);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 7) {
					if ((x == 1) || (x == 8)) {
						rec.setFill(Color.PLUM);
						rec.setStroke(Color.MEDIUMORCHID);
						rec.setStrokeWidth(4);
					}
				}
				if (y == 8) {
					if ((x >= 1) && (x <= 8)) {
						rec.setFill(Color.PLUM);
						rec.setStroke(Color.MEDIUMORCHID);
						rec.setStrokeWidth(4);
					}
				}
			}
			getChildren().add(rec);
			setTranslateX(x * tile_size);
			setTranslateY(y * tile_size);

			setOnMouseClicked(e -> {
				if (rec.getFill() == Color.AQUA) {
					rec.setFill(Color.WHITE);
					rec.setStroke(Color.LIGHTGRAY);
					check(x, y);
					finishCheck();
				} else if (rec.getFill() == Color.PLUM) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					check(x, y);
					finishCheck();
				}
			});
		}
	}

	// Level 4
	private Parent level4() {
		BorderPane pane = new BorderPane();
		pane.setCenter(new CustomPane(level, width, height));
		pane.setTop(topMenu());
		pane.setBottom(bottomMenu());
		return pane;
	}

	private class level_4 extends StackPane {

		private int x, y;
		private Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);

		public level_4(Rectangle rec, int x, int y) {
			this.rec = rec;
			this.x = x;
			this.y = y;

			rec.setStroke(Color.BLACK);
			rec.setStrokeWidth(2);
			rec.setFill(Color.DIMGRAY);

			// Blue
			if ((y >= 1) && (y <= 4)) {
				if ((x >= 1) && (x <= 8)) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					rec.setStrokeWidth(4);
				}
			}

			// Pink
			if ((y >= 5) && (y <= 8)) {

				if ((x >= 1) && (x <= 8)) {
					rec.setFill(Color.PLUM);
					rec.setStroke(Color.MEDIUMORCHID);
					rec.setStrokeWidth(4);
				}
			}

			getChildren().add(rec);
			setTranslateX(x * tile_size);
			setTranslateY(y * tile_size);

			setOnMouseClicked(e -> {
				if (rec.getFill() == Color.AQUA) {
					rec.setFill(Color.WHITE);
					rec.setStroke(Color.LIGHTGRAY);
					check(x, y);
					finishCheck();
				} else if (rec.getFill() == Color.PLUM) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					check(x, y);
					finishCheck();
				}
			});
		}
	}

	// Level 5
	private Parent level5() {
		BorderPane pane = new BorderPane();
		pane.setCenter(new CustomPane(level, width, height));
		pane.setTop(topMenu());
		pane.setBottom(bottomMenu());
		return pane;
	}

	private class level_5 extends StackPane {

		private int x, y;
		private Rectangle rec = new Rectangle(tile_size - 7, tile_size - 7);

		public level_5(Rectangle rec, int x, int y) {
			this.rec = rec;
			this.x = x;
			this.y = y;

			rec.setStroke(Color.BLACK);
			rec.setStrokeWidth(2);
			rec.setFill(Color.DIMGRAY);

			// Blue
			if ((y >= 7) && (y <= 8)) {
				if ((x >= 1) && (x <= 8)) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					rec.setStrokeWidth(4);
				}
			}
			if ((y >= 3) && (y <= 4)) {
				if ((x >= 4) && (x <= 5)) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					rec.setStrokeWidth(4);
				}
			}

			// Pink
			if ((y >= 1) && (y <= 2)) {
				if ((x >= 1) && (x <= 8)) {
					rec.setFill(Color.PLUM);
					rec.setStroke(Color.MEDIUMORCHID);
					rec.setStrokeWidth(4);
				}
			}
			if ((y >= 5) && (y <= 6)) {
				if ((x >= 4) && (x <= 5)) {
					rec.setFill(Color.PLUM);
					rec.setStroke(Color.MEDIUMORCHID);
					rec.setStrokeWidth(4);
				}
			}
			getChildren().add(rec);
			setTranslateX(x * tile_size);
			setTranslateY(y * tile_size);

			setOnMouseClicked(e -> {
				if (rec.getFill() == Color.AQUA) {
					rec.setFill(Color.WHITE);
					rec.setStroke(Color.LIGHTGRAY);
					check(x, y);
					finishCheck();
				} else if (rec.getFill() == Color.PLUM) {
					rec.setFill(Color.AQUA);
					rec.setStroke(Color.DEEPSKYBLUE);
					check(x, y);
					finishCheck();
				}
			});
		}
	}
}
