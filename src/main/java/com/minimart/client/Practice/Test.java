package com.minimart.client.Practice;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test extends Application {

	public Test() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		test7(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
	@SuppressWarnings("unchecked")
	public void test7(Stage primaryStage){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		Scene rootScene = new Scene(grid, 320, 320);
		
		primaryStage.setScene(rootScene);
		primaryStage.show();
		
		final TableView<Object> tabelView = new TableView<Object>() ;
		
		TableColumn<Object, String> firstNameColumn = new TableColumn<Object, String>("First Name");
		TableColumn<Object, String> lastNameColumn = new TableColumn<Object, String>("Last Name");
		TableColumn<Object, String> emailColumn = new TableColumn<Object, String>("Email");
		
		grid.add(tabelView, 0, 0);
		
		tabelView.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn);
		
		
	}
	public void test6(Stage primaryStage){
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		Scene rootScene = new Scene(grid, 320, 320);
		
		primaryStage.setScene(rootScene);
		primaryStage.show();
		
		final ComboBox<String> box = new ComboBox<String>(FXCollections.observableArrayList("Item1", "Item2", "Item3"));
		box.setEditable(true);
		box.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0,
					String arg1, String arg2) {
				System.out.println("New Selected Value: "  + arg2);
			}
			
		});
		grid.add(box, 0, 0);
	}
	public void test5(Stage primaryStage){
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
		
		Scene root = new Scene(grid, 300, 300);
		
		ObservableList<String> items = FXCollections.observableArrayList("Item1", "Item2", "Item3");
		
		final ListView<String> listView = new ListView<String>(items);
//		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);;
		listView.setEditable(true);
		listView.setCellFactory(ComboBoxListCell.forListView(FXCollections.observableArrayList("Choose1", "Choose2")));
		listView.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Number>(){

			@Override
			public void onChanged(
					javafx.collections.ListChangeListener.Change<? extends Number> arg0) {
				System.out.println("Test" + listView.getSelectionModel().getSelectedItems());
				
			}
			
		});
		grid.add(listView, 0, 0);
		
		primaryStage.setScene(root);
		primaryStage.show();
		

//		final ChoiceBox box = new ChoiceBox(FXCollections.observableArrayList("Option1", "Option2"));
//		box.setPrefSize(100, 100);
//		grid.add(box, 0, 1);
//		
//		box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
//
//			@Override
//			public void changed(ObservableValue<? extends Number> index,
//					Number oldValue, Number newValue) {
//				System.out.println(box.getSelectionModel().getSelectedItem().toString());
//			}
//			
//		});;
		
	}
	public void test4(Stage primaryStage){
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
		
		final ChoiceBox<String> box = new ChoiceBox<String>(FXCollections.observableArrayList("Option1", "Option2", "Option3"));
		box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue,
					Number newValue) {
				Object selectedObject = box.getItems().get((int) newValue);
				System.out.println("Selected Object" + selectedObject.toString());
			}
			
		});
		grid.add(box, 0, 0);
		
		Scene root = new Scene(grid, 300, 300);
		
		primaryStage.setScene(root);
		primaryStage.setTitle("Choice Boxes");
		primaryStage.show();
		
	}

	public void test3(Stage primaryStage){
		GridPane gridPane = new GridPane();
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setAlignment(Pos.CENTER);
		
		final ToggleGroup group = new ToggleGroup();
		
		RadioButton button1 =  new RadioButton("Option1");
		button1.setToggleGroup(group);
		button1.setUserData("Option1");
		gridPane.add(button1, 0, 0);
		
		RadioButton button2 =  new RadioButton("Option2");
		button2.setToggleGroup(group);
		button2.setUserData("Option2");
		button2.setSelected(true);
		button2.requestFocus();
		gridPane.add(button2, 0, 1);
		
		RadioButton button3 =  new RadioButton("Option3");
		button3.setUserData("Option3");
		button3.setToggleGroup(group);
		gridPane.add(button3, 0, 2);
		
		Scene root = new Scene(gridPane, 320, 400);
		
		primaryStage.setScene(root);
		primaryStage.setTitle("Group");
		primaryStage.show();
		
		group.selectedToggleProperty().addListener( new ChangeListener<Toggle>(){

			@Override
			public void changed(ObservableValue<? extends Toggle> ov,
					Toggle oldToggle, Toggle newToggle) {
				
				System.out.println("selected tag"  + group.getSelectedToggle());
				
			}
		});
		}
	
	
	
	
	
	
	
	
	
	public void test1(Stage primaryStage) {

		Button button = new Button();
		button.setText("Tap Me");
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle (ActionEvent event){
				System.out.println("Tapped Here");
			}
		});
		
		GridPane pane = new GridPane();
		pane.setGridLinesVisible(true);
		pane.setVgap(20);
		pane.add(button, 0, 0);
		
		Scene root = new Scene(pane, 320, 320);
		
		primaryStage.setScene(root);
		primaryStage.setTitle("Grid Pane");
		primaryStage.show();

	}
	public void test2(Stage primaryStage){
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene root = new Scene(grid, 300, 300);
		root.getStylesheets().add
		 (Test.class.getResource("Login.css").toExternalForm());
		
		primaryStage.setScene(root);
		primaryStage.setTitle("Welcome");
		primaryStage.show();
		
		Label welcomeLabel = new Label("Welcome ");
		welcomeLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		welcomeLabel.setId("welcome-text");
		grid.add(welcomeLabel, 0, 0, 2, 1);
		
		Label userNameLabel = new Label("User Name:");
		grid.add(userNameLabel, 0, 1);

		Label passwordLabel = new Label("Password:");
		grid.add(passwordLabel, 0, 2);
		
		TextField userNameField = new TextField();
		grid.add(userNameField, 1, 1);

		TextField passwordField = new TextField();
		grid.add(passwordField, 1, 2);
		
		Button signInButton = new Button();
		signInButton.setText("SIgn In");
		HBox box = new HBox();
		box.getChildren().add(signInButton);
		box.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(box, 0, 3, 2, 1);
		
//		grid.setGridLinesVisible(true);
		final Text resultLabel = new Text();
		resultLabel.setId("result-label");

		HBox resultBox = new HBox();
		resultBox.setAlignment(Pos.BOTTOM_CENTER);
		
		resultBox.getChildren().add(resultLabel);
		grid.add(resultBox, 0, 4, 2, 2);
		
		signInButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				resultLabel.setText("Tapped");
				resultLabel.setFill(Color.FIREBRICK);
			}
		});
		
		

	}
}
