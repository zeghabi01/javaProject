package application;
	
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Stage window;
	Button AnalyzeBtn;
	TextArea area;
	TextArea area1;
	public static boolean isNumber(char x) {
		if(x >= '0' && x <= '9') {
			return true;
		}
		
		return false;
	}
	
	public static boolean isLetter(char x) {
		if(x >= 'a' && x <= 'z' || x >= 'A' && x <= 'Z') {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		window.setTitle("compiler");
		AnalyzeBtn = new Button("Analyze");
		
        BorderPane BPane = new BorderPane();  
		VBox vbox = new VBox();
		
		Scene scene = new Scene(BPane,950,600);

		
		
		BPane.setTop(vbox);
		
		
		vbox.getChildren().add(AnalyzeBtn);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		
        
        // Area configurations
		area = new TextArea();
		area1 = new TextArea("Result Here ...");
		area.setWrapText(true);
		area1.setWrapText(true);
		area1.setEditable(false);
		
		BPane.setLeft(area);
		BPane.setRight(area1);
		


		
		
		AnalyzeBtn.setOnAction(e-> {
			String str = new String();

			str = "";

			String myText = new String();
			myText = area.getText().replaceAll("\\s","");

			for(int i=0;i<myText.length()-1;i++){
				
				if(i==0 && (myText.charAt(i) == '-' || myText.charAt(i) == '+')  || isLetter(myText.charAt(i)) && isLetter(myText.charAt(i+1)) || isNumber(myText.charAt(i)) && isNumber(myText.charAt(i+1)) || isNumber(myText.charAt(i)) && myText.charAt(i+1) == '.' || myText.charAt(i) == '.'  &&  isNumber(myText.charAt(i+1)) ||  (myText.charAt(i) == '-' && (isNumber(myText.charAt(i+1)) && ((myText.charAt(i-1) == '-') || !isNumber(myText.charAt(i-1)))  )||  (myText.charAt(i) == '+' && (isNumber(myText.charAt(i+1)) && (myText.charAt(i-1) == '+' || !isNumber(myText.charAt(i-1))))) || (myText.charAt(i) == '-' && (isNumber(myText.charAt(i+1)) && (myText.charAt(i-1) == '+')))|| (myText.charAt(i) == '+' && (isNumber(myText.charAt(i+1)) && (myText.charAt(i-1) == '-'))))){
					str += myText.charAt(i);
				}else {
					str += myText.charAt(i);
					str += "#";
				}
			}
			
			str += myText.charAt(myText.length()-1);
			str += "#";

			area1.setText(str);
			
			
		});
		
		
		window.setScene(scene);
		window.show();
		
	}
}
