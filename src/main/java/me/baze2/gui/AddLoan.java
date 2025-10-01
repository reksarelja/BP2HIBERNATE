package me.baze2.gui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.baze2.crud.Crud;
import me.baze2.entities.Clan;
import me.baze2.entities.Knjiga;

import java.time.DateTimeException;
import java.time.LocalDate;

public class AddLoan {

	@FXML
	private TextField tfldLoanNo;
	@FXML
	private ComboBox<Clan> cmbxLoanUsers;
	@FXML
	private ComboBox<Knjiga> cmbxLoanBooks;
	@FXML
	private TextField tfldLoanTakenDate;

	private final ObservableList<Clan> listaClan = FXCollections.observableArrayList();
	private final ObservableList<Knjiga> listaKnjiga = FXCollections.observableArrayList();


	private final Crud crud = new Crud();
	
	public void initialize(){
		listaClan.setAll(crud.listClan());
		listaKnjiga.setAll(crud.listKnjiga());

		cmbxLoanUsers.setItems(listaClan);
		cmbxLoanBooks.setItems(listaKnjiga);
		try {
			tfldLoanNo.setText(crud.maxPozId());
		} catch(NullPointerException e){
			tfldLoanNo.setText("");
		}
	}
	
	@FXML
	public void onBtnLoadAdd(){
		try {
			crud.addPozajmica(cmbxLoanUsers.getValue(), cmbxLoanBooks.getValue(), LocalDate.parse(tfldLoanTakenDate.getText()));
		} catch(NumberFormatException e) {
			new Alert(Alert.AlertType.ERROR, "Wrong input value!", ButtonType.OK).showAndWait();
		} catch (DateTimeException e) {
			new Alert(Alert.AlertType.ERROR, "Wrong date format!", ButtonType.OK).showAndWait();
		}finally {
			tfldLoanNo.setText(crud.maxPozId());
			tfldLoanTakenDate.clear();

			cmbxLoanUsers.getSelectionModel().clearSelection();
			cmbxLoanBooks.getSelectionModel().clearSelection();

			listaClan.setAll(crud.listClan());
			listaKnjiga.setAll(crud.listKnjiga());
		}
	}

	@FXML
	public void onBtnCancelAdd(ActionEvent event){
		Node source = (Node) event.getSource();
		Stage currStage = (Stage) source.getScene().getWindow();
		currStage.close();
	}

}
