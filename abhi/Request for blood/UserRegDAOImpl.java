package bloodbank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRegDAOImpl implements UserRegDAO {
	
	private String autoGenerateId() throws SQLException
	{
		//finding the max number portion from the existing ids
		//select max(substr(id,2,4)) from employee;
		Connection con=MyConnection.getConnection();
		ResultSet rs = con.createStatement().executeQuery("select max(substr(ID,2,4)) from USERREG");
		String id="";
		if(rs.next())
		{
			int max = rs.getInt(1);
			max++;
			if(max<10)
						
				id="E00"+max;			//single digit
			else if(max<100)
				id="E0"+max;			//2 digit number
			else
				id="E"+max;				//3 digit number
		}
		return id;
	}
	
	@Override
	public int create(UserReg user) throws SQLException
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement st=con.prepareStatement("INSERT INTO USERREG VALUES(?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, autoGenerateId());
		st.setString(2, user.getFirstName());
		st.setString(3, user.getLastName());
		st.setInt(4,user.getAge());
		st.setString(5,user.getGender());
		st.setString(6,user.getEmail());
		st.setString(7,user.getContactNumber());
		st.setString(8,user.getAddress());
		st.setString(9,user.getBloodgroup());
		st.setInt(10, user.getUnit());
		
		int n = st.executeUpdate();
		con.close();
		return n;
	}
	
	@Override
	public List<UserReg> read() throws SQLException
	{
		Connection con=MyConnection.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM Employee");
		ResultSet rs = st.executeQuery();
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		List<UserReg> userList=new ArrayList<UserReg>();
		while(rs.next())
		{
			UserReg user=new UserReg(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
			userList.add(user);
		}
		return userList;
	}
	
	@Override
	public UserReg read(String id) throws SQLException
	{
		Connection con=MyConnection.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM Employee WHERE id=?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		UserReg user=null;
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		if(rs.next())
			user=new UserReg(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
		return user;
	}
	@Override
	public int update(UserReg user) throws SQLException
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement st = con.prepareStatement("UPDATE USERREG SET FIRSTNAME=?,LASTNAME =?,AGE=?,GENDER=?,EMAIL=?,CONTACTNO=?,ADDRESS=?,BLOODGROUP=?,UNIT=?  WHERE id=?");
		
		st.setString(1, user.getFirstName());
		st.setString(2, user.getLastName());
		st.setInt(3,user.getAge());
		st.setString(4,user.getGender());
		st.setString(5,user.getEmail());
		st.setString(6,user.getContactNumber());
		st.setString(7,user.getAddress());
		st.setString(8,user.getBloodgroup());
		st.setInt(19, user.getUnit());
		st.setString(10, user.getId());
		int no=st.executeUpdate();
		con.close();
		return no;
	}
	
	@Override
	public boolean delete(String id) throws SQLException
	{
		Connection con = MyConnection.getConnection();
		//PreparedStatement st = con.prepareStatement("DELETE FROM USERREG WHERE ID=?");
		CallableStatement st=con.prepareCall("{call prcDeleteRequest(?)}");
		st.setString(1, id);
		//int no=st.executeUpdate();
		boolean status = st.execute();
		con.close();
		return status;
		
		
	}


		
	}


