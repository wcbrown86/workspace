
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListRunner {

	public static void main(String[] args){
		
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		list.add("eee");
		list.add("fff");
		list.add("ggg");
		list.add("hhh");
		list.add("iii");
		
		ListIterator<String> listIterator = list.listIterator();
		
		while(listIterator.hasNext()){
			System.out.print(listIterator.next() + " ");
		}
		
		System.out.println("");
		
		while(listIterator.hasPrevious()){
			
			String temp = listIterator.previous();
			
			if(temp.equals("aaa") || temp.equals("eee") || temp.equals("iii") 
					|| temp.equals("ooo") || temp.equals("uuu"))
				listIterator.remove();
			
		}
		
		while(listIterator.hasNext()){
			System.out.print(listIterator.next() + " ");
		}
	}
}
