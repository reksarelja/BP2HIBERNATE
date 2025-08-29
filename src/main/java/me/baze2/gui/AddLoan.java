package me.baze2.gui;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import me.baze2.crud.Crud;
import me.baze2.entities.Rdj15823Clan;
import me.baze2.entities.Rdj15823Knjiga;

import java.time.DateTimeException;
import java.time.LocalDate;

public class AddLoan {

	@FXML
	private TextField tfldLoanNo;
	@FXML
	private ComboBox<Rdj15823Clan> cmbxLoanUsers;
	@FXML
	private ComboBox<Rdj15823Knjiga> cmbxLoanBooks;
	@FXML
	private TextField tfldLoanTakenDate;

	private final Crud crud = new Crud();
	
	public void initialize(){
		cmbxLoanUsers.setItems(crud.listClan());
		cmbxLoanBooks.setItems(crud.listKnjiga());
		tfldLoanNo.setText(crud.maxPozId());
	}
	
	@FXML
	public void onBtnLoadAdd(){
		try {
			crud.addPozajmica(Long.parseLong(tfldLoanNo.getText()), cmbxLoanUsers.getValue(), cmbxLoanBooks.getValue(), LocalDate.parse(tfldLoanTakenDate.getText()));
		} catch(NumberFormatException e) {
			new Alert(Alert.AlertType.ERROR, "Wrong input value!", ButtonType.OK).showAndWait();
		} catch (DateTimeException e) {
			new Alert(Alert.AlertType.ERROR, "Wrong date format!", ButtonType.OK).showAndWait();
		}finally {
			tfldLoanNo.setText(crud.maxPozId());
			tfldLoanTakenDate.clear();
			cmbxLoanUsers.getSelectionModel().clearSelection();
			cmbxLoanBooks.getSelectionModel().clearSelection();

		}
	}
	
}
