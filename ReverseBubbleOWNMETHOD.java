import java.util.Random;

//Using a position list in order to 'save' which are switched.
public class ReverseBubbleOWNMETHOD {
	public static int[] pos = {};
	static int BIGCOUNTER = 0;
	
	public int[] sort(int[] y, int[] pos) {
		//creating two integers in order to 
		int c = 0;
		int counter = 0;
		//going through the list in its entirety
		for (int n=0;n<y.length;n++){
			//going through each item
			for(int m = 1; m<y.length;m++){
				//checks if the two elements need to be swapped
				if(y[m-1]>y[m]){
					//saves 'instruction' for the reversal of the list
					pos[counter] = (m);
					//number of times the list has to be gone through
					counter = counter + 1;
					//swapping the two elements
					c=y[m-1];
					y[m-1]=y[m];
					y[m]=c;
					BIGCOUNTER = BIGCOUNTER+1;
				}
			}
		}
		
		return y;
	}
	
public int[] unsort(int[] y, int[] pos) {
		System.out.println();
		//going through the instruction list pos in reverse order in order to reverse
		for(int n = pos.length;n>0;n--) {
			//var c for swapping items
			//var m for temp storing the pos items one by one
			int c = 0;
			int m = pos[n-1];
			//checks if the instruction is 0, i.e. null
			if(m == 0) {
				//skip this location
			}else {
				//swaps with 
				c = y[m-1];
				y[m-1] = y[m];
				y[m] = c;
				BIGCOUNTER = BIGCOUNTER+1;
			}
		}
		return y;
}
	

	public int[] cleanPos(int[] position) {
//		for(int x = 0; x<pos.length;x++) {
//			if(pos[x] == 0) {
//				break;
//				//System.out.println("here");
//			}else {
//				position[x] = pos[x];
//			}
//		}
	//	pos = position.clone();
		int m = 0;
		for(int o = 0; o<position.length;o++) {
			if(position[o] == 0) {
				
			} else {
				m=m+1;
			}
		}
		
		int[] temp = new int[(m)];
		for(int x = 0; x<m+1;x++) {
			if(position[x] != 0) {
				temp[x] = position[x];
			}
			
		}
		return temp;
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
	  
	public int howManySteps(String a) {
		
		main(a);
		return BIGCOUNTER;
		
	}
	  
	  
	   
	public int[] savePos() {
		return pos;
	}
	   
	   
	public static int[] main(String y2){
		System.out.println("Start sorting and unsorting");
		
		BIGCOUNTER = 0;
		
		
//		//creating a random list
//		//creating size of list
//		Random rand = new Random();
//		int size = rand.nextInt(10);
//		int y[] = new int[size];
//		//filling list with random numbers
//		for(int filling = 0; filling <y.length;filling++) {
//			int fill = rand.nextInt(25);
//			y[filling] = fill;
//		}
		y2 = y2.substring(1, y2.length()-1);
		String y3[] = y2.split(",");
		int y[] = new int[y3.length];
		for(int x = 0;x<y3.length;x++) {
				int temp = Integer.parseInt(y3[x]);
				y[x] = temp;
		}
		pos = new int[(y.length * y.length)];
		ReverseBubbleOWNMETHOD re = new ReverseBubbleOWNMETHOD();
		
		
		

		for (int m = 0; m < pos.length;m++) {
			pos[m]=0;
		}
		
		//Printing information to do with lists
//		System.out.println("This is the inputted list");
//		printArray(y);
//		System.out.println("This is the position list");
//		printArray(pos);
//		System.out.println();
		
		
		
		re.sort(y, pos);
//		System.out.println();
//		System.out.println("This is the sorted inputted list");
//		printArray(y);
//		System.out.println("This is the saved position list");
//		printArray(pos);
		
		int[] ans = y.clone();
		re.unsort(y, pos);
//		System.out.println();
//		System.out.println("This is the original unsorted inputted list");
//		printArray(y);
//		System.out.println("This is the saved position list");
//		printArray(pos);
		return ans;
		
		}
}
