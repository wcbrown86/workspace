import java.util.ArrayList;

public class Code {

	ArrayList<String> code = new ArrayList<String>();
	
	public Code() {
		
	}
	
	public String translate(String str){
		
		str = str.toUpperCase();
		char temp[] = new char[str.length()];
		temp = str.toCharArray();
		String translated = "";
		
		for(int i = 0; i < temp.length; i++){
			
			if(temp[i] == ' ')
				translated += "   ";
			else 
				for(int j = 0; j < code.size(); j++){
					
					if(temp[i] == code.get(j).charAt(0)){
						String str2 = code.get(j);
						translated += str2.substring(1, str2.length());
					}
				}
			
		}
		
		return translated;
	}
	
	public void add(String str){
		
		code.add(str);
		
	}
	
	public void set(String str, int index){
		
		code.add(index, str);
		
	}
	
	public String get(int index){
		
		return code.get(index);
	}

}
