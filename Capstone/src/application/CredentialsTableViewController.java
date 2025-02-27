package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CredentialsTableViewController implements Initializable {
	
	@FXML private TableView<Credential> credentialsTable;
	@FXML private TableColumn<Credential, String> urlCol;
	@FXML private TableColumn<Credential, String> usernameCol;
	@FXML private TableColumn<Credential, String> passwordCol;
	
	
	public void onClick_btn_BackToMain(ActionEvent event) throws IOException
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	
    	window.setScene(tableViewScene);
    	window.show();
	}
	
	@Override public void initialize(URL url, ResourceBundle rb) {
		urlCol.setCellValueFactory(new PropertyValueFactory<Credential, String>("url"));
		usernameCol.setCellValueFactory(new PropertyValueFactory<Credential, String>("username"));
		passwordCol.setCellValueFactory(new PropertyValueFactory<Credential, String>("password"));
		
		credentialsTable.setItems(getCredentials());
	}
	
	public ObservableList<Credential> getCredentials()
	{
		ObservableList<Credential> creds = FXCollections.observableArrayList();
		creds.add(new Credential("https://gmail.com", "mailmainsteve88", "x39#0E"));
		creds.add(new Credential("https://evergy.com", "ToddSmith", "xtreme4lyfe!"));
		creds.add(new Credential("https://icloud.com", "lvandross@yahoo.com", "password"));
		creds.add(new Credential("https://myverizon.com", "7859832737", "$ecureP@Ssw0rd3"));
		
		return creds;
	}

}
