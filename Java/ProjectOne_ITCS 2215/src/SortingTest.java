/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	
 * 
 * 
 */
public class SortingTest {
	
	public static void  main(String[] arrgs){
		
		RandomGenerator numberGenerator = new RandomGenerator();
		checkArray(numberGenerator.getArray());
		
		InsertionSort insertion = new InsertionSort(numberGenerator.getFileName());
		int[] insertArrayCheck = insertion.getArray();
		checkArray(insertArrayCheck);
		
		BubbleSort bubble = new BubbleSort(numberGenerator.getFileName());
		int[] bubbleArrayCheck = bubble.getArray();
		checkArray(bubbleArrayCheck);

		MergeSort merge = new MergeSort(numberGenerator.getFileName());
		int [] mergeSortCheck = merge.getArray();
		checkArray(mergeSortCheck);
		
	}

	public static void checkArray(int[] array){
		
		for(int i = 1; i < array.length; i++){
			
			if(array[i-1] > array[i]){
				System.out.println("The array is not correctly sorted.\n");
				return;
			}
		}

		System.out.println("The array is sorted correctly.\n");
	}

}
