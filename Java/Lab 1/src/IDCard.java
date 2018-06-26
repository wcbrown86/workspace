
public class IDCard extends Card{
	
	private String idNumber;

	public IDCard() {
		
		super();
		idNumber = "";

	}
	
	public IDCard(String name, String id){
		
		super(name);
		setIdNumber(id);
		
	}
	
	public String format(){
		
		return super.format() + " ID: " + idNumber;
		
	}
	
	public String toString(){
		
		return "IDCard[name=" + this.getName() + "] [number=" + this.getIdNumber() + "]";
		
	}
	
	public boolean equals(Object obj){
		
		IDCard check;
		
		if(obj instanceof IDCard){
			
			check = (IDCard)obj;
			
			if(check.getName() == this.getName() && check.getIdNumber() == this.getIdNumber())
				return true;
		}
		
		return false;
		
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}
