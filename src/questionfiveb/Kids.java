package questionfiveb;

public class Kids implements Member {
	Member member=new Kids();
	private static double discount=0.04;
		
	public void insert() {
		member.insert();
		
	}
	
	public static void display(){
		System.out.println("The discount is="+ discount);
			
		}
	public static void main(String[]args) {
       display();

	}

}
