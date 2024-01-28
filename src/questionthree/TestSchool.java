package questionthree;

import java.util.ArrayList;
import java.util.List;
public class TestSchool {

	public static void main(String[] args) {
		
		Teacher joas=new Teacher(1, "Niyitegeka Jean Joas",400000);
		Teacher john=new Teacher(2, "Manaishimwe John",030000);
		Teacher k=new Teacher(3, "Kamariza Cecile",100000);
		ArrayList<Teacher>teacherlList=new ArrayList<>();
		teacherlList.add(joas);
		teacherlList.add(john);
		teacherlList.add(k);
		
		Student d=new Student(1, "Mahoro", 1);
		Student v=new Student(2, "Teta", 2);
		Student kk=new Student(3, "Kari", 7);
		ArrayList<Student>studentlist=new ArrayList<>();
		studentlist.add(d);
		studentlist.add(v);
		studentlist.add(kk);
		
		School IPRCMUSANZE=new School(teacherlList, studentlist);
		Teacher m=new Teacher(5, "Alphonse", 100000);
		IPRCMUSANZE.addTeacher(m);
		
		d.PayFees(165726);
		v.PayFees(350000);
		
		System.out.println("IPRC MUSANZE has earned Frw "+IPRCMUSANZE.getTotalMoneyEarned() );
		
		
		System.out.println("----Making School pay Salary------");
		joas.receiveSalary(joas.getSalary());
		System.out.println("IPRC MUSANZE has spent  frw  "+joas.getSalary()+" for salary of "+joas.getName()+" and now has Frw "+IPRCMUSANZE.getTotalMoneyEarned());
	m.receiveSalary(m.getSalary());
	System.out.println("IPRC MUSANZE has spent  frw  "+m.getSalary()+" for salary of "+m.getName()+" and now has Frw "+IPRCMUSANZE.getTotalMoneyEarned());
	System.out.println(k);
	john.receiveSalary(john.getSalary());
	System.out.println(john);
	
	System.out.println(IPRCMUSANZE.getTotalMoneyEarned());
	
	
	}

}
