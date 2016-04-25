package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Person;
import domain.Personer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIMain extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Opgave 5 : Person Table");
		initRootLayout();
		showPersonOverview();		
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(GUIMain.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			throw new RuntimeException("MainApp initRootLayout : fejl", e);
		}
	}


	public void showPersonOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("GUI.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(personOverview);

			GUIController controller = loader.getController();
			controller.setGUIMain(this);

		} catch (IOException e) {
			throw new RuntimeException("MainApp showPersonOverview : fejl", e);
		}
	}

	public GUIMain(){

		List<Person> personList = new ArrayList<>();

		try {
			personList= Personer.instance().getList();
			for (Person p : personList) {
				personData.add(p);
			}

		} catch (Exception e) {
			throw new RuntimeException("GUIMain constructor : fejl", e);
		}
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}



	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
