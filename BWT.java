import java.util.Arrays;
import java.util.Comparator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;


/**
 * Please make note, I am comparing my unsorting method to a preexisting unsorting method which can be found here, 
 * which I recognise as the standard method to perform the burrow wheeler transform. 
 * https://gist.github.com/skitaoka/9df1cea3d8e9b9cf80af 
 */




public class BWT extends Application{
	static int[] pos;
	static int decodeTimeO = 0;
	static int decodeTimeM = 0;
	
	static long totalSizeO = 0;
	static long totalSizeM = 0;
	
	static boolean firstPass = false;
	
	
	//driver
	static String eargs = "";
	static String dargs = "";
	static String dargs2 = "";
	
	
	public String encode(String s) {
		String[] sArray = new String[s.length()];
		for (int x = 0;x<sArray.length;x++) {
			sArray[x] = s.substring(x) + s.substring(0, x);
			System.out.println(sArray[x]);
		}
		Arrays.sort(sArray);
		String temp = "";
		for(int x = 0;x<sArray.length;x++) {
			temp = temp + sArray[x];
		}
		System.out.println(temp);
		
			
		//rotate them back into original and count how many steps that took to get the position
		System.out.println("we are looking for: " + s);
		int element = 0;
		int counter = 1;
		int posC = 0;
		for(int x=0;x<sArray.length;x++) {
			
			System.out.println(x);

			String test = sArray[x];
			System.out.println("test is now: "+test);
			counter = 1;
			while(element<sArray.length){
				if(test.equals(s)) {
					System.out.println("test is done: "+test);
					pos[posC]= counter;
					posC++;
					element=element+1;
					break;
				}else {
					//rotate
					test = test.substring(test.length()-1, test.length())+test.substring(0, test.length()-1);
					System.out.println("test is now: "+test);
					counter = counter + 1;
				}
				
			
			}
		}
				

		String ans = "";
		for (int x = 0; x < sArray.length; ++x) {
			ans = ans + sArray[x].charAt(sArray[x].length()-1);			
			String temp2 = sArray[x];
			temp2.charAt(0);
		}
		return ans;
	}

  	public static final class BWTComp implements Comparator<Integer> {
	  	public String s;

    	BWTComp(String s) {
    		decodeTimeO++;
    		this.s = s;
    	}

    	@Override
    	public int compare(Integer x, Integer y) {
    		decodeTimeO++;
    		return s.charAt(x) - s.charAt(y);
    	}	
  	}
  	
  	
  	private static String decode(String arg) {
  		Integer[] array = new Integer[arg.length()];
  		//System.out.println(ObjectSizeCalculator.getObjectSize(array);
  		totalSizeO = totalSizeO + array.length;
  		for (int i = 0; i < array.length;i++) {
  			array[i] = i;
  		}
  		
  		Arrays.sort(array, new BWTComp(arg));
  		
  		//System.out.println(printArray(array));
  		int sp = 0;
  		for(sp=0; arg.charAt(sp) !='|'; sp++);
  		//increase by value of sp since that is how many loops in the for loop took place
  		totalSizeO = totalSizeO + sp;

  		
  		StringBuilder sb = new StringBuilder();	
    	for (int x = 0; x < array.length - 1; ++x) {
    		sp = array[sp];
    		totalSizeO++;
      		char c = arg.charAt(sp);
    		totalSizeO++;
      		sb.append(c);
      		decodeTimeO++;
    	}
    	return sb.toString();
  	}
  	
