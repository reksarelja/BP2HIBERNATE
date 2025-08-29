package me.baze2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import me.baze2.crud.Crud;
import me.baze2.entities.Rdj15823Clan;

public class DeleteUser {
	
	@FXML
	ComboBox<Rdj15823Clan> cmbxDeleteUsers;

	private final ObservableList<Rdj15823Clan> list = FXCollections.observableArrayList();

	private final Crud crud = new Crud();
	
	public void initialize() {
		list.addAll(crud.listClan());
		cmbxDeleteUsers.setItems(list);
	}
	
	@FXML
	public void onBtnDeleteUser() {
		crud.updateKnjiga(cmbxDeleteUsers.getValue());
		crud.deleteClan(cmbxDeleteUsers.getValue());
		list.remove(cmbxDeleteUsers.getValue());
		cmbxDeleteUsers.getSelectionModel().clearSelection();

	}
	
}
