public class Reverse {
	
	public static int pos1[] = {};
	public static int pos2[] = {};
	public int x1 = 0;
	public int x2 = 0;
	public boolean doneSort = false;
	public boolean doneunSort = false;

	public int[] posSingle1 = {};
	public int[] posSingle2 = {};

	static int BIGCOUNTER = 0;
	
	public int[] generatePos(int[] y) {
		int[] position = new int[y.length];
		for (int m = 0; m < position.length;m++) {
			position[m]=m+1;
		}
		return position;
	}
	
	public int[] generateSortedPos(int[] y) {
		int[] position = new int[y.length];
		for(int m = 0; m<position.length;m++) {
			position[m]=m+1;
		}
		
		Reverse r = new Reverse();
		r.sort(y, r.generatePos(y));
		position = r.getPos();
		
		return position;
	}
	
	public int[] sort(int[] y, int[] pos) {
		
		
		
		for(int x = 0; x < y.length; x++) {
			int current = y[x];
			int currentPos = pos[x];
			int befCurrent = x-1;
			

				  while (befCurrent>=0 && y[befCurrent] > current){ 
		                y[befCurrent+1] = y[befCurrent]; 
		                pos[befCurrent+1] = pos[befCurrent];
		                befCurrent = befCurrent-1; 
		                BIGCOUNTER = BIGCOUNTER +1;
		            } 
		          y[befCurrent+1] = current;
		          pos[befCurrent+1] = currentPos;
		          System.out.println(y[befCurrent+1]);
		          
		}
		pos1 = pos;
	return y;
	}
	
	public int[] unsort(int[] y, int[] pos) {
		System.out.println();
		for(int x = 0; x < pos.length; x++) {
			int current = pos[x];
			int currentPos = y[x];
			int befCurrent = x-1;
			

				  while (befCurrent>=0 && pos[befCurrent] > current){ 
		                pos[befCurrent+1] = pos[befCurrent]; 
		                y[befCurrent+1] = y[befCurrent];
		                befCurrent = befCurrent-1; 
		                BIGCOUNTER = BIGCOUNTER +1;
		            } 
		          pos[befCurrent+1] = current;
		          y[befCurrent+1] = currentPos;
		          System.out.println(pos[befCurrent+1]);
		          
		}
		pos2 = pos;
		return y;
	}
	
	public int[] sortSingle(int[] y, int[] pos) {
		if(x1 < y.length) {
			
			if(doneSort==false) {
				x1 = 0;
				doneSort = true;
				posSingle1 = pos.clone();
			}
			int current = y[x1];
			int currentPos = posSingle1[x1];
			int befCurrent = x1-1;
			if (befCurrent>=0 && y[befCurrent] > current){ 
				y[befCurrent+1] = y[befCurrent]; 
		        posSingle1[befCurrent+1] = posSingle1[befCurrent];
		        befCurrent = befCurrent-1;     
			} 
			y[befCurrent+1] = current;
			posSingle1[befCurrent+1] = currentPos;
		    x1 = x1+1;
		}
		if(x1 == y.length) {
			x1 = 0;
		}
		
		return y;	
	}
	
	
	
	public int[] unsortSingle(int[] y, int[] pos) {
		if(doneunSort==false) {
			x2 = 0;
			posSingle2 = pos.clone();
			doneunSort = true;
		}
		
		if(x2 < posSingle2.length) {
			int current = posSingle2[x2];
			int currentPos = y[x2];
			int befCurrent = x2-1;
			if (befCurrent>=0 && posSingle2[befCurrent] > current){ 
				posSingle2[befCurrent+1] = posSingle2[befCurrent]; 
		        y[befCurrent+1] = y[befCurrent];
		        befCurrent = befCurrent-1;     
			} 
			posSingle2[befCurrent+1] = current;
			y[befCurrent+1] = currentPos;
		    x2 = x2+1;
		}
		if(x2 == posSingle2.length) {
			x2 = 0;
		}
		
		return y;	
	}

	public int howManySteps(int[] a) {
		
		main(a);
		return BIGCOUNTER;
		
	}

	public int[] getPos() {
		return pos1;
	}

	public int[] getPos2() {
		return pos2;
	}
	
	public int[] getPosSingle1() {
		return posSingle1;
	}
	
	public int[] getPosSingle2() {
		return posSingle2;
	}

	public int[] getUnsortedPos(int[] y, int[] pos) {
		for(int x = 0; x < y.length; x++) {
			int current = y[x];
			int currentPos = pos[x];
			int befCurrent = x-1;
			

				  while (befCurrent>=0 && y[befCurrent] > current){ 
		                y[befCurrent+1] = y[befCurrent]; 
		                pos[befCurrent+1] = pos[befCurrent];
		                befCurrent = befCurrent-1; 
		            } 
		          y[befCurrent+1] = current;
		          pos[befCurrent+1] = currentPos;
		          System.out.println(y[befCurrent+1]);
		          
		}
		
		return pos;
	}
public static String printArray(int x[]){ 
	  int n = x.length; 
      String temp = "[";
//      System.out.print("[");
      for (int i=0; i<n; ++i) {
      	if(i==n) {
//      		System.out.print(x[i]+",");
      		temp = temp+ x[i];
      	} else {
//      		System.out.print(x[i]+",");
      		temp = temp+ x[i]+",";
      	}
      }
      String temp2 = temp.substring(0, temp.length()-1);
//      System.out.print("]");
      temp2 = temp2 + "]";
//      System.out.println(); 
       return temp2;
 } 
	   
	   
	public static void main(int[] a){
		
		BIGCOUNTER = 0;
		System.out.println("Start sorting and unsorting");
		
		int y[] = a.clone();
		int pos[] = {};
		Reverse re = new Reverse();
		
		
		pos = y.clone();

		for (int m = 0; m < pos.length;m++) {
			pos[m]=m+1;
		}
		printArray(y);
		printArray(pos);
		System.out.println();
		
		
		
		re.sort(y, pos);
		System.out.println();
		printArray(y);
		printArray(pos);
		
		re.unsort(y, pos);
		System.out.println();
		printArray(y);
		printArray(pos);
		
		}
		
	}
	

