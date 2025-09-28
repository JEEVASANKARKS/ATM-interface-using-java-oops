package atm;

import java.util.*;

public class MainClass {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		atmOperationInterface op=new atmOperationImplementation();
		int atmnumber=12345;
		int atmpin=123;
		System.out.println("Welcome to ATM Machine !!!");
		//Getting input from user
		System.out.println("Enter ATM Number : ");
		int useratmnumber=sc.nextInt();
		System.out.println("Enter ATM Pin : ");
		int useratmpin=sc.nextInt();
		
		//checking the user
		if(useratmnumber==atmnumber && useratmpin==atmpin) {
			while(true) {
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("1.View Available Balance \n 2.Withdraw Amount \n 3.Deposit Amount \n 4.View Ministatement \n 5.Exit from ATM");
				
				System.out.println("Enter Choice");
				int choice=sc.nextInt();
				if(choice==1) {
					op.viewBalance();
				}
				else if(choice==2) {
					System.out.println("Enter amount to withdraw : ");
					double withdrawAmount=sc.nextDouble();
					op.withdrawAmount(withdrawAmount);
				}
				else if(choice==3) {
					System.out.println("Enter Amount to deposite :");
					double depositAmount=sc.nextDouble();
					op.depositeAmount(depositAmount);
				}
				else if(choice==4) {
					op.viewMiniStatement();
				}
				else if(choice==5) {
					System.out.println("Collect your Card \n Thank you for using our ATM Machine");
					System.exit(0);
				}
				else {
					System.out.println("Please Enter the correct choice ");
				}
				
				
				
			}
		}
		else {
			System.out.println("Incorrect Atm Number or pin");
			System.exit(0);
		}
		

	}

}
