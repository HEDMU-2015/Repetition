package presentation;

import java.net.URL;
import java.util.ResourceBundle;

import domain.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GUIController implements Initializable {
	
	@FXML
	private TableView<Person> outputfelt = new TableView<>();
	
	@FXML
	private TableColumn<PersonWrapper, String> name, email, birthday;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		name.setCellValueFactory(new PropertyValueFactory<PersonWrapper, String>("name"));
		email.setCellValueFactory(new PropertyValueFactory<PersonWrapper, String>("email"));
		birthday.setCellValueFactory(new PropertyValueFactory<PersonWrapper, String>("birthday"));
	}

	public void setGUIMain(GUIMain guiMain) {
		outputfelt.setItems(guiMain.getPersonData());
	}

}
