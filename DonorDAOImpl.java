package donors.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;











public class DonorDAOImpl implements DonorDAO {

	@Override
	public int create(Donors donor) throws SQLException
	
	{
		Connection con = MyDonorConnection.getConnection();
		PreparedStatement st = con.prepareStatement("INSERT INTO DONORS VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		st.setString(1, donor.getFirstname());
		st.setString(2, donor.getLastname());
		st.setInt(3, donor.getAge());
		st.setString(4, donor.getGender());
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		String dob=sdf.format(donor.getDob());
		st.setString(5, dob);
		st.setInt(6, donor.getHeight());
		st.setInt(7, donor.getWeight());
		st.setString(8, donor.getMailid());
		st.setInt(9, donor.getPhone());
		st.setString(10, donor.getAddress());
		st.setString(11, donor.getBloodgrp());
		st.setString(12, donor.getFlag());
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy");
		String ldd=sdf1.format(donor.getLastblooddonation());
		st.setString(13, ldd);
		int no=st.executeUpdate();
		con.close();
		return no;
	}
	
@Override
public int update(Donors donor) throws SQLException
	
	{
		Connection con = MyDonorConnection.getConnection();
		PreparedStatement st = con.prepareStatement("UPDATE DONORS SET FIRSTNAME=?,LASTNAME=?,AGE=?,GENDER=?,DOB=?,HEIGHT=?,WEIGHT=?,MAILID=?,PHONENO=?,ADDRESS=?,BLOODGROUP=?,FLAG=?,LDD=? WHERE ID=?");
		
		st.setString(1, donor.getFirstname());
		st.setString(2, donor.getLastname());
		st.setInt(3, donor.getAge());
		st.setString(4, donor.getGender());
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		String dob=sdf.format(donor.getDob());
		st.setString(5, dob);
		st.setInt(6, donor.getHeight());
		st.setInt(7, donor.getWeight());
		st.setString(8, donor.getMailid());
		st.setInt(9, donor.getPhone());
		st.setString(10, donor.getAddress());
		st.setString(11, donor.getBloodgrp());
		st.setString(12, donor.getFlag());
		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy");
		String ldd=sdf1.format(donor.getLastblooddonation());
		st.setString(13, ldd);
		st.setInt(14, donor.getId());
		int no=st.executeUpdate();
		con.close();
		return no;
	}

@Override
public boolean delete(Integer id) throws SQLException
{
	Connection con = MyDonorConnection.getConnection();
//	PreparedStatement st = con.prepareStatement("DELETE FROM DONORS WHERE ID=?");
	CallableStatement st=con.prepareCall("{call  prcDeleteDonor(?)}");
	
	st.setInt(1, id);
	boolean no=st.execute();
	con.close();
	return no;
}

@Override
public List<Donors> read() throws SQLException, ParseException
{
	Connection con=MyDonorConnection.getConnection();
	PreparedStatement st = con.prepareStatement("SELECT * FROM DONORS");
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	ResultSet rs = st.executeQuery();
	
	List<Donors> donorList=new ArrayList<Donors>();
	while(rs.next())
	{
		Donors donor=new Donors(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),sdf.parse(rs.getString(6)),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13),sdf.parse(rs.getString(14)));
		donorList.add(donor);
	}
	con.close();
	return donorList;
}

@Override
public Donors read(Integer id) throws SQLException, ParseException
{
	Connection con=MyDonorConnection.getConnection();
	PreparedStatement st = con.prepareStatement("SELECT * FROM DONORS WHERE ID=?");
	st.setInt(1, id);
	ResultSet rs = st.executeQuery();
	Donors donor=null;
//	2020-12-27
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");

	if(rs.next())
		donor=new Donors(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),sdf.parse(rs.getString(6)),rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13),sdf.parse(rs.getString(14)));
	con.close();
	return donor;
}
	
}
