
public class LowestGoesFirst2 {
	static int BIGCOUNTER = 0;
	static int[] pos = new int[1];
	int posc = 0;
	
	public int[] sort(int[] y) {
		//initialise pos
		pos = new int[y.length];
		for(int x=0;x<pos.length;x++) {
			pos[x]=0;
		}
		
		
		//current starting position
		int c = 0;
		while(sorted(y) == false) {
			//find the lowest item
			int lowest = 10000000;
			int posx = 0;
			for(int x = c; x<y.length;x++) {
				BIGCOUNTER = BIGCOUNTER + 1;
				if(y[x] < lowest) {
					lowest = y[x];
					posx = x;
					
				}
			}
			BIGCOUNTER = BIGCOUNTER + 1;
			//bring lowest to the "front"
			int temp = y[posx];
			y[posx] = y[c];
			y[c] = temp;
			c = c+1;
			pos[posc] = posx+1;
			posc = posc + 1;
			System.out.println(printArray(y));
			System.out.println(printArray(pos));
		}
		return y;
	}
	
	public int[] unsort(int[] y) {
		pos = cleanPos(pos);
		for(int x = pos.length-1; x>=0;x--) {
			BIGCOUNTER = BIGCOUNTER + 1;
			int aim = pos[x] - 1;
			int swap = y[aim];
			y[aim] = y[x];
			y[x] = swap;
		}
		
		return y;
	}
	
	
	
	public boolean sorted(int[] y) {
		for(int i = 1; i<y.length;i++) {
			if(y[i-1]>y[i]) {
				return false;
			}
		}
		return true;
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
	
	public int[] returnPos() {
		return pos;
	}
	
	static void main(int[] args) {
		BIGCOUNTER = 0;
		LowestGoesFirst2 lgf = new LowestGoesFirst2();
		
		int[] y= args;
		pos = new int[y.length*y.length];
		for(int x=0;x<pos.length;x++) {
			pos[x]=0;
		}
		// = 
			//args.clone();
		lgf.sort(y);
		System.out.println(printArray(y));
		pos = lgf.cleanPos(pos).clone();
		System.out.println(printArray(pos));
		y = lgf.unsort(y);
		System.out.println(printArray(y));
 	}

	public int howManySteps(int[] a) {
		  main(a);
		  return BIGCOUNTER;
	  }

	
}
