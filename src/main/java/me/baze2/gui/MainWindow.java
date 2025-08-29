package me.baze2.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {

	@FXML
	Button btnOpenNewUser;
	@FXML
	Button btnOpenNewLoan;
	@FXML
	Button btnOpenDelete;
	@FXML
	Button btnOpenShowBooks;

	private Stage secondStage;

	public void initialize(){
		secondStage = new Stage();
		secondStage.setResizable(false);
	}

	@FXML
	public void onBtnOpenNewUser() throws IOException {
		secondStage.close();
		Scene scene = new Scene(new FXMLLoader(getClass().getResource("add-user.fxml")).load());
		secondStage.setScene(scene);
		secondStage.setTitle("Add User");
		secondStage.show();
	}
	@FXML
	public void onBtnOpenNewLoan() throws IOException {
		secondStage.close();
		Scene scene = new Scene(new FXMLLoader(getClass().getResource("add-loan.fxml")).load());
		secondStage.setScene(scene);
		secondStage.setTitle("Add Loan");
		secondStage.show();

	}
	@FXML
	public void onBtnOpenDelete() throws IOException {
		secondStage.close();
		Scene scene = new Scene(new FXMLLoader(getClass().getResource("delete-user.fxml")).load());
		secondStage.setScene(scene);
		secondStage.setTitle("Delete User");
		secondStage.show();

	}
	@FXML
	public void onBtnOpenShowBooks() throws IOException {
		secondStage.close();
		Scene scene = new Scene(new FXMLLoader(getClass().getResource("show-books.fxml")).load());
		secondStage.setScene(scene);
		secondStage.setTitle("Show books from");
		secondStage.show();

	}

}