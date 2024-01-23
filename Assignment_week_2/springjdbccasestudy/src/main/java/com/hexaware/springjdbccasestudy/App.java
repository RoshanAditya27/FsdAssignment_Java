package com.hexaware.springjdbccasestudy;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.springjdbccasestudy.config.AppConfig;
import com.hexaware.springjdbccasestudy.exceptions.BusOperatorNotFoundException;
import com.hexaware.springjdbccasestudy.model.BusOperator;
import com.hexaware.springjdbccasestudy.service.BusOperatorServiceImp;
import com.hexaware.springjdbccasestudy.service.IBusOperatorService;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args ) throws BusOperatorNotFoundException
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        IBusOperatorService service = context.getBean(BusOperatorServiceImp.class);
        
        boolean flag = true;
        while(flag) {
        	System.out.println("Bus Operator services: ");
        	System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SELECT BY ID");
			System.out.println("5. SELECT ALL");
			System.out.println("6. EXIT");
			
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:

				BusOperator product = readData();

				boolean isInserted = service.createBusOp(product);

				if (isInserted) {
					System.out.println("Record inserted successfully...");
				} else {

					System.err.println("Insert fail");
				}

				break;

			case 2:

				BusOperator updatedProduct = updateData();

				boolean isUpdated = service.updateBusOp(updatedProduct);

				if (isUpdated) {
					System.out.println("Record Updated successfully...");
				} else {

					throw new BusOperatorNotFoundException();
				}

				break;

			case 3:

				System.out.println("Enter username: ");

				String username = scanner.next();

				boolean isDeleted = service.deleteBusOpByUsername(username);

				if (isDeleted) {
					System.out.println("Record Deleted successfully...");
				} else {

					throw new BusOperatorNotFoundException();
				}

				break;
				
				
			case 4:

				System.out.println("Enter name you want to find: ");

				String name = scanner.next();

				BusOperator operatorFound = service.selectBusOperatorByName(name);

				if (operatorFound != null) {
					System.out.println(operatorFound);
				} else {

					throw new BusOperatorNotFoundException();
				}

				break;
				
			case 5:
				
				List<BusOperator> list = service.selectAllBusOperators();
					
				for (BusOperator busOp : list) {
							
					System.out.println(busOp);
							
				}
				
				break;
				

			case 6:

				flag = false;
				System.out.println("That's all bye");
				break;

			default:
				break;
			}
        }
    }
	public static BusOperator updateData() {
		BusOperator busOperator = new BusOperator();
		
		System.out.println("Enter username: ");
		String username = scanner.next();
		busOperator.setOperatorUserName(username);
		
		return busOperator;
	}
	public static BusOperator readData() {
		BusOperator busOperator = new BusOperator();
		
		System.out.println("Enter username: ");
		String username = scanner.next();
		busOperator.setOperatorUserName(username);
		
		System.out.println("Enter password: ");
		String password = scanner.next();
		busOperator.setOperatorPassword(password);
		
		System.out.println("Enter your name: ");
		String name = scanner.next();
		busOperator.setName(name);
		
		System.out.println("Enter your email id: ");
		String email = scanner.next();
		busOperator.setEmail(email);
		
		System.out.println("Enter your phone number: ");
		String phoneNumber = scanner.next();
		busOperator.setPhoneNumber(phoneNumber);
		
		
		return busOperator;
	}
}
