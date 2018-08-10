
import java.util.HashMap;
import java.util.Map;

public class Code {

	//ArrayList<String> code = new ArrayList<String>();
	Map<String, String> codeMap = new HashMap<String, String>();
	
	public String translate(String str){
		
		str = str.toUpperCase();
		char temp[] = new char[str.length()];
		temp = str.toCharArray();
		String translated = "";
		
		for(int i = 0; i < temp.length; i++){
			
			if(temp[i] == ' ')
				translated += "   ";
			else if(codeMap.containsKey(String.valueOf(temp[i])))
				translated += codeMap.get(String.valueOf(temp[i]));
			
		}
		
		return translated;
	}
	
	public void add(String key, String value){
		
		codeMap.put(key, value);
		
	}
	
	public void set(String key, String value){
		
		codeMap.put(key, value);
		
	}
	
	public String get(String key){
		
		return codeMap.get(key);
	}

}
