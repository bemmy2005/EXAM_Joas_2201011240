package questiontwo;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private double salary ;
	public Employee(int id, String firstName, String lastName, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	//sets the employee's salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getName(String lastName,String firstName) {
		return this.lastName+" "+this.firstName;
	}
	public double getAnnualSalary(double salary) {
		return salary*=12;
	}
	public double  raiseSalary(double salary) {
		return salary=Math.pow(salary, 2);
	}
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + "]";
	}
	

}