  	public static String decodeMe(String arg) {
  		System.out.println();
  		StringBuilder args = new StringBuilder(arg);
  		totalSizeM = totalSizeM+args.length();
  		//populate args
  		
  		
		for(int x = 0; x < pos.length; x++) {
			totalSizeM = totalSizeM + pos.length;
			int current = pos[x];
			totalSizeM++;
			char currentPos = args.charAt(x);
			totalSizeM++;
			int befCurrent = x-1;
			totalSizeM++;

				  while (befCurrent>=0 && pos[befCurrent] > current){ 
		                pos[befCurrent+1] = pos[befCurrent]; 
		                args.setCharAt((befCurrent+1), args.charAt(befCurrent));
		                befCurrent = befCurrent-1; 
		                decodeTimeM = decodeTimeM +1;
		            } 
		          pos[befCurrent+1] = current;
		          args.setCharAt((befCurrent+1), currentPos);
		          
		}
		String ans = args.toString();
		totalSizeM = totalSizeM+ans.length();
		ans = ans.substring(1,ans.length());
		return ans;
  	}
  	
  	public static String printArray(int[] array){ 
		  int n = array.length; 
	        String temp = "[";
//	        System.out.print("[");
	        for (int i=0; i<n; ++i) {
	        	if(i==n) {
//	        		System.out.print(x[i]+",");
	        		temp = temp+ array[i];
	        	} else {
//	        		System.out.print(x[i]+",");
	        		temp = temp+ array[i]+",";
	        	}
	        }
	        String temp2 = temp.substring(0, temp.length()-1);
//	        System.out.print("]");
	        temp2 = temp2 + "]";
//	        System.out.println(); 
	         return temp2;
	   } 
  	
  	public static void go(String[] args) {
  		//launch the application
  		launch(args);
  	}
  	 
  	public static void main(String[] args) {
  		if(firstPass == false) {
  			go(args);
  			firstPass = true;
  		}
  	}
  	
