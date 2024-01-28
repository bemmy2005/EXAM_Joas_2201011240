package questionOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class User {
	private String fname;
	private String lname;
	private String regno;
	private String gender;
	
	
	public User(String fname, String lname, String regno, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.regno = regno;
		this.gender = gender;
	}
		
	public String getfname() {
		return fname;
	}

	public void setfname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	
	public void insert() {
		String host = "jdbc:mysql://localhost/School";
		String student = "root";
		String password = "";

		
		String sql = "INSERT INTO Student (fname,lname,Gender,RegNumber) VALUES (?, ?,?,?)";
		String sqlQuery = "SELECT RegNumber FROM Student";

		try (
				Connection con = DriverManager.getConnection(host, student, password);
				
				PreparedStatement pst = con.prepareStatement(sqlQuery);
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				ResultSet resultSet = pst.executeQuery()
				) {

			List<String> dataArray = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString("RegNumber");
				dataArray.add(data);
			}
			String[] dataArrayAsArray = dataArray.toArray(new String[0]);
			for (String data : dataArrayAsArray) {
				System.out.println(data);
			}
			
			preparedStatement.setString(1, this.fname);
			preparedStatement.setString(2, this.lname);
			preparedStatement.setString(3, this.gender);
			preparedStatement.setString(4, this.regno);
			for(String data:dataArray) {
				if (data==this.regno) {
					System.out.println("The RegNumber you entered is already used!");
				}else {
					
					int rowsAffected = preparedStatement.executeUpdate();
					
					if (rowsAffected > 0) {
						
						JOptionPane.showMessageDialog(null, "Data inserted successfully!.");
					} else {
						
						JOptionPane.showMessageDialog(null, "Failed to insert data.", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void registertwo() {
		String host = "jdbc:mysql://localhost/School";
		String student = "root";
		String password = "";

		// SQL query to insert data
		String sql = "INSERT INTO Student (fname,lname,Gender,RegNumber) VALUES (?, ?,?,?)";
		String sqlQuery = "SELECT RegNumber FROM Student";

		try (
				
				Connection con = DriverManager.getConnection(host, student, password);
				
				PreparedStatement pst = con.prepareStatement(sqlQuery);
				PreparedStatement pst1 = con.prepareStatement(sql);
				ResultSet resultSet = pst.executeQuery()
				) {

			List<String> dataArray = new ArrayList<>();
			while (resultSet.next()) {
				String data = resultSet.getString("RegNumber");
				dataArray.add(data);
			}


			
			if (dataArray.contains(this.regno)) {
				System.out.println("The RegNumber you entered is already used!");
				JOptionPane.showMessageDialog(null, "The RegNumber you entered is already used!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.fname.isBlank() && this.lname.isBlank()&& this.gender.isBlank()&&this.regno.isBlank()){
				JOptionPane.showMessageDialog(null, "Please fill in the required informations!.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}else {
				// Set the values for the prepared statement
				pst1.setString(1, this.lname);
				pst1.setString(2, this.fname);
				pst1.setString(3, this.gender);
				pst1.setString(4, this.regno);
			
				int rowsAffected = pst1.executeUpdate();
			
				if (rowsAffected > 0) {
					
					JOptionPane.showMessageDialog(null, "Data inserted successfully!.");
				} else {
					
					JOptionPane.showMessageDialog(null, "Failed to insert data.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void displayInformation() {
		String url = "jdbc:mysql://localhost/School";
		String student = "root";
		String password = "";
		
		String sql = "SELECT * from Student";

		try (
				
				Connection con = DriverManager.getConnection(url, student, password);
				
				PreparedStatement stm = con.prepareStatement(sql);

				
				ResultSet resultSet = stm.executeQuery();
				){
			
			resultSet.last();
			int rowCount = resultSet.getRow();
			resultSet.beforeFirst();

			
			Object[][] data = new Object[rowCount][4];

		
			int row = 0;
			while (resultSet.next()) {
				String column1Value = resultSet.getString("RegNumber");
				String column2Value = resultSet.getString("lname");
				String column3Value = resultSet.getString("fname");
				String column4Value = resultSet.getString("Gender");
				
				data[row][0] = column1Value;
				data[row][1] = column2Value;
				data[row][2] = column3Value;
				data[row][3] = column4Value;
				row++;
			}

			
			for (Object[] rowArray : data) {
				for (Object value : rowArray) {
					System.out.print(value + " ");
				}
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displaytwo() {
		String url = "jdbc:mysql://localhost/School";
		String student = "root";
		String password = "";
		
		String sql = "SELECT * from Student";

		try (
				
				Connection con = DriverManager.getConnection(url, student, password);
				
				PreparedStatement stm = con.prepareStatement(sql);

				
				ResultSet resultSet = stm.executeQuery();
				)
		{
			
			while (resultSet.next()) {
				String column1Value = resultSet.getString("RegNumber");
				String column2Value = resultSet.getString("lname");
				String column3Value = resultSet.getString("fname");
				String column4Value = resultSet.getString("Gender");

				System.out.println("id: " + column1Value + ", useaname: " + column2Value + ", password: " + column3Value);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused") DefaultTableModel populateTable() {
		String host = "jdbc:mysql://localhost/School";
		String student = "root";
		String password = "";

		String sql = "SELECT * FROM Student"; 
		DefaultTableModel tableModel = null;
		try (Connection con = DriverManager.getConnection(host, student, password);

				PreparedStatement preparedStatement = con.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

		
			int columnCount = resultSet.getMetaData().getColumnCount();

			Vector<String> columnNames = new Vector<>();
			for (int i = 1; i <= columnCount; i++) {
				columnNames.add(resultSet.getMetaData().getColumnName(i));
			}

			
			Vector<Vector<Object>> data = new Vector<>();
			while (resultSet.next()) {
				Vector<Object> row = new Vector<>();
				for (int i = 1; i <= columnCount; i++) {
					row.add(resultSet.getObject(i));
				}
				data.add(row);
			}

			
			tableModel = new DefaultTableModel(data, columnNames);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public void deletedata(int id) {
		String url = "jdbc:mysql://localhost/School";
		String student = "root";
		String password = "";
		

		String sql = "DELETE FROM Student WHERE id = ?";
		if(id==0) 
			JOptionPane.showMessageDialog(null, "No id entered");
		try (
				
				Connection con = DriverManager.getConnection(url, student, password);
				
				PreparedStatement stm = con.prepareStatement(sql);
				) {
			
			stm.setInt(1, id); 

		

			int result = JOptionPane.showConfirmDialog(null, "Do you really want to delete the student with id "+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);

			
			if (result == JOptionPane.YES_OPTION) {
				
				int rowsAffected = stm.executeUpdate();
				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "The student with id: "+id+"\n was deleted!");

				} else {
					
					JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				
				JOptionPane.showMessageDialog(null, "We can't delete the student");


			}
			


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatedata(int id) {
		String url = "jdbc:mysql://localhost/School";
        String student = "root";
        String password = "";

      
        String sql = "UPDATE Student SET fname = ?, lname = ?,Gender = ?, RegNumber = ? where id='"+id+"'";

        try (
         
            Connection con = DriverManager.getConnection(url, student, password);

           
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            
            stm.setString(1, this.fname);
            stm.setString(2, this.lname);
            stm.setString(3, this.gender);
            stm.setString(4, this.regno);
            
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the student with idd"+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);
                       
            if (result == JOptionPane.YES_OPTION) {
            	                int rowsAffected = stm.executeUpdate();

               
                if (rowsAffected > 0) {
                  
                    JOptionPane.showMessageDialog(null, "Student is  updated successfully!");

                } else {
                    System.out.println("Failed to update data. No matching record found.");
                    JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
               
                JOptionPane.showMessageDialog(null, "We will not delete your data");

            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updatedata(int id,String uname,String pwd) {
		String url = "jdbc:mysql://localhost/School";
        String student = "root";
        String password = "";

        
        String sql = "UPDATE Student SET fname = ?, lname = ?,Gender = ?, RegNumber = ? where id='"+id+"'";

        try (
            
            Connection con = DriverManager.getConnection(url, student, password);

           
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            
            stm.setString(1, uname);
            stm.setString(2, pwd);
            
            int result = JOptionPane.showConfirmDialog(null, "Do you really want to update the student with idd"+id+"\n?", "Question", JOptionPane.YES_NO_OPTION);
            
           
            if (result == JOptionPane.YES_OPTION) {
            	
                int rowsAffected = stm.executeUpdate();

                
                if (rowsAffected > 0) {
                   
                    JOptionPane.showMessageDialog(null, "Data updated successfully!");

                } else {
                    System.out.println("Failed to update data. No matching record found.");
                    JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                
                JOptionPane.showMessageDialog(null, "We will not delete your data");

            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
