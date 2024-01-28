package questiontwo;

import java.util.Scanner;

public class TestEmployee {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Employee ID:");
		int id=scanner.nextInt();
		System.out.println("Enter Employee Lastname:");
		String lname=scanner.next();
		System.out.println("Enter Employee Firstname:");
		String fname=scanner.next();
		System.out.println("Enter Employee Monthly Salary:");
		int salary =scanner.nextInt();
		Employee emp=new Employee(id, lname, fname, salary);
		System.out.println("==============================");
		System.out.println("Employee Info:");
		System.out.println(emp.toString());
		System.out.println("==============================");
		System.out.println("The annualy salary="+emp.getAnnualSalary(salary));
		System.out.println("==============================");
		System.out.println("The raising salary by 2="+emp.raiseSalary(salary));
		
		
		
		

	}

}
