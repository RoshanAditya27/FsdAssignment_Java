package abstractionAndInterface;

import java.util.Scanner;

public class AtmUI {
	public static void main(String[] args) {
		IBank bank =	new BankImp2();

		System.out.println("*****WELCOME TO ATM**********");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter 1: Deposit");
		System.out.println("Enter 2: Withdraw");
		System.out.println("Enter 3: Exit");

		int choice = scanner.nextInt();
		
		switch(choice)
		{
		case 1:
			bank.deposit();
			break;
		case 2:
			bank.withdraw();
			break;
		case 3:
			System.out.println("Thanks for Visting again");
			break;
		default:
			break;
		
		
		}
		}
	}
}
