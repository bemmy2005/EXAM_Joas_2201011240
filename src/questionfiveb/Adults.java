package questionfiveb;

public class Adults implements Member {
	private static double discount=0.02;
	Member member=new Adults();
	
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
