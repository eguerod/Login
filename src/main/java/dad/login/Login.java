package dad.login;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Application {
	
	TextField userText;
	PasswordField passText;
	CheckBox ldapCheck;
	Button accederButton, cancelarButton;
	HBox botonera;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		userText = new TextField();
		
		passText = new PasswordField();
		
		ldapCheck = new CheckBox();
		
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		
		botonera = new HBox(5, accederButton, cancelarButton);
		
		GridPane root = new GridPane();
//		root.setPadding(new Insets(5));
		root.setAlignment(Pos.CENTER);
		root.setHgap(5);
		root.setVgap(5);
		root.setGridLinesVisible(true);
		root.addRow(0, new Label("Usuario:"), userText);
		root.addRow(1, new Label("Contraseña:"), passText);
		root.addRow(2, new Label(), new HBox(5, ldapCheck, new Label("Usar LDAP")));
		root.addRow(3, botonera);
		
		GridPane.setColumnSpan(botonera, 2);
		GridPane.setHalignment(botonera, HPos.CENTER);
				
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(new Scene(root, 275, 140));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
