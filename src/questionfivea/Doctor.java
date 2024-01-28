package questionfivea;

import java.util.Scanner;

public class Doctor {
	private int id;
	private String name;
	private String email;
	private String phone;
	
	public void insert() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Doctor ID:");
		id=scanner.nextInt();
		System.out.println("Enter the Doctor Name:");
		name=scanner.next();
		System.out.println("Enter the Doctor Phone:");
		phone=scanner.next();
		System.out.println("Enter the Doctor Email:");
		email=scanner.next();
		
		
	}
	
public void  display() {
	System.out.println("Enter the Doctor ID:"+id);
	System.out.println("Enter the Doctor Name:"+name);
	System.out.println("Enter the Doctor Phone:"+phone);
	System.out.println("Enter the Doctor Email:"+email);
	
		
	}
	
	

}
