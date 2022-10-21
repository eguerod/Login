package dad.login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

	private Controller controller;
	public static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new Controller();
		
		Login.primaryStage = primaryStage;
		primaryStage.setTitle("Login.fxml");
		primaryStage.setScene(new Scene(controller.getView(), 275, 140));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
