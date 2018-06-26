
public class CallingCard extends Card{

	private String cardNumber;
	private String pin; 
	
	public CallingCard() {
		
		super();
		cardNumber = "";
		pin = "";
		
	}
	
	public CallingCard (String name, String number, String pinNumber){
		
		super(name);
		setCardNumber(number);
		setPin(pinNumber);
		
	}
	
	public String format(){
		
		return super.format() + " Card Numer: " + cardNumber + " Pin: " + pin;
		
	}
	
	public String toString(){
		
		return "CallingCard[name=" + this.getName() + "] [number=" + this.getCardNumber() + ",pin=" + this.getPin() + "]";
		
	}
	
	public boolean equals(Object obj){
		
		CallingCard check;
		
		if(obj instanceof CallingCard){
			
			check = (CallingCard)obj;
			
			if(check.getName() == this.getName() && check.getCardNumber() == this.getCardNumber()
					&& check.getPin() == this.getPin())
				return true;
			
				
		}
		
		return false; 
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
