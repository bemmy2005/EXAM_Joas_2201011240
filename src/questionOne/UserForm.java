package questionOne;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class UserForm implements ActionListener {

	//All  required fields
	JFrame frame;
	//Labels
	JLabel fnlbl=new JLabel("Firstname");
	JLabel lnlbl=new JLabel("Lastname");
	JLabel genlbl=new JLabel("Gender");
	JLabel regnlbl=new JLabel("Registration Number");

	//Fields
	JTextField fntext=new JTextField("");
	JTextField lntext=new JTextField("");
	JTextField gentext=new JTextField("");
	JTextField regtext=new JTextField("");
	//Buttons
	JButton inserButton=new JButton("Insert");
	JButton redButton=new JButton("Read");
	JButton updButton=new JButton("Update");
	JButton delButton=new JButton("Delete");
	JTable table=new JTable();
	JScrollPane scrollPane = new JScrollPane(table);

	//constructor
	public UserForm() {
		createWindow();
		setLocationsAndSize();
		addcompontentstoFrame();
		addActionEvent();
	}
	private void addActionEvent() {
		inserButton.addActionListener(this);
		redButton.addActionListener(this);
		updButton.addActionListener(this);
		delButton.addActionListener(this);

	}
	private void addcompontentstoFrame() {

		frame.add(fnlbl);	
		frame.add(lnlbl); 	
		frame.add(genlbl); 		
		frame.add(regnlbl);
		frame.add(fntext);
		frame.add(lntext);
		frame.add(gentext);
		frame.add(regtext);
		frame.add(inserButton);
		frame.add(redButton);
		frame.add(updButton);
		frame.add(delButton);
		frame.add(table);
		table.add(scrollPane, BorderLayout.CENTER);
	}
	private void setLocationsAndSize() {
//labels
		fnlbl.setBounds(20, 20, 100, 30);
		lnlbl.setBounds(20,70,100,30);
		genlbl.setBounds(20, 120, 100, 30);
		regnlbl.setBounds(20,170,100,30);

//Texfields
		fntext.setBounds(120,20,150,30);
		lntext.setBounds(120,70,150,30);
		gentext.setBounds(120,120,150,30);
		regtext.setBounds(180,170,150,30);
	//buttons
		inserButton.setBounds(20,220,100,30);
		redButton.setBounds(150, 220,100,30);
		updButton.setBounds(20,270,100,30);
		delButton.setBounds(150, 270,100,30);
		table.setBounds(10, 320, 345, 220);


	}
	private void createWindow() {
		frame=new JFrame();
		frame.setTitle("Student Information");
		frame.setBounds(10,10,380,700);
		frame.getContentPane().setBackground(Color.cyan);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	@SuppressWarnings("deprecation")
	@Override
	
	public void actionPerformed(ActionEvent e) {
		User user1=new User(null, null, null, null);


		if(e.getSource()==inserButton) {
			user1.setfname(fntext.getText());
			user1.setLname(lntext.getText());
			user1.setGender(gentext.getText());
			user1.setRegno(regtext.getText());
			
			user1.registertwo();
			DefaultTableModel tableModel=user1.populateTable();
			table.setModel(tableModel);
		}
		if(e.getSource()==redButton) {

			DefaultTableModel tableModel=user1.populateTable();
			table.setModel(tableModel);
		}
		if(e.getSource()==delButton) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			user1.deletedata(Integer.parseInt(userInput));
		}
		if(e.getSource()==updButton) {
			String userInput = JOptionPane.showInputDialog(null, "Enter id:");
			user1.setfname(fntext.getText());
			user1.setLname(lntext.getText());
			user1.setGender(gentext.getText());
			user1.setRegno(regtext.getText());
			
			user1.updatedata(Integer.parseInt(userInput));

		}

	}

	public static void main(String[] args) {
		UserForm usrfm=new UserForm();
	}





	



}
