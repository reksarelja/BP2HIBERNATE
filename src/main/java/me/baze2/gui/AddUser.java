package me.baze2.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import me.baze2.crud.Crud;

public class AddUser {

	@FXML
	private TextField tfldUserJmbg;
	@FXML
	private TextField tfldUserName;
	@FXML
	private TextField tfldUserLastName;

	private final Crud crud = new Crud();

	@FXML
	public void onBtnUserAdd() throws NumberFormatException{
		try {
			crud.insertClan(Long.parseLong(tfldUserJmbg.getText()), tfldUserName.getText(), tfldUserLastName.getText());
		} catch (NumberFormatException e) {
			new Alert(Alert.AlertType.ERROR, "Wrong input value!", ButtonType.OK).showAndWait();
		} finally{
			tfldUserJmbg.clear();
			tfldUserName.clear();
			tfldUserLastName.clear();
		}
	}
}
