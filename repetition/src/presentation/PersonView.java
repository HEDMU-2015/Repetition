package presentation;

import static javafx.geometry.HPos.RIGHT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import domain.PersonDomain;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.Personer;

public class PersonView {
	private Stage primaryStage;
	private PersonsView view;
	private int index;
	private PersonDomain person;
	
	private TextField nameField;
	private TextField emailField;
	private TextField birthField;
	private Text errorField;
	private Personer personer = Personer.instance();
	
    public PersonView(Stage primaryStage, PersonsView view, int index, PersonDomain person) {
    	this.primaryStage = primaryStage;
    	this.view = view;
    	this.index = index;
    	this.person = person;
    }
    
    public void init() {
        primaryStage.setTitle("Person detail");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome to Person detail");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label nameLabel = new Label("Name:");
        grid.add(nameLabel, 0, 1);
        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 2);
        Label birthLabel = new Label("Date of birth:");
        grid.add(birthLabel, 0, 3);

        nameField = new TextField(person.getName());
        grid.add(nameField, 1, 1);
        emailField = new TextField(person.getEmail());
        grid.add(emailField, 1, 2);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (person.getBirthdate() != null) {
            birthField = new TextField(person.getBirthdate().format(format));
        } else {
            birthField = new TextField();
        }
        grid.add(birthField, 1, 3);

        Button savebtn = new Button("Save");
        Button deletebtn = new Button("Delete");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(savebtn);
        hbBtn.getChildren().add(deletebtn);
        grid.add(hbBtn, 1, 8);

        errorField = new Text();
        grid.add(errorField, 0, 9);
        GridPane.setColumnSpan(errorField, 2);
        GridPane.setHalignment(errorField, RIGHT);
        errorField.setId("error");
        errorField.setFill(Color.FIREBRICK);
        
        savebtn.setOnAction(e -> save());
        deletebtn.setOnAction(e -> delete());

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    	
    }
    
    private void save() {
    	errorField.setText("");
    	if (index == -1) {
        	PersonDomain newperson = new PersonDomain();
        	newperson.setName(nameField.getText());
        	newperson.setEmail(emailField.getText());
        	if (birthField.getText() != null && !birthField.getText().equals("")) {
            	newperson.setBirthdate(LocalDate.parse(birthField.getText()));
        	}
        	view.getPlist().add(newperson);
        	personer.create(newperson);
    	} else {
        	person.setName(nameField.getText());
        	person.setEmail(emailField.getText());
        	person.setBirthdate(LocalDate.parse(birthField.getText()));
        	view.getPlist().set(index, person);
        	personer.update(person);
    	}
    	primaryStage.close();;
    }

    private void delete() {
    	errorField.setText("");
    	view.getPlist().remove(person);
    	personer.delete(person);
    	primaryStage.close();
    }

}
