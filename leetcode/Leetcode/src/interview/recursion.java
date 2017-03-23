package interview;
public class recursion {
	public static void main(String args[]){  
	      System.out.println(fab(3));  
	   }  
	     
	   private static int fab(int index){  
	      if(index==1 || index==2){  
	         return 1;  
	      }else{  
	         return fab(index-1)+fab(index-2);  
	      }  
	   } 
}
