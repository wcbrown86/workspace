import java.util.Random;
public class Sort {
	public static void main(String[] args){
		Random r = new Random();
		int[] num = new int[1000000]; 
	
		for(int i = 0; i < num.length; i++){
			num[i] = r.nextInt(100) + 1;
		}
		
		for(int i =0; i < num.length; i++){
			int temp = 0; 
			int min = i; 
			for(int j = i + 1; j< num.length; j++){
				
				if(num[min] > num[j]){
					min = j;
				}
				
			}
			
			temp = num[min];
			num[min] = num[i];
			num[i] = temp;
			
			
		}
		
		for(int i = 0; i < num.length; i++){
			System.out.print(num[i] + ", ");
		}
		
	}

}
