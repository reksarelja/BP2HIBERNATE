package me.baze2.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import me.baze2.crud.Crud;
import me.baze2.entities.Rdj15823Clan;

public class DeleteUser {
	
	@FXML
	ComboBox<Rdj15823Clan> cmbxDeleteUsers;


	private final Crud crud = new Crud();
	
	public void initialize() {
		cmbxDeleteUsers.setItems(crud.listClan());

	}
	
	@FXML
	public void onBtnDeleteUser() {
		crud.updateKnjiga(cmbxDeleteUsers.getValue());
		crud.deleteClan(cmbxDeleteUsers.getValue());
		cmbxDeleteUsers.setItems(crud.listClan());

	}
	
}
