
public class Customer {
	
	Customer next;
	int serviceTime = 5;

	public void setNext(Customer c) {
		// TODO Auto-generated method stub
		next = c;
	}

	public Customer getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	public int getServiceTime() {
		// TODO Auto-generated method stub
		return serviceTime;
	}

	public void decServiceTime() {
		// TODO Auto-generated method stub
		serviceTime--;
	}

}
