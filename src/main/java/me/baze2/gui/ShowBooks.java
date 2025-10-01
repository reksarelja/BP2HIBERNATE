package me.baze2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import me.baze2.crud.Crud;
import me.baze2.entities.Clan;
import me.baze2.entities.Knjiga;

public class ShowBooks {

	@FXML
	ComboBox<Clan> cmbxSelectUser;
	
	@FXML
	TableView<Knjiga> tblBooks;
	
	@FXML
	TableColumn<Knjiga, Integer> colID;
	@FXML
	TableColumn<Knjiga, String> colTitle;
	@FXML
	TableColumn<Knjiga, Integer> colYear;
	@FXML
	TableColumn<Knjiga, Integer> colCopies;
	@FXML
	TableColumn<Knjiga, String> colCategory;

	private final Crud crud = new Crud();

	public void initialize(){
		cmbxSelectUser.setItems(crud.listClan());
	}

	@FXML
	public void onCmbxSelectUser(){
		System.out.println(crud.listKnjigeFromClan(cmbxSelectUser.getValue()));

		colID.setCellValueFactory(new PropertyValueFactory<>("id"));

		colTitle.setCellValueFactory(new PropertyValueFactory<>("knjigaNaziv"));

		colYear.setCellValueFactory(new PropertyValueFactory<>("knjigaGodIzd"));

		colCopies.setCellValueFactory(new PropertyValueFactory<>("knjigaBrPrim"));

		colCategory.setCellValueFactory(new PropertyValueFactory<>("knjigaKateg"));

		tblBooks.setItems(crud.listKnjigeFromClan(cmbxSelectUser.getValue()));
	}
	@FXML
	public void onBtnCancelShow(ActionEvent event){
		Node source = (Node) event.getSource();
		Stage currStage = (Stage) source.getScene().getWindow();
		currStage.close();
	}
}
