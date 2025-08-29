package me.baze2.gui;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import me.baze2.crud.Crud;
import me.baze2.entities.Rdj15823Clan;
import me.baze2.entities.Rdj15823Knjiga;

public class ShowBooks {

	@FXML
	ComboBox<Rdj15823Clan> cmbxSelectUser;
	
	@FXML
	TableView<Rdj15823Knjiga> tblBooks;
	
	@FXML
	TableColumn<Rdj15823Knjiga, Integer> colID;
	@FXML
	TableColumn<Rdj15823Knjiga, String> colTitle;
	@FXML
	TableColumn<Rdj15823Knjiga, Integer> colYear;
	@FXML
	TableColumn<Rdj15823Knjiga, Integer> colCopies;
	@FXML
	TableColumn<Rdj15823Knjiga, String> colCategory;

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

}
