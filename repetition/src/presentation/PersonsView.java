package presentation;

import static javafx.geometry.HPos.RIGHT;

import java.util.List;

import domain.PersonDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Personer;

public class PersonsView {
	private Stage primaryStage;
	private GridPane grid;
	private TextField searchField;
	private TableView<PersonDomain> table;
	private ObservableList<PersonDomain> plist;
	
	public ObservableList<PersonDomain> getPlist() {
		return plist;
	}

	public void setPlist(ObservableList<PersonDomain> plist) {
		this.plist = plist;
	}

	private Text errorField;

	private Personer logic = Personer.instance();

	public PersonsView(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void init() {
		primaryStage.setTitle("Person search");
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Welcome to list of Persons");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label register = new Label("Search:");
		grid.add(register, 0, 1);

		searchField = new TextField();
		grid.add(searchField, 1, 1);

		Button searchbtn = new Button("Search");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(searchbtn);
		grid.add(hbBtn, 2, 1);

		searchbtn.setOnAction(e -> search());

		errorField = new Text();
		grid.add(errorField, 0, 6);
		GridPane.setColumnSpan(errorField, 3);
		GridPane.setHalignment(errorField, RIGHT);
		errorField.setId("error");
		errorField.setFill(Color.FIREBRICK);
		errorField.setText("");

		Scene scene = new Scene(grid, 500, 575);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void search() {
		errorField.setText("");
		List<PersonDomain> list = null;
		try {
			list = logic.list(searchField.getText());
			plist = FXCollections.observableList(list);
			createTable(plist);

		} catch (Exception e) {
			errorField.setText(e.getMessage());
		}
		primaryStage.show();
	}

	@SuppressWarnings("unchecked")
	private void createTable(ObservableList<PersonDomain> plist) {
		table = new TableView<PersonDomain>();
		TableColumn<PersonDomain, String> nameCol = new TableColumn<>("Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(new PropertyValueFactory<PersonDomain, String>("name"));
		TableColumn<PersonDomain, String> emailCol = new TableColumn<>("Email");
		emailCol.setMinWidth(100);
		emailCol.setCellValueFactory(new PropertyValueFactory<PersonDomain, String>("email"));
//		TableColumn<PersonDomain, String> birthdateCol = new TableColumn<>("Birthdate");
//		birthdateCol.setMinWidth(80);
//		birthdateCol.setCellValueFactory(new PropertyValueFactory<PersonDomain, String>("birthdate"));

		table.setItems(plist);
		table.getColumns().addAll(nameCol, emailCol);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().add(table);
		grid.add(vbox, 0, 3);

		GridPane.setColumnSpan(vbox, 3);

		table.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				edit();
			}
		});

		Button editbtn = new Button("Edit");
		Button newbtn = new Button("New");
		HBox eBtn = new HBox(10);
		eBtn.setAlignment(Pos.BOTTOM_RIGHT);
		eBtn.getChildren().addAll(editbtn, newbtn);
		grid.add(eBtn, 2, 4);

		editbtn.setOnAction(e -> edit());
		newbtn.setOnAction(e -> newp());

	}

	public TableView<PersonDomain> getTable() {
		return table;
	}

	private void edit() {
		if (table.getSelectionModel().getSelectedItem() != null) {
			System.out.println(table.getSelectionModel().getSelectedItem());
			new PersonView(new Stage(), this, table.getSelectionModel().getSelectedIndex(), table.getSelectionModel().getSelectedItem()).init();
		} else {
			System.out.println("?");
		}

	}
	private void newp() {
		new PersonView(new Stage(), this, -1, new PersonDomain()).init();
	}

}
