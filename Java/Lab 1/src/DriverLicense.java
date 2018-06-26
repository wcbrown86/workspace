import java.util.Calendar;

public class DriverLicense extends Card{

	private String expirationYear;
	
	public DriverLicense() {
		
		super();
		expirationYear = "";
	}
	
	public DriverLicense(String name, String year){
		
		super(name);
		expirationYear = year;
		
	}
	
	public String format(){
		
		return super.format() + " Expiration Year: " + expirationYear;
		
	}
	
	public String toString(){
		
		return "DriverLicense[name=" + super.getName() + "] [Expiration Year=" + expirationYear + "]";
		
	}
	
	public boolean isExpired(){
		
		return Calendar.YEAR > Integer.parseInt(expirationYear);
		
	}
	
	
	public boolean equals(Object obj){
		DriverLicense check;
		
		if (obj instanceof DriverLicense){
			
			check = (DriverLicense)obj;
			if(check.getName() == this.getName() && check.getExpirationYear() == this.getExpirationYear())
				return true;
		}
		
		return false;
		
	}

	public String getExpirationYear() {
		
		return expirationYear;
		
	}

	public void setExpirationYear(String year) {
		
		expirationYear = year;
		
	}

}
