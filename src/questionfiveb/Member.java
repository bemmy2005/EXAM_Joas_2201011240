package questionfiveb;
import java.util.Scanner;
public interface Member {
		
		public default void insert() {
			int mpid;
			String mpname;
			String mphone;
			double mregfees;
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the  MembeID:");
			mpid=scanner.nextInt();
			System.out.println("Enter the  Member name:");
			mpname=scanner.next();
			System.out.println("Enter the Member Phone:");
			mphone=scanner.next();
			System.out.println("Enter the Member Registration fees:");
			mregfees=scanner.nextFloat();
			
		}

	}



