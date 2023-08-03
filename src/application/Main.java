package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {

	public static final String WINDOW_APP_NAME = "Calculator";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			DisplayCalculator dis = new DisplayCalculator();
			Scene scene = dis.initializeDisplay();
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_APP_NAME);
			primaryStage.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
