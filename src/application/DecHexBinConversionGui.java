package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DecHexBinConversionGui extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// we create a gridpane
		GridPane pane = new GridPane();
		
		//we create labels, and textfield
		Label lbDecimal = new Label("Decimal");
		//set font color to white
		//set font style to times, and bold text
		lbDecimal.setTextFill(Color.WHITE);
		lbDecimal.setFont(Font.font("Times", FontWeight.BOLD, 18));
		Label lbHex = new Label("Hex");
		//set font color to white
		//set font style to times, and bold text
		lbHex.setTextFill(Color.WHITE);
		lbHex.setFont(Font.font("Times", FontWeight.BOLD, 18));
		Label lbBinary = new Label("Binary");
		//set font color to white
		//set font style to times, and bold text
		lbBinary.setTextFill(Color.WHITE);
		lbBinary.setFont(Font.font("Times", FontWeight.BOLD, 18));
		TextField tfDecimal = new TextField();
		TextField tfHex = new TextField();
		TextField tfBinary = new TextField();
		
		// we add labels and textfields to columns and rows in our pane
		pane.add(lbDecimal, 0, 0);
		pane.add(tfDecimal, 1, 0);
		pane.add(lbHex, 0, 2);
		pane.add(tfHex, 1, 2);
		pane.add(lbBinary, 0, 3);
		pane.add(tfBinary, 1, 3);
		
		//we set our horizontal and vertical gaps, and padding
		pane.setHgap(10);
		pane.setVgap(5);
		pane.setPadding(new Insets(10,10,5,10));
	
		pane.setStyle("-fx-background-color: navy");
		
		// we create a set on action when number is placed into the decimal text field and enter is pressed
		tfDecimal.setOnAction(e ->{
			
			// we get text in the text field for decimal and set it to a string statement
			String sdecimal = tfDecimal.getText();
			
			// we set the parse int of string to int
			int binInt = Integer.parseInt(sdecimal);
			
			//we set text in the binary text field
			tfBinary.setText(Integer.toBinaryString(binInt));
			
			// we set parse int of string decimal to int, and set the text for the hex textfield
			int hexInt = Integer.parseInt(sdecimal);
			tfHex.setText(Integer.toHexString(hexInt));
		});
		
		//  we create a set on action when number is placed into the binary text field and enter is pressed
		tfBinary.setOnAction(e -> {
			
			// we get text from binary textfield and set it to string
			String sbinary = tfBinary.getText();
			
			// we set our string to parse int, and use 2 since it's binary number
			int decInt = Integer.parseInt(sbinary,2);
			
			//we set text in text field decimal to string
			tfDecimal.setText(Integer.toString(decInt));
			
			//we create an int for hex textfield,and set it to integer to hex string
			int hexbinInt = Integer.parseInt(sbinary,2);
			tfHex.setText(Integer.toHexString(hexbinInt));
		});
		
	//  we create a set on action when number is placed into the hex text field and enter is pressed
		tfHex.setOnAction(e -> {
			
			// we get text from hex textfield and set it to string
			String shex = tfHex.getText();
			
			// we set our string to parse int, and use 16 since it's hex number
			int binInt = Integer.parseInt(shex,16);
			
			//we set text in text field binary to string
			tfBinary.setText(Integer.toBinaryString(binInt));
			
			//we create an int for parse int, and we set text in decimal textfield 
			int hexdecInt = Integer.parseInt(shex,16);
			tfDecimal.setText(Integer.toString(hexdecInt));
			
			
		});
		
		//we set scene
		Scene scene = new Scene(pane, 250, 125);
	    primaryStage.setTitle("Decimal, hexadecimal, binary Calculator"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
