package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BloodGroupDAOImpl  {

	    public   int update(BloodGroup bloodgroup) throws SQLException {
		Connection con = MyConnection.getConnection();
		PreparedStatement st = con.prepareStatement("UPDATE BloodGroup SET NoOfUnits=? WHERE BloodGroup=?");
		st.setDouble(1,bloodgroup.getNoOfUnits());
		st.setString(2, bloodgroup.getBloodGroup());	
		int no=st.executeUpdate();
     	con.close();
		return no;

		
	}
	    public BloodGroup read(String str) throws SQLException, ParseException {
			Connection con=MyConnection.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM BloodGroup WHERE bloodgroup=?");
			st.setString(1, str);
			ResultSet rs = st.executeQuery();
			BloodGroup bloodgroup=null;
			if(rs.next())
				bloodgroup=new BloodGroup( rs.getString(1),rs.getInt(2));
			return bloodgroup;
		
			
		}
	    public List<BloodGroup> read() throws SQLException, ParseException {
			
			Connection con=MyConnection.getConnection();
			PreparedStatement st = con.prepareStatement("SELECT * FROM BloodGroup");
			ResultSet rs = st.executeQuery();
			List<BloodGroup> bloodGroupList=new ArrayList<BloodGroup>();
			while(rs.next())
			{
				BloodGroup bloodgroup=new BloodGroup(rs.getString(1),rs.getInt(2));
				bloodGroupList.add(bloodgroup);
			}
			return bloodGroupList;
		
		}

	
	public static void main(String[] args) throws SQLException {
//		BloodGroupDAOImpl bgi=new BloodGroupDAOImpl();
//		BloodGroup bg=new BloodGroup("A+",500);
//		bgi.update(bg);
//		System.out.println("sucess");
		
	}
}
