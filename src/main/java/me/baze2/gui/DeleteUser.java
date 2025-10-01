package me.baze2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import me.baze2.crud.Crud;
import me.baze2.entities.Clan;

public class DeleteUser {
	
	@FXML
	ComboBox<Clan> cmbxDeleteUsers;

	private final ObservableList<Clan> list = FXCollections.observableArrayList();

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
	@FXML
	public void onBtnCancelDelete(ActionEvent event){
		Node source = (Node) event.getSource();
		Stage currStage = (Stage) source.getScene().getWindow();
		currStage.close();
	}
}
