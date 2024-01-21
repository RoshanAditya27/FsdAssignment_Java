package presentation;

import java.util.List;
import java.util.Scanner;

import dao.DeptDaoImp;
import dao.IDeptDao;
import entity.Department;

public class Client {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		IDeptDao dao = new DeptDaoImp();
		
		boolean flag = true;
		
		
		
		while(flag) {
		System.out.println("****WELCOME DMS ***");
		System.out.println("1. INSERT");
		System.out.println("2. UPDATE");
		System.out.println("3. DELETE");
		System.out.println("4. SELECT BY ID");
		System.out.println("5. SELECT ALL");
		System.out.println("6. EXIT");
		
		
		int choice =	scanner.nextInt();
		
		
		
			switch (choice) {
			case 1:
				
				Department dept =	readData();
				
				int count =	dao.insert(dept);
				
				System.out.println(count +" record inserted successfully");
				
				break;
				
			case 2:
			    // Update
			    Department updatedDept = readData(); // Read updated data
			    int updateCount = dao.update(updatedDept); // Call update method

			    System.out.println(updateCount + " record updated successfully");
			    break;

				
			case 3:
			    System.out.println("Enter DNO to delete:");
			    int deleteDno = scanner.nextInt();

			    int deleteCount = dao.deleteOne(deleteDno);

			    if (deleteCount > 0) {
			        System.out.println(deleteCount + " record deleted successfully");
			    } else {
			        System.out.println("No record found with the specified DNO.");
			    }
			    break;

				 
				
			case 4:
			    System.out.println("Enter DNO to select:");
			    int selectDno = scanner.nextInt();

			    Department selectedDept = dao.selectOne(selectDno);

			    if (selectedDept != null) {
			        System.out.println("Selected Department Details:\n" + selectedDept);
			    } else {
			        System.out.println("No record found with the specified DNO.");
			    }
			    break;

			    
			case 5:
				
			List<Department> list =	  dao.selectAll();
			
			list.stream().forEach(System.out::println);
				
				break;
				
			case 6:
				
				  flag = false;
				  System.out.println("Thank You! User successfully exited");
				
				break;

			default:
				break;
			}
		
		
		
		
		
		
		}
	}
	private static Department readData() {
		System.out.println("Enter DNO");
		
		int dno =scanner.nextInt();
		
			scanner.nextLine();
		
		System.out.println("Enter DNAME");
		
		String dname = scanner.nextLine();
		
		System.out.println("Enter LOCATION");
		
		String location = scanner.nextLine();
		
		
		Department dept = new Department(dno,dname,location);
		
		return dept;
	}
}
