package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class atmOperationImplementation implements atmOperationInterface {
	ATM atm=new ATM();
	
	Map<Double,String> ministm=new HashMap<>();
	
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String date = LocalDateTime.now().format(myFormatObj);
	
	@Override
	public void viewBalance() {
		System.out.println("Available Balance is : "+atm.getBalance());
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		if(withdrawAmount%100==0 || withdrawAmount%200==0 || withdrawAmount%500==0) {
			if(withdrawAmount<=atm.getBalance()) {
				ministm.put(withdrawAmount," Amount Withdrawn at "+date);
				System.out.println(withdrawAmount+" Collect the Cash");
				atm.setBalance(atm.getBalance()-withdrawAmount);
				viewBalance();
			}
			else {
				System.out.println("Insufficient Balance !!");
			}
		}
		else {
			System.out.println("Please enter the withdrawAmount in multiples of 100 (or) 200 (or) 500 ");
		}
		
	}

	@Override
	public void depositeAmount(double depositeAmount) {
		ministm.put(depositeAmount," Amount Deposited at "+date);
		System.out.println(depositeAmount+" Deposited Successfully !!");
		atm.setBalance(atm.getBalance()+depositeAmount);
		viewBalance();
	}

	@Override
	public void viewMiniStatement() {
		for(Map.Entry<Double, String> i:ministm.entrySet()) {
			System.out.println(i.getKey()+" "+i.getValue());
		}
		
	}

}
