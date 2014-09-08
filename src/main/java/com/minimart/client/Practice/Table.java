package com.minimart.client.Practice;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import com.minimart.client.views.MMTableView;
import com.minimart.client.views.pojos.FXManufacturer;
import com.minimart.model.Manufacturer;
import com.minimart.model.POSModel;

public class Table extends Application {

	public Table() {
		// TODO Auto-generated constructor stub
	}

	public void testTable(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setAlignment(Pos.CENTER);
		grid.setPrefWidth(450);

		Scene root = new Scene(grid, 620, 320);

		primaryStage.setScene(root);
		primaryStage.show();

		MMTableView tableView = new MMTableView(FXManufacturer.class, Manufacturer.class);
		tableView.setPrefSize(root.getWidth(), root.getHeight());

		List<POSModel> manufacturers = new ArrayList<POSModel>();
		for (int i = 0; i < 5; i++) {
			Manufacturer manufacturer = new Manufacturer(i, "Manufacturer_" + i);
			manufacturers.add(manufacturer );
		}
        tableView.setEditable(true);
		tableView.reloadTable(manufacturers);
		
		grid.add(tableView, 0, 0);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		testTable(primaryStage);

	}

	public static void main(String args[]) {
		launch(args);
	}

}
