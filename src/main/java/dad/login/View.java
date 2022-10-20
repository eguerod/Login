package dad.login;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View extends GridPane {
	TextField userText;
	PasswordField passText;
	CheckBox ldapCheck;
	Button accederButton, cancelarButton;
	GridPane botonera;

	public View() {
		userText = new TextField();
		userText.setPromptText("Nombre de usuario");

		passText = new PasswordField();
		passText.setPromptText("Contraseña de usuario");

		ldapCheck = new CheckBox();

		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");
		accederButton.setDefaultButton(true);

		botonera = new GridPane();
		botonera.setHgap(5);
		botonera.setVgap(5);
		botonera.setAlignment(Pos.CENTER);
		botonera.setGridLinesVisible(false);
		botonera.addRow(0, accederButton, cancelarButton);
		
		setHgap(5);
		setVgap(5);
		setAlignment(Pos.CENTER);
		setGridLinesVisible(false);
		
		addRow(0, new Label("Usuario:"), userText);
		addRow(1, new Label("Contraseña:"), passText);
		addRow(2, new Label(), new HBox(5, ldapCheck, new Label("Usar LDAP")));
		addRow(3, botonera);
		
		setColumnSpan(botonera, 2);
		setHalignment(botonera, HPos.CENTER);
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPassText() {
		return passText;
	}

	public CheckBox getLdapCheck() {
		return ldapCheck;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public GridPane getBotonera() {
		return botonera;
	}
}
