
public class MergeSort {
	Boolean done = false;
	static int[] pos = {};
	static int[] sortedPos = {};
	static int[] mem = {};
	static int BIGCOUNTER = 0;
	
	
	public void merge(int[] y, int x, int[] yPos, int xPos) {
//		//check to see if we've done the first split
//		if(done == false) {
//			//make a copy of the original list
//			mem = y.clone();
//			//create a list that we will use to remember their positions
//			memN = new int[mem.length];
//			for(int n = 0;n<mem.length;n++) {
//				memN[n] = n;
//			}
//			done = true;
//		}
		
		/**
		 * IN ORDER TO REMEMBER HOW TO UNDO IT, WE USE "*InsertVariableNameHere*Pos" EQUIVALENTS
		 * AND REPLICATE THE SAME MOVEMENTS TO THOSE RESPECTIVE VARIABLES
		 * 
		 * ALSO NOTE ALL Pos RELATED CODE IS INDENTED AN EXTRA TIME TO SHOW THE DIFFERENCE 
		 */
		
	    //if the length is 2 or less then there is no point in continuing so return
		if(x<2){
	    	return;
	    }
		//split a into two sides
	    int m = x/2;
	    int[] l = new int[m];
	    int[] r = new int[x - m];
	    	int mPos = xPos/2;
	    	int[] lPos = new int[mPos];
	    	int[] rPos = new int[xPos - mPos];
		System.out.println(printArray(y));
	    for (int i = 0; i < m; i++) {
	        l[i] = y[i];
	    	BIGCOUNTER = BIGCOUNTER + 1;
	    }
	    for (int i = m; i < x; i++) {
	        r[i - m] = y[i];
	    	BIGCOUNTER = BIGCOUNTER + 1;
	    }
	    	for (int iPos = 0; iPos < mPos; iPos++) {
	    		lPos[iPos] = yPos[iPos];
	    	}
	    	for (int iPos = mPos; iPos < xPos; iPos++) {
	    		rPos[iPos - mPos] = yPos[iPos];
	    	}
	    
	    merge(l, m, lPos, mPos);
	    merge(r, x-m, rPos, xPos-mPos);
	 
	    mergeLists(y, l, r, m, x-m, yPos, lPos, rPos, mPos, xPos-mPos);
	}
	
	public void mergeLists(int[] y, int[] l, int[] r, int left, int right, int[] yPos, int[] lPos, int[] rPos, int leftPos, int rightPos){
		//initialise variables
	    int q = 0;
	    int p = 0;
	    int o = 0;
	    	int qPos = 0;
	    	int pPos = 0;
	    	int oPos = 0;
	    
	    //while the inside counters havent reached the max value for each side
	    while (q < left && p < right) {
	    	BIGCOUNTER = BIGCOUNTER + 1;
	    	//repopulate the list by comparing the l and r lists
	    	if (l[q] <= r[p]) {
	    		//increase values of o p q to move along the list 
	    		y[o++] = l[q++];
	    			yPos[oPos++] = lPos[qPos++];
	    	} else {
	    		//increase values of o p q to move along the list 
			    y[o++] = r[p++]; 
			    	yPos[oPos++] = rPos[pPos++];
	    	}
	    }
	    
	    //repopulate the y list with the left elements
		while (q < left) {
	    	BIGCOUNTER = BIGCOUNTER + 1;
			y[o++] = l[q++];
				yPos[oPos++] = lPos[qPos++];
		}
		//repopulate the y list with the right elements
		while (p < right) {
	    	BIGCOUNTER = BIGCOUNTER + 1;
			y[o++] = r[p++];
				yPos[oPos++] = rPos[pPos++];						
	    }
	}
	
	
	public Boolean checkSorted(int y[]) {
		for(int i = 1; i<y.length;i++) {
			if(y[i-1]>y[i]) {
				return false;
			}
		}
		return true;
	}
	
	  public static String printArray(int x[]){ 
		  int n = x.length; 
	        String temp = "[";
	        for (int i=0; i<n; ++i) {
	        	if(i==n) {
	        		temp = temp+ x[i];
	        	} else {
	        		temp = temp+ x[i]+",";
	        	}
	        }
	        String temp2 = temp.substring(0, temp.length()-1);
	        temp2 = temp2 + "]";
	         return temp2;
	   }
	  
	  public int[] getPos() {
		  System.out.println("here is pos" + printArray(pos));
		  return pos;
	  }
	  
	  public int howManySteps(int[] a) {
		  main(a);
		  return BIGCOUNTER;
	  }
	  
	   public static int[] main(int[] args) {
		   BIGCOUNTER = 0;
		   
			if(args.equals(pos)) {
			   	System.out.println(printArray(mem));
			   	
				MergeSort ms = new MergeSort();
				ms.merge(args, args.length, mem, mem.length);
				
			   	System.out.println(printArray(mem));

				sortedPos = pos.clone();
				return mem;
			}else {
		    
		   	int[] result = args.clone();
		   	mem = args.clone();
			pos = new int[result.length];
			
			for(int x=0;x<pos.length;x++) {
				pos[x]=x+1;
			}
		   
		   
			MergeSort ms = new MergeSort();
			ms.merge(result, result.length, pos, pos.length);
			
			sortedPos = pos.clone();
			return result;
			}
		}
	   
	   public static int[] unsort(int[] args) {
		   BIGCOUNTER = 0;
		   
			if(args.equals(pos)) {
			   //	System.out.println(printArray(mem));
			   	
				MergeSort ms = new MergeSort();
				ms.merge(mem, mem.length, args, args.length);
				
			  // 	System.out.println(printArray(mem));

				
				return args;
			}else {
		    
		   	int[] result = args.clone();
		   	mem = args.clone();
			pos = new int[result.length];
			
			for(int x=0;x<pos.length;x++) {
				pos[x]=x+1;
			}
		   
		   
			MergeSort ms = new MergeSort();
			ms.merge(pos, pos.length,args, args.length);
			
			
			return args;
			}
		   
		   
	   }
	   
}

//ms.merge(pos, pos.length, result, result.length);
//System.out.println("hgdcgjfx "+printArray(result));
