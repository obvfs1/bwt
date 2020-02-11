import java.util.Random;

public class BogoSort {
	   static int pos = 0;
	   static String total = "";
	   static int BIGCOUNTER = 0;
	   
	   
	   public int[] sort(int[] y) {
		   total = "";
		   while(checkSorted(y)==false) {
			   for(int z = 0; z < y.length; z++) {
					//shuffle here
					Random rand = new Random();
					int place = 0;

					for(int m = 0; m<y.length;m++) {
						if(checkSorted(y)==false){
							   //System.out.println(printArray(y));
							total = total + printArray(y);
							
							BIGCOUNTER = BIGCOUNTER+1;
							pos = pos+1;

							place = y[m];
							int place2 = rand.nextInt(y.length);
							while (place2 == place) {
								place2 = rand.nextInt(y.length);
							}
							y[m] = y[place2];
							y[place2] = place; 
						}else {
								m = y.length;
						}
					}	
				}
			}
			//printArray(y);
			return y;	
		}
			
		
		
	public Boolean checkSorted(int y[]) {
		for(int i = 1; i<y.length;i++) {
			if(y[i-1]>y[i]) {
				return false;
			}
		}
		return true;
	}
	
	public int[] unsort(int y[], int yClone[]) {
		System.out.println();
		total = "";
		while(checkUnsorted(y, yClone) == false) {
			for(int z = 0; z < y.length; z++) {
				//shuffle here
				Random rand = new Random();
				int place = 0;
				for(int m = 0; m<y.length;m++) {
					if(checkUnsorted(y, yClone)==false){
						System.out.println(printArray(y));
						total = total + printArray(y);

						place = y[m];
						int place2 = rand.nextInt(y.length);
						while (place2 == place) {
							place2 = rand.nextInt(y.length);
							BIGCOUNTER = BIGCOUNTER+1;
						}
						y[m] = y[place2];
						y[place2] = place; 
					}else {
						m =  y.length;
					}
				}	
			}
		}	
		return y;
	}
	
	
	
	public Boolean checkUnsorted(int y[], int yClone[]) {
		for(int i = 1; i<y.length;i++) {
			if(yClone[i]!=y[i]) {
				return false;
			}
		}
		return true;
	}
	
	public int howManySteps(int[] a) {
		
		main(a);
		return BIGCOUNTER;
		
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
		
		
	
	
	
	   public String returnPos() {
		   return Integer.toString(pos);
	   }
	   
	   public static void main(int[] args){
		  BIGCOUNTER = 0;
		   //System.out.println("Start sorting and unsorting");
		
		   int y[] = args;
		   int yClone[] = y.clone();
				  
		   BogoSort re = new BogoSort();

		
		   //Printing information to do with lists
//		   System.out.println("This is the inputted list");
//		   printArray(y);
		   //System.out.println();
		
		   
//		   System.out.println();
//		   System.out.println("This is the sorted inputted list");
		   re.sort(y);
//		   System.out.println("This is the number of shuffles it took to complete");
//		   System.out.println(pos);
//		   System.out.println();

		
//		   System.out.println();
//		   System.out.println("This is the original unsorted inputted list");
		   re.unsort(y, yClone);
//		   printArray(y);
		   pos = 0;
	   }
}
