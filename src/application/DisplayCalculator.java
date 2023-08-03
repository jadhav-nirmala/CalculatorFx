package application;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayCalculator {
	public static final int WINDOW_HEIGHT = 400;
	public static final int WINDOW_WIDTH = 350;
	
	TextField textNum1;
	TextField textNum2;
	Button btnDivide;
	Button btnMultiply;
	Button btnAdd;
	Button btnSubtract;
	Button btnClear;
	Label labelAnswer;
	Calculator myCalculator;
	
	public DisplayCalculator() {
		
	}
	
	public Scene initializeDisplay() {
		textNum1 	= new TextField();
		textNum2 	= new TextField();
		btnDivide 	= new Button("/");
		btnMultiply = new Button("*");
		btnAdd 		= new Button("+");
		btnSubtract = new Button("-");
		btnClear 	= new Button("Clear");
		labelAnswer = new Label("?");
		myCalculator = new Calculator();
		
		labelAnswer.setAlignment(Pos.CENTER);
		labelAnswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		
		
		root.add(labelAnswer, 0, 0, 2, 1);
		
		root.add(textNum1, 0, 1);
		root.add(textNum2, 1, 1);
		

		root.add(btnAdd, 0, 2);
		root.add(btnSubtract, 1, 2);
		
		root.add(btnDivide, 0, 3);
		root.add(btnMultiply, 1, 3);
		
		root.add(btnClear, 0, 4, 2, 1);
		       	
		
		setWidths();
		attachCode();
		
		Scene scene = new Scene(root,WINDOW_HEIGHT,WINDOW_WIDTH);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		return scene;
	}
	
	private void setWidths() {
		   textNum1.setPrefWidth(100);
		   textNum2.setPrefWidth(100);
		   btnDivide.setPrefWidth(100);
		   btnMultiply.setPrefWidth(100);
		   btnAdd.setPrefWidth(100);
		   btnSubtract.setPrefWidth(100);
		   btnClear.setPrefWidth(210);
		   labelAnswer.setPrefWidth(210);
	}
	 
	public void attachCode() {
	   //have each button run BTNCODE when clicked
	   btnAdd.setOnAction(e -> btncode(e));
	   btnSubtract.setOnAction(e -> btncode(e));
	   btnMultiply.setOnAction(e -> btncode(e));
	   btnDivide.setOnAction(e -> btncode(e));
	   btnClear.setOnAction(e -> btncode(e));
	}

	private void btncode(ActionEvent e) {
		double num1, num2;
		double answer;
		char symbol;
		//e tells us which button was clicked
		if (e.getSource() == btnClear) {
		   textNum1.setText("");
		   textNum2.setText("");
		   labelAnswer.setText("?");
		   textNum1.requestFocus();
		   return;
		} else {
			num1 = Double.parseDouble(textNum1.getText());
			num2 = Double.parseDouble(textNum2.getText());
			
			if (e.getSource() == btnAdd) {
			   symbol = '+';
			   answer = myCalculator.add(num1,num2);
			} else if (e.getSource() == btnSubtract) {
			   symbol = '-';
			   answer = myCalculator.subtract(num1,num2);
			} else if (e.getSource() == btnMultiply) {
			   symbol = 'x';
			   answer = myCalculator.multiply(num1,num2);
			} else {
			   symbol = '/';
			   answer = myCalculator.divide(num1,num2);
			}
			//display answer
			labelAnswer.setText("" + num1 + symbol + num2 + "=" + answer);
		}
	}
}
