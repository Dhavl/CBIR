import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
	Statement stmt=null;
	Connection con;
	ResultSet rs = null;
    PreparedStatement ps = null;
    FileInputStream fis=null;
    InputStream sImage=null;
    byte[] bytearray;
	Connection connect()
	{
		final String USERNAME = "root";		
		final String PASSWORD = "root";
		final String CONN_STRING = "jdbc:mysql://localhost:3306/";
		String dbName = "test";
		String driver = "com.mysql.jdbc.Driver";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			con = DriverManager.getConnection(CONN_STRING+dbName, USERNAME, PASSWORD);
			} catch (SQLException e) {
			System.out.print("error in getting con"+e.toString());
				
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return con;

	}
	void store(String path,String color,Double entropy,Double edgeentropy)
	{
		
		try
		{
			String sql = "INSERT INTO `test`.`ImageStore`(`name`,`image`,`entropy`,`shape`)VALUES(?,?,?,?)";
			ps = con.prepareStatement(sql);
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			ps.setString(1, color);
			ps.setBinaryStream(2,(InputStream)fis,(int)(file.length()));
			ps.setDouble(3, entropy);
			ps.setDouble(4, edgeentropy);
			int i = ps.executeUpdate();
			if(i!=0)
			{
				System.out.println("image has been inserted");
			}
			else
			{
				System.out.println("image is not inserted");
			}	
            
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql exception");
		} catch(NullPointerException e)
		{
			System.out.println("exceptione ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		        if (fis != null) {
		                try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
		            }
		           try {
					if (con != null && !con.isClosed()) {
					       try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       }	
	}
	
	public static void main(String args[])
	{
		
		Database d=new Database();
		d.connect();
		//d.store(path);
	}
}
