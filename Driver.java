

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Driver extends Application{
	
	public String text = "";
	
	//counters used to remember if the first time for clicking "single step sort" has been done
	public int counter = 0;
	public int counter2 = 0;
	public int counter3 = 1;
	
	//ReverseBubbleOWNMETHOD.java
	public int posCounter = 0;
	public int[] rePos = {};
	public char[] rePosC = {};
	private int n = 0;
	private int m = 0;
	private Boolean done = false;
	private int[] g = {};
	private int[] posg = {};
	
	//Reverse.java
	private int[] posSingle = {};
	private int[] posSingle2 = {};
	private boolean doneStep1 = false;
	private boolean doneStep2 = false;
	private int[] y1R = {};
	private int[] pos1R = {};
	private int[] y2R = {};
	private int[] pos2R = {};

	//MergeSort.java
	int[] mArgs = new int[1];
	int[] mPos = new int[1];
	
	//lowestGoesFirst2.java
	int posc;
	int[] permaY = new int[1];
	int[] permaY2 = new int[1];
	int[] permaPos = new int[1];
	boolean firstPass = false;
	boolean firstPass2 = false;
	int c = 0;
	int bigX = 0;
	
	//barchart
	BarChart<?, ?> bc;
	
	//comparing methods
	int choice1 = 0;
	int choice2 = 0;
	String bigText = "";
	
	public static void main(String[] args) throws Exception{
		launch(args);
	}
	
	
	public void start(Stage primaryStage) {		
		AnchorPane root = new AnchorPane();
		
		Label intro = new Label("Choose a sorting method:");
		Button contBubbleOWN = new Button("Bubble Sort");
		contBubbleOWN.setPrefSize(150.0, 50.0);
		Button contBubbleOWN2 = new Button("Bubble Sort Alt");
		contBubbleOWN2.setPrefSize(150.0, 50.0);
		Button contPremu = new Button("Bogo Sort");
		contPremu.setPrefSize(150.0, 50.0);
		Button contMerge = new Button("Merge Sort");
		contMerge.setPrefSize(150.0, 50.0);
		Button contLGF = new Button ("Lowest Goes First");
		contLGF.setPrefSize(150.0, 50.0);
		Button compareSorts = new Button("Compare the Sorts");
		compareSorts.setPrefSize(150.0, 50.0);
//		Button contBubbleAlt = new Button("Bubble Sort Alt");

		
		AnchorPane.setLeftAnchor(intro, 10.0);
		AnchorPane.setTopAnchor(intro, 10.0);
		root.getChildren().add(intro);
		
		AnchorPane.setLeftAnchor(contBubbleOWN, 130.0);
		AnchorPane.setTopAnchor(contBubbleOWN, 50.0);
		root.getChildren().add(contBubbleOWN);
		
		AnchorPane.setLeftAnchor(contBubbleOWN2, 130.0);
		AnchorPane.setTopAnchor(contBubbleOWN2, 100.0);
		root.getChildren().add(contBubbleOWN2);
		
		AnchorPane.setLeftAnchor(contPremu, 130.0);
		AnchorPane.setTopAnchor(contPremu, 150.0);
		root.getChildren().add(contPremu);	
		
		AnchorPane.setLeftAnchor(contMerge, 130.0);
		AnchorPane.setTopAnchor(contMerge, 200.0);
		root.getChildren().add(contMerge);
		
		AnchorPane.setLeftAnchor(contLGF, 130.0);
		AnchorPane.setTopAnchor(contLGF, 250.0);
		root.getChildren().add(contLGF);
		
		AnchorPane.setLeftAnchor(compareSorts, 130.0);
		AnchorPane.setTopAnchor(compareSorts, 310.0);
		root.getChildren().add(compareSorts);
		
		
		
		contBubbleOWN.setOnAction(event -> {
			try {
				bubbleSortOWN(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		contBubbleOWN2.setOnAction(event1 -> {
			try {
				bubbleSort(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		contPremu.setOnAction(event2 -> {
			try {
				premutationSort(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		contMerge.setOnAction(event3 -> {
			try {
				mergeSort(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		contLGF.setOnAction(event4 -> {
			try {
				lgf(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		compareSorts.setOnAction(event5 -> {
			try {
				compareSortFunction(primaryStage);
			} catch (Exception e) {
				
			}
		});
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.show();
	}
	
	public void compareSortFunction(Stage primaryStage)throws Exception{
		
		AnchorPane root = new AnchorPane();
		
		Label inputLabel = new Label("Insert list here:");
		Label choiceLabel = new Label("Choose which sorting method you would like to compare");
		TextField inputText = new TextField("");
		
		
		Button contBubbleOWN = new Button("Bubble Sort");
		contBubbleOWN.setPrefSize(150.0, 50.0);
		Button contBubbleOWN2 = new Button("Bubble Sort Alt");
		contBubbleOWN2.setPrefSize(150.0, 50.0);
		Button contPremu = new Button("Bogo Sort");
		contPremu.setPrefSize(150.0, 50.0);
		Button contMerge = new Button("Merge Sort");
		contMerge.setPrefSize(150.0, 50.0);
		Button contPremuAlt = new Button ("Lowest Goes First");
		contPremuAlt.setPrefSize(150.0, 50.0);
		
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		AnchorPane.setTopAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 120.0);
		AnchorPane.setTopAnchor(inputText, 8.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setLeftAnchor(choiceLabel, 10.0);
		AnchorPane.setTopAnchor(choiceLabel, 40.0);
		root.getChildren().add(choiceLabel);
		
		AnchorPane.setLeftAnchor(contBubbleOWN, 130.0);
		AnchorPane.setTopAnchor(contBubbleOWN, 100.0);
		root.getChildren().add(contBubbleOWN);
		
		AnchorPane.setLeftAnchor(contBubbleOWN2, 130.0);
		AnchorPane.setTopAnchor(contBubbleOWN2, 150.0);
		root.getChildren().add(contBubbleOWN2);
		
		AnchorPane.setLeftAnchor(contPremu, 130.0);
		AnchorPane.setTopAnchor(contPremu, 200.0);
		root.getChildren().add(contPremu);	
		
		AnchorPane.setLeftAnchor(contMerge, 130.0);
		AnchorPane.setTopAnchor(contMerge, 250.0);
		root.getChildren().add(contMerge);
		
		AnchorPane.setLeftAnchor(contPremuAlt, 130.0);
		AnchorPane.setTopAnchor(contPremuAlt, 300.0);
		root.getChildren().add(contPremuAlt);
		
	
		
		contBubbleOWN.setOnAction(event1 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			String text = inputText.getText();
			choice1 = 1;
			try {
				compareSortFunction2(primaryStage, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		contBubbleOWN2.setOnAction(event2 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			String text = inputText.getText();
			choice1 = 2;
			try {
				compareSortFunction2(primaryStage, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		contPremu.setOnAction(event3 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			String text = inputText.getText();
			choice1 = 3;
			try {
				compareSortFunction2(primaryStage, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		contMerge.setOnAction(event4 ->{
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			String text = inputText.getText();
			choice1 = 4;
			try {
				compareSortFunction2(primaryStage, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		contPremuAlt.setOnAction(event5 ->{
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			String text = inputText.getText();
			choice1 = 5;
			try {
				compareSortFunction2(primaryStage, text);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.show();
		

		
	}
	
	public void compareSortFunction2(Stage primaryStage, String text)throws Exception{
		
	
		AnchorPane root = new AnchorPane();
		
		Label inputLabel = new Label("Insert list here:");
		Label choiceLabel = new Label("Choose which sorting method you would like to compare");
		TextField inputText = new TextField(text);
		inputText.setEditable(false);
		
		Button contBubbleOWN = new Button("Bubble Sort");
		contBubbleOWN.setPrefSize(150.0, 50.0);
		Button contBubbleOWN2 = new Button("Bubble Sort Alt");
		contBubbleOWN2.setPrefSize(150.0, 50.0);
		Button contPremu = new Button("Bogo Sort");
		contPremu.setPrefSize(150.0, 50.0);
		Button contMerge = new Button("Merge Sort");
		contMerge.setPrefSize(150.0, 50.0);
		Button contPremuAlt = new Button ("Lowest Goes First");
		contPremuAlt.setPrefSize(150.0, 50.0);
		Button okNew = new Button ("Ok New");
		okNew.setPrefSize(80.0, 20.0);
		
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		AnchorPane.setTopAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 120.0);
		AnchorPane.setTopAnchor(inputText, 8.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setLeftAnchor(choiceLabel, 10.0);
		AnchorPane.setTopAnchor(choiceLabel, 40.0);
		root.getChildren().add(choiceLabel);
		
		AnchorPane.setLeftAnchor(contBubbleOWN, 130.0);
		AnchorPane.setTopAnchor(contBubbleOWN, 100.0);
		root.getChildren().add(contBubbleOWN);
		
		AnchorPane.setLeftAnchor(contBubbleOWN2, 130.0);
		AnchorPane.setTopAnchor(contBubbleOWN2, 150.0);
		root.getChildren().add(contBubbleOWN2);
		
		AnchorPane.setLeftAnchor(contPremu, 130.0);
		AnchorPane.setTopAnchor(contPremu, 200.0);
		root.getChildren().add(contPremu);	
		
		AnchorPane.setLeftAnchor(contMerge, 130.0);
		AnchorPane.setTopAnchor(contMerge, 250.0);
		root.getChildren().add(contMerge);
		
		AnchorPane.setLeftAnchor(contPremuAlt, 130.0);
		AnchorPane.setTopAnchor(contPremuAlt, 300.0);
		root.getChildren().add(contPremuAlt);
		
		AnchorPane.setRightAnchor(okNew, 10.0);
		AnchorPane.setBottomAnchor(okNew, 10.0);
		root.getChildren().add(okNew);
		
		if(choice1 == 1) {
			contBubbleOWN.setDisable(true);
		}else if (choice1 == 2) {
			contBubbleOWN2.setDisable(true);
		}else if (choice1 == 3) {
			contPremu.setDisable(true);
		}else if (choice1 == 4) {
			contMerge.setDisable(true);
		}else if (choice1 == 5) {
			contPremuAlt.setDisable(true);
		}
		
		contBubbleOWN.setOnAction(event1 -> {
			choice2 = 1;
			contBubbleOWN.setDisable(true);
			contBubbleOWN2.setDisable(true);
			contPremu.setDisable(true);
			contMerge.setDisable(true);
			contPremuAlt.setDisable(true);
			
			
			bigText = inputText.getText();
			//System.out.println(bigText);
			generateTheirChoices(bigText);
			//System.out.println(steps[0]);	
			//System.out.println(steps[1]);
			
		});
		
		contBubbleOWN2.setOnAction(event2 -> {
			choice2 = 2;
			contBubbleOWN.setDisable(true);
			contBubbleOWN2.setDisable(true);
			contPremu.setDisable(true);
			contMerge.setDisable(true);
			contPremuAlt.setDisable(true);
			
			bigText = inputText.getText();
			//System.out.println(bigText);
			generateTheirChoices(bigText);
			//System.out.println(steps[0]);	
			//System.out.println(steps[1]);
		});
		
		contPremu.setOnAction(event3 -> {
			choice2 = 3;
			contBubbleOWN.setDisable(true);
			contBubbleOWN2.setDisable(true);
			contPremu.setDisable(true);
			contMerge.setDisable(true);
			contPremuAlt.setDisable(true);
			
			bigText = inputText.getText();
			//System.out.println(bigText);
			generateTheirChoices(bigText);
			//System.out.println(steps[0]);	
			//System.out.println(steps[1]);
		});
		
		contMerge.setOnAction(event4 ->{
			choice2 = 4;
			contBubbleOWN.setDisable(true);
			contBubbleOWN2.setDisable(true);
			contPremu.setDisable(true);
			contMerge.setDisable(true);
			contPremuAlt.setDisable(true);
			
			bigText = inputText.getText();
			//System.out.println(bigText);
			generateTheirChoices(bigText);
			//System.out.println(steps[0]);	
			//System.out.println(steps[1]);
		});
		
		contPremuAlt.setOnAction(event5 ->{
			choice2 = 5;
			contBubbleOWN.setDisable(true);
			contBubbleOWN2.setDisable(true);
			contPremu.setDisable(true);
			contMerge.setDisable(true);
			contPremuAlt.setDisable(true);
			
			bigText = inputText.getText();
			//System.out.println(bigText);
			generateTheirChoices(bigText);
			//System.out.println(steps[0]);	
			//System.out.println(steps[1]);
		});
		
		okNew.setOnAction(event4 ->{
			counter = 0;
			Driver d = new Driver();
			primaryStage.close();
			d.start(primaryStage);
		});
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.show();
	}
	
	public int[] generateTheirChoices(String text2) {
		int[] intArr = stringToIntArr(text2);
		int result1 = 0;
		int result2 = 0;
		
		System.out.println(choice1);
		System.out.println(choice2);
		
		System.out.println("Simulation successful! Here are the results:");
		if((choice1 == 1 && choice2 == 2)||(choice1 == 2 && choice2 == 1)) {
			//1
			long start = System.nanoTime();
			ReverseBubbleOWNMETHOD rbom = new ReverseBubbleOWNMETHOD();
			result1 = rbom.howManySteps(text2);
			long end = System.nanoTime();
			long duration = end - start;
			
			//2
			long start2 = System.nanoTime();
			Reverse r = new Reverse();
			result2 = r.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 1 took "  + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Reverse Bubble Sort Method 2 took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();
			
		} else if ((choice1 == 1 && choice2 == 3)||(choice1 == 3 && choice2 == 1)){
			//1
			long start = System.nanoTime();
			ReverseBubbleOWNMETHOD rbom = new ReverseBubbleOWNMETHOD();
			result1 = rbom.howManySteps(text2);
			long end = System.nanoTime();
			long duration = end - start;

			//3
			long start2 = System.nanoTime();
			BogoSort ps = new BogoSort();
			result2 = ps.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 1 took "  + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Bogo Sort took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();

		} else if ((choice1 == 1 && choice2 == 4)||(choice1 == 4 && choice2 == 1)){
			//1
			long start = System.nanoTime();
			ReverseBubbleOWNMETHOD rbom = new ReverseBubbleOWNMETHOD();
			result1 = rbom.howManySteps(text2);
			long end = System.nanoTime();
			long duration = end - start;

			//4
			long start2 = System.nanoTime();
			MergeSort ms = new MergeSort();
			result2 = ms.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 1 took "  + result1 + " steps, in"+ duration +" time" + "\n" + 
					"Merge Sort took " + result2+ " steps, in "+ duration2 + " time"); 
			alert.showAndWait();
		} else if ((choice1 == 1 && choice2 == 5)||(choice1 == 5 && choice2 == 1)){
			//1
			long start = System.nanoTime();
			ReverseBubbleOWNMETHOD rbom = new ReverseBubbleOWNMETHOD();
			result1 = rbom.howManySteps(text2);
			long end = System.nanoTime();
			long duration = end - start;

			//5
			long start2 = System.nanoTime();
			LowestGoesFirst2 lgf = new LowestGoesFirst2();
			result2 = lgf.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 1 took "  + result1 + " steps, in"+ duration +" time" + "\n" + 
					"Lowest Goes First took " + result2+ " steps, in "+ duration2 + " time"); 
			alert.showAndWait();
		} else if ((choice1 == 2 && choice2 == 3)||(choice1 == 3 && choice2 == 2)){
			//2
			long start = System.nanoTime();
			Reverse r = new Reverse();
			result1 = r.howManySteps(intArr);
			long end = System.nanoTime();
			long duration = end - start;

			//3
			long start2 = System.nanoTime();
			BogoSort ps = new BogoSort();
			result2 = ps.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;

			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 2 took " + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Bogo Sort took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();
		} else if ((choice1 == 2 && choice2 == 4)||(choice1 == 4 && choice2 == 2)){
			//2
			long start = System.nanoTime();
			Reverse r = new Reverse();
			result1 = r.howManySteps(intArr);
			long end = System.nanoTime();
			long duration = end - start;
			
			//4
			long start2 = System.nanoTime();
			MergeSort ms = new MergeSort();
			result2 = ms.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 2 took " + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Merge Sort took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();
			
		} else if ((choice1 == 2 && choice2 == 5)||(choice1 == 5 && choice2 == 2)){
			//2
			long start = System.nanoTime();
			Reverse r = new Reverse();
			result1 = r.howManySteps(intArr);
			long end = System.nanoTime();
			long duration = end - start;

			//5
			long start2 = System.nanoTime();
			LowestGoesFirst2 lgf = new LowestGoesFirst2();
			result2 = lgf.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Reverse Bubble Sort Method 2 took " + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Lowest Goes First took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();
			
		} else if ((choice1 == 3 && choice2 == 4)||(choice1 == 4 && choice2 == 3)){
			//3
			long start = System.nanoTime();
			BogoSort ps = new BogoSort();
			result1 = ps.howManySteps(intArr);
			long end = System.nanoTime();
			long duration = end - start;

			//4
			long start2 = System.nanoTime();
			MergeSort ms = new MergeSort();
			result2 = ms.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;

			Alert alert = new Alert(AlertType.INFORMATION, "Bogo Sort took " + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Merge Sort took " + result2 + " steps, in "+ duration2 +" time" );  
			alert.showAndWait();
		} else if ((choice1 == 3 && choice2 == 5)||(choice1 == 5 && choice2 == 3)){
			//3
			long start = System.nanoTime();
			BogoSort ps = new BogoSort();
			result1 = ps.howManySteps(intArr);
			long end = System.nanoTime();
			long duration = end - start;

			//5
			long start2 = System.nanoTime();
			LowestGoesFirst2 lgf = new LowestGoesFirst2();
			result2 = lgf.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Bogo Sort took " + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Lowest Goes First took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();

		} else if ((choice1 == 4 && choice2 == 5)||(choice1 == 5 && choice2 == 4)){
			//4
			long start = System.nanoTime();
			MergeSort ms = new MergeSort();
			result1 = ms.howManySteps(intArr);
			long end = System.nanoTime();
			long duration = end - start;

			//5
			long start2 = System.nanoTime();
			LowestGoesFirst2 lgf = new LowestGoesFirst2();
			result2 = lgf.howManySteps(intArr);
			long end2 = System.nanoTime();
			long duration2 = end2 - start2;
			
			Alert alert = new Alert(AlertType.INFORMATION, "Merge Sort took " + result1 + " steps, in "+ duration +" time" + "\n" + 
					"Lowest Goes First took " + result2 + " steps, in "+ duration2 +" time" ); 
			alert.showAndWait();
		}
		int[] results = {result1, result2};
		return results;
	}
	
	public void bubbleSortOWN(Stage primaryStage)throws Exception{
		AnchorPane root = new AnchorPane();
		Label inputLabel = new Label("Insert list here:");
		TextField inputText = new TextField("{0}");
		
		Button okBubble = new Button("Ok Bubble Sort");
		Button okSingle = new Button("Ok Single Unsort");
		Button okSingleSort = new Button ("Ok Single Sort");
		Button okNew = new Button("Ok New List");
		Label bubbleTitle = new Label("Bubble Sort Results:");
		Label outputBubble = new Label("Sorted label goes here");	
		Label outputPointer = new Label("Pointer Goes here");
		Label outputBubbleSort = new Label("Position list fill label");	
		Label outputBubble2 = new Label("Unsorted label goes here");
		Label outputBubble3 = new Label("Position label goes here");
		Label outputPointer2 = new Label("Pointer 2 goes here");
		
		NumberAxis na = new NumberAxis();
		CategoryAxis ca = new CategoryAxis();
		bc = new BarChart(ca, na);
		bc.setAnimated(false);
		
		XYChart.Series val1 = new XYChart.Series<>();
		val1.getData().add(new XYChart.Data<>("Bubble Sort Own Method", 0));
		bc.getData().addAll(val1);
		
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 10.0);
		AnchorPane.setTopAnchor(inputText, 25.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setLeftAnchor(bc, 40.0);
		AnchorPane.setTopAnchor(bc, 280.0);
		root.getChildren().add(bc);
	
		
		AnchorPane.setLeftAnchor(okSingle, 500.0);
		AnchorPane.setTopAnchor(okSingle, 140.0);
		root.getChildren().add(okSingle);
		
		AnchorPane.setLeftAnchor(okBubble, 500.0);
		AnchorPane.setTopAnchor(okBubble, 60.0);
		root.getChildren().add(okBubble);
		
		AnchorPane.setLeftAnchor(okSingleSort, 500.0);
		AnchorPane.setTopAnchor(okSingleSort, 100.0);
		root.getChildren().add(okSingleSort);
		
		AnchorPane.setLeftAnchor(okNew, 500.0);
		AnchorPane.setTopAnchor(okNew, 180.0);
		root.getChildren().add(okNew);
		
		AnchorPane.setLeftAnchor(bubbleTitle, 10.0);
		AnchorPane.setTopAnchor(bubbleTitle,60.0);
		root.getChildren().add(bubbleTitle);
		
		AnchorPane.setLeftAnchor(outputBubble, 20.0);
		AnchorPane.setTopAnchor(outputBubble,80.0);
		root.getChildren().add(outputBubble);
		
		AnchorPane.setLeftAnchor(outputPointer, 20.0);
		AnchorPane.setTopAnchor(outputPointer, 100.0);
		root.getChildren().add(outputPointer);
		
		outputBubbleSort.autosize();
		outputBubbleSort.setWrapText(true);
		outputBubbleSort.setMaxWidth(480.0);
		AnchorPane.setLeftAnchor(outputBubbleSort, 20.0);
		AnchorPane.setTopAnchor(outputBubbleSort, 120.0);
		root.getChildren().add(outputBubbleSort);
			
		
		
		AnchorPane.setLeftAnchor(outputBubble2, 20.0);
		AnchorPane.setTopAnchor(outputBubble2,180.0);
		root.getChildren().add(outputBubble2);
		
		AnchorPane.setLeftAnchor(outputPointer2, 20.0);
		AnchorPane.setTopAnchor(outputPointer2, 200.0);
		root.getChildren().add(outputPointer2);
		
		outputBubble3.autosize();
		outputBubble3.setWrapText(true);
		outputBubble3.setMaxWidth(480.0);
		AnchorPane.setLeftAnchor(outputBubble3, 20.0);
		AnchorPane.setTopAnchor(outputBubble3,220.0);
		root.getChildren().add(outputBubble3);
		
		
		ReverseBubbleOWNMETHOD re = new ReverseBubbleOWNMETHOD();
        
		outputBubble.setText("Sorted: " );
		outputBubble2.setText("Unsorted: " );
		outputBubble3.setText("Position List: " );
		
		
		
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 700, 700));
		primaryStage.show();
		
		
		
		/** Button Actions **/
		
		//both sort and unsort in one button
		okBubble.setOnAction(event -> {			
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			outputBubble.setText("Sorted: "+ 
					intArrToString(ReverseBubbleOWNMETHOD.main((inputText.getText())))
					);
			int pos2[] = new int[(inputText.getText().length() + inputText.getLength())];
			outputBubble2.setText("Unsorted: " + 
					printArray(re.unsort(stringToIntArr(inputText.getText()), pos2))
					);
			outputBubble3.setText("Position List: " + 
					printArray(re.cleanPos(re.savePos()))
					);
			}
		}
		);
		
		
		counter = 0;
		counter2 = 0;
		counter3 = 1;
		
		//unsorting
		okSingle.setOnAction(event2 -> {	
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			int[] var = {};
			int[] reY = {};
			int[] reY1 = {};
			int[] rePos2 = {};
//			if(counter == 0) {
				var = stringToIntArr(inputText.getText());
				reY = var.clone();
				
//				
				int[] rePos = new int[(var.length * var.length)];
				for(int x = 0; x<rePos.length;x++) {
					rePos[x] = 0;
				}
				ReverseBubbleOWNMETHOD reSingle = new ReverseBubbleOWNMETHOD();
				ReverseBubbleOWNMETHOD.main(intArrToString(reY));
				outputBubble3.setText("Position List: " + printArray(reSingle.cleanPos(reSingle.savePos())));

			
			//unsorting
				
				int gPos=0;

			if (done == false) {
				
				Alert alert = new Alert(AlertType.INFORMATION, "Creating List and Instantiating Values. Keep clicking!"); 
				alert.showAndWait();
				ReverseBubbleOWNMETHOD tempre = new ReverseBubbleOWNMETHOD();
				
				g = stringToIntArr(inputText.getText());
				posg = new int[(g.length*g.length)];

				for (int m = 0; m < posg.length;m++) {
					posg[m]=0;
				}
				tempre.sort(g, posg);
				posg = tempre.cleanPos(posg);

				n = posg.length ;

				boolean test = false;
				while(test == false) {
					int n = posg.length;
					if(posg[n-1] == 0) {
						int[] tempposg = new int[posg.length];
						for(int x = 0; x<posg.length-1;x++) {
							tempposg[x] = posg[x];
						}
						posg = tempposg;
						test = true; 
					}else {
						test = true;
					}
				}
				
				done = true;
			}else{
				if(n>0) {
				//var c for swapping items
				//var m for temp storing the pos items one by one
				int c = 0;
				System.out.println(printArray(posg));
				m = posg[n-1];
				System.out.println(m);
				//checks if the instruction is 0, i.e. null
				if(m == 0) {
					//skip this location
				}else {
					//swaps with 
					System.out.println(printArray(g));
					
					c = g[m-1];
					g[m-1] = g[m];
					g[m] = c;
					gPos = m;
					
					
					System.out.println(printArray(g));
				}
				n=n-1;
				System.out.println(n);
				}
			}
			makeBarChart(g);

			outputBubble2.setText("Unsorting: "+ intArrToString(g));
			
			rePosC = new char[g.length]; 
			for(int x = 0; x <rePosC.length; x++) {
				rePosC[x] = 0;
			}
			rePosC[gPos] = '^';
		//	rePos[posCounter - 1] = 0;
			System.out.println(charArrToString(rePosC));
			outputPointer2.setText("Current:    "+charArrToString(rePosC));
			
			//Check to see if it has been unsorted yet
			int[] checker = g.clone();
			if(checkUnsorted(checker, stringToIntArr(inputText.getText())) == true) {
				Alert alert2 = new Alert(AlertType.INFORMATION, "Unsorting is done!");
				alert2.showAndWait();
			}
			}
		});
		
		
		//sorting
		okSingleSort.setOnAction(event3 ->{
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			
			int[] var = {};
			int[] reY = {};
			int[] reY1 = {};
					
			
			
			if(counter == 0) {
				Alert alert = new Alert(AlertType.INFORMATION, "Creating List and Instantiating Values. Keep clicking!");
				alert.showAndWait();
				
				var = stringToIntArr(inputText.getText());
				reY = var.clone();
				
				rePos = new int[(var.length * var.length * var.length)];
				for(int x = 0; x<rePos.length;x++) {
					rePos[x] = 0;
				}
				rePosC = new char[(var.length)];
				for(int x = 0; x<rePosC.length;x++) {
					rePosC[x] = '-';
				}
				//outputBubble3.setText("Position List: " + printArray(reSingle.savePos()));
				
				posCounter = 0;
				
				
				System.out.println("got here");
				counter = 1;
			}else {
				String converter = outputBubble.getText();
				converter = converter.substring(8, converter.length());
				var = stringToIntArr(converter);
			}
			if(checkSorted(var) == false) {
				if(counter3<var.length) {
					if(var[counter3-1]>var[counter3]) {
						int temp = 0;
						
						rePos[posCounter] = counter3;
						
						for(int x = 0; x <rePosC.length; x++) {
							rePosC[x] = 0;
						}
						rePosC[rePos[posCounter] - 1] = '^';
					//	rePos[posCounter - 1] = 0;
						System.out.println(charArrToString(rePosC));
						posCounter = posCounter + 1;
						
						temp = var[counter3-1];
						var[counter3-1] = var[counter3];
						var[counter3] = temp;
						
						
						//bold = temp;
						
						
						
						counter3 = counter3 + 1;
					}else {
						counter3 = counter3 + 1;
					}
				}else {
					counter3 = 1;
				}
			
			
			//barchart
			makeBarChart(var);
			
			//outputting info	
			ReverseBubbleOWNMETHOD reom = new ReverseBubbleOWNMETHOD();	
			//Check to see if it has been sorted yet
			if(checkSorted(var) == true) {
				Alert alert2 = new Alert(AlertType.INFORMATION, "Sorting is done!");
				alert2.showAndWait();
			}	
			
			outputBubble.setText("Sorted: " + intArrToString(var));
			outputPointer.setText("Current:" + charArrToString(rePosC));
			outputBubbleSort.setText("Position List: " + intArrToString(reom.cleanPos(rePos)));
			}
			
			}	
		});
		
		okNew.setOnAction(event4 ->{
			counter = 0;
			Driver d = new Driver();
			primaryStage.close();
			d.start(primaryStage);
		});
	}

	private Boolean checkInput(String text2) {
		boolean isIntArr = true;
		int[] tempArr = new int[1];
		try {
			tempArr = stringToIntArr(text2);
		}catch(Exception e) {
			Alert note = new Alert(AlertType.INFORMATION, "Your input must be in the format of {1,2,3}");
			note.showAndWait();
			isIntArr = false;
		}
		return isIntArr;
	}
	
	


	public void bubbleSort(Stage primaryStage)throws Exception{
		AnchorPane root = new AnchorPane();
		Label inputLabel = new Label("Insert list here:");
		TextField inputText = new TextField("{0}");
		
		Button okBubble = new Button("Ok Bubble Sort");
		Button okSingle = new Button("Ok Single Unsort");
		Button okSingleSort = new Button ("Ok Single Sort");
		Button okNew = new Button("Ok New List");
		Label bubbleTitle = new Label("Bubble Sort Results:");
		Label outputBubble = new Label("Sorted label goes here");	
		Label outputPointer = new Label("");
		Label outputBubbleSort = new Label("Position list fill label");	
		Label outputBubble2 = new Label("Unsorted label goes here");
		Label outputBubble3 = new Label("Position label goes here");
		Label outputPointer2 = new Label("");
		
		NumberAxis na = new NumberAxis();
		CategoryAxis ca = new CategoryAxis();
		bc = new BarChart(ca, na);
		bc.setAnimated(false);
		
		XYChart.Series val1 = new XYChart.Series<>();
		val1.getData().add(new XYChart.Data<>("Bubble Sort Method 2", 0));
		bc.getData().addAll(val1);
	
		
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 10.0);
		AnchorPane.setTopAnchor(inputText, 25.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setLeftAnchor(bc, 40.0);
		AnchorPane.setTopAnchor(bc, 280.0);
		root.getChildren().add(bc);
		
		AnchorPane.setLeftAnchor(okSingle, 500.0);
		AnchorPane.setTopAnchor(okSingle, 140.0);
		root.getChildren().add(okSingle);
		
		AnchorPane.setLeftAnchor(okBubble, 500.0);
		AnchorPane.setTopAnchor(okBubble, 60.0);
		root.getChildren().add(okBubble);
		
		AnchorPane.setLeftAnchor(okSingleSort, 500.0);
		AnchorPane.setTopAnchor(okSingleSort, 100.0);
		root.getChildren().add(okSingleSort);
		
		AnchorPane.setLeftAnchor(okNew, 500.0);
		AnchorPane.setTopAnchor(okNew, 180.0);
		root.getChildren().add(okNew);
		
		AnchorPane.setLeftAnchor(bubbleTitle, 10.0);
		AnchorPane.setTopAnchor(bubbleTitle,60.0);
		root.getChildren().add(bubbleTitle);
		
		AnchorPane.setLeftAnchor(outputBubble, 20.0);
		AnchorPane.setTopAnchor(outputBubble,80.0);
		root.getChildren().add(outputBubble);
		
		AnchorPane.setLeftAnchor(outputPointer, 20.0);
		AnchorPane.setTopAnchor(outputPointer, 100.0);
		root.getChildren().add(outputPointer);
		
		AnchorPane.setLeftAnchor(outputBubbleSort, 20.0);
		AnchorPane.setTopAnchor(outputBubbleSort, 120.0);
		root.getChildren().add(outputBubbleSort);
		
		AnchorPane.setLeftAnchor(outputBubble2, 20.0);
		AnchorPane.setTopAnchor(outputBubble2,160.0);
		root.getChildren().add(outputBubble2);
		
		AnchorPane.setLeftAnchor(outputPointer2, 20.0);
		AnchorPane.setTopAnchor(outputPointer2, 180.0);
		root.getChildren().add(outputPointer2);
		
		AnchorPane.setLeftAnchor(outputBubble3, 20.0);
		AnchorPane.setTopAnchor(outputBubble3,200.0);
		root.getChildren().add(outputBubble3);
		
		
		String y = inputText.getText();
        
		int pos[] = new int[(y.length() + y.length())];
		outputBubble.setText("Sorted: " );
		outputBubble2.setText("Unsorted: " );
		outputBubble3.setText("Position List: " );
		
		
		
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 700, 700));
		primaryStage.show();
		
		/* Button Declarations*/
		Reverse reverse = new Reverse();
		
		okBubble.setOnAction(event -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			int[] y1 =  stringToIntArr(inputText.getText());
			
			outputBubble.setText("Sorted: " + 
					intArrToString(reverse.sort(y1, reverse.generatePos(y1)))
					);
			outputPointer.setText("");
			outputBubbleSort.setText("Position List: " +
					intArrToString(reverse.getPos())
					);
			
			
			outputBubble2.setText("Unsorted: " + 
					intArrToString(reverse.unsort(y1,reverse.getPos()))
					);
			outputPointer2.setText("");
			outputBubble3.setText("Position List: " + 
					intArrToString(reverse.getPos2())
					);
			}
			});
		
		Reverse reverseSort = new Reverse();
		okSingleSort.setOnAction(event2 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			
			if(doneStep1==false) {
				y1R =  stringToIntArr(inputText.getText());
				makeBarChart(y1R);
				pos1R = reverseSort.generatePos(y1R);
				doneStep1 = true;
			}else {
				outputBubble.setText("Sorted: " + 
					intArrToString(reverseSort.sortSingle(y1R, reverseSort.generatePos(y1R)))
					);
				makeBarChart(y1R);
				outputBubbleSort.setText("Position List: " +
					intArrToString(reverseSort.getPosSingle1())
					);
				
			
			}
			}
			});
		
		Reverse reverseUnsort = new Reverse();
		okSingle.setOnAction(event3 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			if(doneStep2==false) {
				int[] temp = stringToIntArr(inputText.getText());
				y2R = reverseUnsort.sort(temp, reverseUnsort.generatePos(temp)).clone();
				pos2R = reverseUnsort.getPos();
				doneStep2 = true;
				makeBarChart(y2R);

			}
			
			System.out.println(intArrToString(y2R));
			System.out.println(intArrToString(pos2R));
			makeBarChart(y2R);

			outputBubble2.setText("Unsorted: " +
					intArrToString(reverseUnsort.unsortSingle(y2R, pos2R))
			);
			
			outputBubble3.setText("Position List: " +
					intArrToString(reverseUnsort.getPosSingle2())
			);
			
			}	
		});
		
		okNew.setOnAction(event4 ->{
			counter = 0;
			Driver d = new Driver();
			primaryStage.close();
			d.start(primaryStage);
		});
		
		
	}
	
	public void premutationSort(Stage primaryStage)throws Exception{
		
		Alert note = new Alert(AlertType.INFORMATION, "Please note this is a basic sorting method.");
		note.showAndWait();
		AnchorPane root = new AnchorPane();
		Label inputLabel = new Label("Insert list here:");
		TextField inputText = new TextField("{5,1,3,4,6}");
		
		Button okPremu = new Button("Ok Bogo Sort");
		Button okTries = new Button("Show sort attempts");
		Button okNew = new Button("Ok New List");
		Label premuTitle = new Label("Bogo Sort Results:");
		Label outputPremu = new Label("Sorted label goes here");	
		Label outputPremu2 = new Label("Unsorted label goes here");
		Label outputPremu3 = new Label("Position label goes here");
		
	
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 10.0);
		AnchorPane.setTopAnchor(inputText, 25.0);
		root.getChildren().add(inputText);
		
		
		AnchorPane.setLeftAnchor(okPremu, 210.0);
		AnchorPane.setTopAnchor(okPremu, 60.0);
		root.getChildren().add(okPremu);
		
		AnchorPane.setLeftAnchor(premuTitle, 10.0);
		AnchorPane.setTopAnchor(premuTitle,60.0);
		root.getChildren().add(premuTitle);
		
		AnchorPane.setLeftAnchor(outputPremu, 20.0);
		AnchorPane.setTopAnchor(outputPremu,80.0);
		root.getChildren().add(outputPremu);
		
		AnchorPane.setLeftAnchor(outputPremu2, 20.0);
		AnchorPane.setTopAnchor(outputPremu2,100.0);
		root.getChildren().add(outputPremu2);
		
		AnchorPane.setLeftAnchor(outputPremu3, 20.0);
		AnchorPane.setTopAnchor(outputPremu3,120.0);
		root.getChildren().add(outputPremu3);
		
		AnchorPane.setLeftAnchor(okNew, 210.0);
		AnchorPane.setTopAnchor(okNew, 180.0);
		root.getChildren().add(okNew);		
		
		String y = inputText.getText();
		ReverseBubbleOWNMETHOD re = new ReverseBubbleOWNMETHOD();
		BogoSort ps = new BogoSort();
        
		
		int[] yClone = stringToIntArr(y).clone();
		outputPremu.setText("Sorted: " + printArray(ps.sort(stringToIntArr(y))));
		outputPremu2.setText("Unsorted: " + printArray(ps.unsort(stringToIntArr(y), yClone)));
		outputPremu3.setText("Number of shuffles: " + ps.returnPos());
		
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.show();
		
		
		okPremu.setOnAction(event2 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			String y2 = inputText.getText();
			BogoSort.pos = 0;
			outputPremu.setText("Sorted: " + 
					printArray(ps.sort(stringToIntArr(y2)))
					);
			int[] yClone2 = stringToIntArr(y2).clone();
			outputPremu2.setText("Unsorted: " + 
					printArray(ps.unsort(stringToIntArr(y2), yClone2))					
					);
			outputPremu3.setText("Position List: " + 
					ps.returnPos()
					);
			}
		});
		
		okNew.setOnAction(event4 ->{
			counter = 0;
			Driver d = new Driver();
			primaryStage.close();
			d.start(primaryStage);
		});
		
	}

	public void mergeSort(Stage primaryStage)throws Exception{
		Alert alertMerge = new Alert(AlertType.INFORMATION, "Merge Sort does not have single step functionality since it does everything in one step!");
		alertMerge.showAndWait();
		
		AnchorPane root = new AnchorPane();
		Label inputLabel = new Label("Insert list here:");
		TextField inputText = new TextField("{0}");
		
		Button okMerge = new Button("Ok Merge Sort");
		Button okNew = new Button("Ok New List");
		Label mergeTitle = new Label("Merge Sort Results:");
		Label outputMerge = new Label("Sorted label goes here");	
		Label outputMerge2 = new Label("Unsorted label goes here");
		Label outputMerge3 = new Label("Position label goes here");
		
		
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 10.0);
		AnchorPane.setTopAnchor(inputText, 25.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setLeftAnchor(okMerge, 250.0);
		AnchorPane.setTopAnchor(okMerge, 210.0);
		root.getChildren().add(okMerge);
		
		AnchorPane.setLeftAnchor(mergeTitle, 10.0);
		AnchorPane.setTopAnchor(mergeTitle,60.0);
		root.getChildren().add(mergeTitle);
		
		AnchorPane.setLeftAnchor(outputMerge, 20.0);
		AnchorPane.setTopAnchor(outputMerge,80.0);
		root.getChildren().add(outputMerge);
		
		AnchorPane.setLeftAnchor(outputMerge2, 20.0);
		AnchorPane.setTopAnchor(outputMerge2,100.0);
		root.getChildren().add(outputMerge2);
		
		AnchorPane.setLeftAnchor(outputMerge3, 20.0);
		AnchorPane.setTopAnchor(outputMerge3,120.0);
		root.getChildren().add(outputMerge3);
		
		AnchorPane.setLeftAnchor(okNew, 250.0);
		AnchorPane.setTopAnchor(okNew, 250.0);
		root.getChildren().add(okNew);	
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.show();
		
		
		MergeSort ms = new MergeSort();
		
		
		okMerge.setOnAction(event2 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			
			String[] y2 = {inputText.getText()};
			outputMerge.setText("Sorted: "  +
					intArrToString(ms.main(stringToIntArr(y2[0])))
					);
			outputMerge2.setText("Unsorted: " +
					intArrToString(ms.unsort(stringToIntArr(y2[0])))
					);
			outputMerge3.setText("Position List: " +
								intArrToString(ms.sortedPos)
					);
			}
		});
		
		
		okNew.setOnAction(event4 ->{
			counter = 0;
			Driver d = new Driver();
			primaryStage.close();
			d.start(primaryStage);
		});
		
		
	}
	
	public void lgf(Stage primaryStage)throws Exception{
		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/Layout.fxml"));
		AnchorPane root = new AnchorPane();
		Label inputLabel = new Label("Insert list here:");
		TextField inputText = new TextField("{0}");
		
		Button okLGF = new Button("Ok Lowest Goes First");
		Button okLGFSingleSort = new Button("Ok Single Sort");
		Button okLGFSingleUnsort = new Button ("Ok Single Unsort");
		Button okNew = new Button("Ok New List");
		Label lgfTitle = new Label("Sort Results:");
		Label outputLGF = new Label("Sorted label goes here");	
		Label outputLGF2 = new Label("Unsorted label goes here");
		Label outputLGF3 = new Label("Position label goes here");
		
		NumberAxis na = new NumberAxis();
		CategoryAxis ca = new CategoryAxis();
		bc = new BarChart(ca, na);
		bc.setAnimated(false);
		
		XYChart.Series val1 = new XYChart.Series<>();
		val1.getData().add(new XYChart.Data<>("Lowest Goes First Own Method", 0));
		bc.getData().addAll(val1);
		
		AnchorPane.setLeftAnchor(inputLabel, 10.0);
		root.getChildren().add(inputLabel);
		
		AnchorPane.setLeftAnchor(inputText, 10.0);
		AnchorPane.setTopAnchor(inputText, 25.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setLeftAnchor(bc, 40.0);
		AnchorPane.setTopAnchor(bc, 280.0);
		root.getChildren().add(bc);
		
		AnchorPane.setLeftAnchor(okLGF, 500.0);
		AnchorPane.setTopAnchor(okLGF, 60.0);
		root.getChildren().add(okLGF);
		
		AnchorPane.setLeftAnchor(okLGFSingleSort, 500.0);
		AnchorPane.setTopAnchor(okLGFSingleSort, 100.0);
		root.getChildren().add(okLGFSingleSort);
		
		AnchorPane.setLeftAnchor(okLGFSingleUnsort, 500.0);
		AnchorPane.setTopAnchor(okLGFSingleUnsort, 140.0);
		root.getChildren().add(okLGFSingleUnsort);
		
		AnchorPane.setLeftAnchor(lgfTitle, 10.0);
		AnchorPane.setTopAnchor(lgfTitle,60.0);
		root.getChildren().add(lgfTitle);
		
		AnchorPane.setLeftAnchor(okNew, 500.0);
		AnchorPane.setTopAnchor(okNew, 180.0);
		root.getChildren().add(okNew);		
		
		outputLGF.autosize();
		outputLGF.setWrapText(true);
		outputLGF.setMaxWidth(480.0);
		AnchorPane.setLeftAnchor(outputLGF, 20.0);
		AnchorPane.setTopAnchor(outputLGF, 80.0);
		root.getChildren().add(outputLGF);
		
		outputLGF2.autosize();
		outputLGF2.setWrapText(true);
		outputLGF2.setMaxWidth(480.0);
		AnchorPane.setLeftAnchor(outputLGF2, 20.0);
		AnchorPane.setTopAnchor(outputLGF2, 100.0);
		root.getChildren().add(outputLGF2);
		
		outputLGF3.autosize();
		outputLGF3.setWrapText(true);
		outputLGF3.setMaxWidth(480.0);
		AnchorPane.setLeftAnchor(outputLGF3, 20.0);
		AnchorPane.setTopAnchor(outputLGF3, 120.0);
		root.getChildren().add(outputLGF3);
		
		outputLGF.setText("Sorted: ");
		outputLGF2.setText("Unsorted: " );
		outputLGF3.setText("Position List: ");
		
		primaryStage.setTitle("Sorting Methods");
		primaryStage.setScene(new Scene(root, 700, 700));
		primaryStage.show();
		
		
		okLGF.setOnAction(event2 -> {
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			LowestGoesFirst2 psa = new LowestGoesFirst2();
			outputLGF.setText("Sorted: " + 
					printArray(psa.sort(stringToIntArr(inputText.getText())))
					);
			outputLGF2.setText("Unsorted: " +
					printArray(psa.unsort(stringToIntArr(outputLGF.getText().substring(8, outputLGF.getText().length()))))
					);
			outputLGF3.setText("Position List: " +
					printArray(psa.returnPos())
					); 
			}
		});
		
		
		//sorting
		okLGFSingleSort.setOnAction(eventSingleSort ->{
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			LowestGoesFirst2 lgf2 = new LowestGoesFirst2();
			if (firstPass == false){
				permaY = stringToIntArr(inputText.getText());
				//initialise pos
				permaPos = new int[permaY.length];
				for(int x=0;x<permaPos.length;x++) {
					permaPos[x]=0;
				}
				firstPass = true;
				//current starting position
				c = 0;
				posc = 0;
			}
			
			int[] y = permaY;
			if(checkSorted(y) == false && posc < permaPos.length) {
				//find the lowest item
				int lowest = 10000000;
				int posx = 0;
				for(int x = c; x<y.length;x++) {
					if(y[x] < lowest) {
						lowest = y[x];
						posx = x;
								
					}
				}
				//bring lowest to the "front"
				int temp = y[posx];
				y[posx] = y[c];
				y[c] = temp;
				c = c+1;
				permaPos[posc] = posx+1;
				posc = posc + 1;
				permaY = y;
				makeBarChart(permaY);
			}else if(checkSorted(y) == true){
				Alert alert2 = new Alert(AlertType.INFORMATION, "Sorting is done!");
				alert2.showAndWait();
			}
				
			outputLGF.setText("Sorted: " + 
					printArray(permaY));
			outputLGF3.setText("Position List: "+
					printArray(cleanPos(permaPos)));
			}
			
		});
		
		okLGFSingleUnsort.setOnAction(eventSingleUnsort ->{
			if(checkInput(inputText.getText()) == false) {
				
			}else {
			//check to see if unsorted
			int[] checker = new int[1];
			checker = stringToIntArr(inputText.getText());
			for(int o = 0; o<checker.length;o++) {
				if(permaY2[o] != checker[o]){
					break;
				}
				if(o==checker.length-1) {
					Alert alert2 = new Alert(AlertType.INFORMATION, "Unsorting is done!");
					alert2.showAndWait();
				}
			}
			
			
			if(firstPass2 == false) {
				LowestGoesFirst2 a = new LowestGoesFirst2();
				permaY2 = a.sort(stringToIntArr(inputText.getText()));
				permaPos = cleanPos(a.returnPos());
				bigX = permaPos.length-1;
				firstPass2 = true;
				System.out.println("here");
			}
			if(bigX >= 0) {
				int aim = permaPos[bigX] - 1;
				int swap = permaY2[aim];
				permaY2[aim] = permaY2[bigX];
				permaY2[bigX] = swap;
				bigX = bigX -1;
				makeBarChart(permaY2);
			}
			
			
			
			
			
			outputLGF2.setText("Unsorted: " + 
					printArray(permaY2));
			outputLGF3.setText("Position List: "+
					printArray(cleanPos(permaPos)));
			}
		});
		
		okNew.setOnAction(event4 ->{
			counter = 0;
			Driver d = new Driver();
			primaryStage.close();
			d.start(primaryStage);
		});
			
	}

	public String charArrToString(char[] m){
		String tempo = "";
		int n = m.length; 
        tempo = tempo + "[";
        for (int i=0; i<n; ++i) {
        	tempo = tempo + (m[i]+"0,"); 
        }
        tempo = tempo + "]";
        
        return tempo;
	}
	
	public String intArrToString(int[] m){
		String tempo = "";
		int n = m.length; 
        tempo = tempo + "[";
        for (int i=0; i<n; ++i) {
        	tempo = tempo + (m[i]+","); 
        }
        
        String tempo2 = tempo.substring(0, tempo.length()-1);
//        System.out.print("]");
        tempo2 = tempo2 + "]";
//        System.out.println(); 
         return tempo2;
	}

	public int[] stringToIntArr(String y) {
		y = y.substring(1, y.length()-1);
		String y3[] = y.split(",");
		int x[] = new int[y3.length];
		for(int o = 0;o<y3.length;o++) {
				int temp = Integer.parseInt(y3[o]);
				x[o] = temp;
		}
		return x;
	}
	
	public static String printArray(int x[]){ 
		  int n = x.length; 
	        String temp = "[";
//	        System.out.print("[");
	        for (int i=0; i<n; ++i) {
	        	if(i==n) {
//	        		System.out.print(x[i]+",");
	        		temp = temp+ x[i];
	        	} else {
//	        		System.out.print(x[i]+",");
	        		temp = temp+ x[i]+",";
	        	}
	        }
	        String temp2 = temp.substring(0, temp.length()-1);
//	        System.out.print("]");
	        temp2 = temp2 + "]";
//	        System.out.println(); 
	         return temp2;
	   } 
	   
	public Boolean checkSorted(int y[]) {
			for(int i = 1; i<y.length;i++) {
				if(y[i-1]>y[i]) {
					return false;
				}
			}
			return true;
		}
	
	public Boolean checkUnsorted(int[] original, int[] y) {
		for(int i = 0; i<y.length;i++) {
			if(original[i] != y[i]) {
				return false;
			}
		}
		return true;
	}
	  
	public void makeBarChart(int[] y) {

			//bar chart
			XYChart.Series barvals = new XYChart.Series<>();
			bc.getData().clear();
			bc.layout();
			int[] barToBe = y.clone();
			for(int x = 0; barToBe.length>x;x++) {
				int barItem = barToBe[x];
				barvals.getData().add(new XYChart.Data<>("Item " + (x+1), barItem));
			}
			
			bc.getData().addAll(barvals);	
		}

	public int[] cleanPos(int[] position) {
		int m = 0;
		for(int o = 0; o<position.length;o++) {
			if(position[o] == 0) {
				
			} else {
				m=m+1;
			}
		}
		
		int[] temp = new int[(m)];
		for(int x = 0; x<m;x++) {
			if(position[x] != 0) {
				temp[x] = position[x];
			}			
		}
		return temp;
	}  
}
