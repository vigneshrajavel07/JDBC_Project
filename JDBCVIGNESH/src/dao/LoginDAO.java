package dao;
import java.sql.*;

import connectionManager.ConnectionManager;
import model.Login;
public class LoginDAO {
	//data access object
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
	 String username = login.getUsername();
	 String password = login.getPassword();
	 
	    ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		//create a statement object to execute a query
		Statement st=con.createStatement();
		
		//execute the statement object and return a result set
		ResultSet rs = st.executeQuery("select * from Login");
		
		while(rs.next())
		{
			if(username.equals(rs.getString("username"))&&password.equals(rs.getString("password")))
			{
				//close the connection
				conn.closeConnection();
				return true;
			}
		}
		conn.closeConnection();
		return false; 
	}

}