  	public void start(Stage primaryStage) {		
		AnchorPane root = new AnchorPane();
		
		//creating items for the pane
		Label intro = new Label("Choose a sorting method:");
		Button bwtGo = new Button("Transform");
		bwtGo.setPrefSize(100.0, 40.0);
//		Button okNew = new Button("Ok New");
//		okNew.setPrefSize(100.0, 40.0);
		TextField inputText = new TextField("");
		Separator line = new Separator();
		line.setPrefWidth(100000);
		Separator line2 = new Separator();
		line2.setPrefWidth(100000);
		Label input = new Label("Input:");
		Label output = new Label("Output:");
		Label decodeOfficial = new Label ("Original Decode Result:");
		Label decodeMine = new Label ("My Method's Decode Result:");
		Label comparing = new Label ("Comparison:");
		
		//placing items
		AnchorPane.setLeftAnchor(intro, 10.0);
		root.getChildren().add(intro);
		
		AnchorPane.setLeftAnchor(inputText, 10.0);
		AnchorPane.setTopAnchor(inputText, 25.0);
		inputText.setPrefWidth(270.0);
		root.getChildren().add(inputText);
		
		AnchorPane.setRightAnchor(bwtGo, 10.0);
		AnchorPane.setTopAnchor(bwtGo, 20.0);
		root.getChildren().add(bwtGo);
		
//		AnchorPane.setRightAnchor(okNew, 10.0);
//		AnchorPane.setTopAnchor(okNew, 80.0);
//		root.getChildren().add(okNew);
		
		AnchorPane.setTopAnchor(line, 120.0);
		root.getChildren().add(line);
		
		AnchorPane.setLeftAnchor(input, 20.0);
		AnchorPane.setTopAnchor(input, 80.0);
		root.getChildren().add(input);
		
		AnchorPane.setLeftAnchor(output, 20.0);
		AnchorPane.setTopAnchor(output, 100.0);
		root.getChildren().add(output);
		
		AnchorPane.setLeftAnchor(decodeOfficial, 20.0);
		AnchorPane.setTopAnchor(decodeOfficial, 120.0);
		root.getChildren().add(decodeOfficial);

		AnchorPane.setLeftAnchor(decodeMine, 20.0);
		AnchorPane.setTopAnchor(decodeMine, 160.0);
		root.getChildren().add(decodeMine);
		
		AnchorPane.setTopAnchor(line2, 200.0);
		root.getChildren().add(line2);
		
		AnchorPane.setLeftAnchor(comparing, 20.0);
		AnchorPane.setTopAnchor(comparing, 200.0);
		root.getChildren().add(comparing);
		
		//button instructions
		bwtGo.setOnAction(eventGo -> {
			bwtGo.setDisable(true);
			pos = null;
			eargs = null;
			dargs = null;
			dargs2 = null;
			decodeTimeO = 0;
			decodeTimeM = 0;
			totalSizeM = 0;
			totalSizeO = 0;
			
			String[] y1 = {inputText.getText()};
			String y = y1[0];
			
			BWT bwt = new BWT();
	  		pos = new int[y.length() + 1];
	  		eargs = bwt.encode(y+'|');
	  		System.out.println(eargs);
	  		System.out.println(printArray(pos));
			
			long start = System.nanoTime();
	  		String eargs2 = eargs;
	  		dargs = BWT.decode(eargs);
	  		long end = System.nanoTime();
			long duration = end - start;
	  		System.out.println("original decode: "+dargs + ", took this many steps: "+ decodeTimeO + ", in "+duration+" time");
	  		
	  		long start2 = System.nanoTime();
	  		dargs2 = BWT.decodeMe(eargs2);
	  		long end2 = System.nanoTime();
			long duration2 = end2 - start2;
	  		System.out.println("my decode: "+dargs2 + ", took this many steps: "+ decodeTimeM + ", in "+ duration2+" time");
	  		
	  		
	  		//bwt transform's input and output
			input.setText("Input: " + y +"|");
			output.setText("Output: " + eargs);
			
			//decoding results
			decodeOfficial.setText("Original Decode Result: "+dargs + " \n 			Steps: "+ decodeTimeO + "					 Time: "+duration );
			decodeMine.setText("My Method's Decode Result: "+dargs2 + " \n 			Steps: "+ decodeTimeM + "					 Time: "+ duration2);
			
			/**
			 * TRUE FOR MINE WORKING FASTER
			 * FALSE FOR ORIGINAL WORKING FASTER
			 */
			//creating vars for comparison
			boolean winnerS = false;
			boolean winnerT = false;
			int diffStep = 0;
			long diffTime = 0;
			String winnerNameT = "";
			String winnerNameS = "";

			//step competition
			if(decodeTimeO < decodeTimeM) {
				//original won
				winnerS = false;
				winnerNameS = "the Original Method ";
			}else {
				//mine won
				winnerS = true;
				winnerNameS = "the New Method ";

			}
			if(winnerS == false) {
				diffStep = decodeTimeM - decodeTimeO;
			}else {
				diffStep = decodeTimeO - decodeTimeM;
			}
			
			//time competition
			if(duration < duration2) {
				//original won
				winnerT = false;
				winnerNameT = "the Original Method ";
			}else {
				//mine won
				winnerT = true;
				winnerNameT = "the New Method ";
			}
			if(winnerT == false) {
				diffTime = (duration2 - duration);
			}else {
				diffTime = (duration - duration2);
			}
			
			
			//comparison of the two results	
			comparing.setText("Comparison Results: \n" + 
					diffStep + " step difference with " + winnerNameS + "being faster \n"+ 
					diffTime +" time difference with " + winnerNameT + "being faster \n" + 
					"\n"+
					"Estimated "+ totalSizeM + " Bytes of memory used by the original \n" +
					"Estimated "+ totalSizeO + " Bytes of memory used by my new method"
					
					
					);
		});	
		
//		okNew.setOnAction(event4 ->{
//			BWT bwt = new BWT();
//			primaryStage.close();
//			bwt.start(primaryStage);
//		});
		
		primaryStage.setTitle("BWT Method");
		primaryStage.setScene(new Scene(root, 800, 400));
		primaryStage.show();
  	}
}
