package dad.login;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	private Model model = new Model();
	private View view = new View();

	public Controller() {
		view.getUserText().textProperty().bindBidirectional(model.usuarioProperty());
		view.getPassText().textProperty().bindBidirectional(model.contraseñaProperty());

		view.accederButton.setOnAction(this::onAccederAction);

		view.cancelarButton.setOnAction(this::onCancelarAction);
	}

	private void onAccederAction(ActionEvent e) {
		
		boolean useLdap = view.ldapCheck.isSelected();
		AuthService auth = useLdap ? new LdapAuthService() : new FileAuthService();
		
		Alert alert;
		
		try {
			if(auth.login(model.getUsuario(), model.getContraseña())) {
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Iniciar sesión");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("Las credenciales de acceso son válidas.");
			} else {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Iniciar sesión");
				alert.setHeaderText("Acceso denegado");
				alert.setContentText("El usuario y/o la contraseña no son válidos.");
			}
		} catch (Exception e1) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("Iniciar sesión");
			alert.setHeaderText("Error al identificarse");
			alert.setContentText("Se ha producido un error durante la autentificación: ".concat(e1.getLocalizedMessage()));
		}
		
		alert.show();
	}

	private void onCancelarAction(ActionEvent e) {
		Login.primaryStage.close();
	}

	public View getView() {
		return view;
	}
}
