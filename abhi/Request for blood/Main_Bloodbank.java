package bloodbank;

import java.sql.SQLException;
import java.util.List;

public class Main_Bloodbank {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserRegDAO uri=new UserRegDAOImpl();
		
//		UserReg user=new UserReg("RAMA","KUMAR",29,"MALE","RXYZ@GMAIL.COM","9876654563","GORAKHPUR","B+",1);
//		uri.create(user);
		
//		uri.delete("E003");
		
//		UserReg u = uri.read("E001");
//		System.out.println(u);
		List<UserReg> users = uri.read();
		for(UserReg u:users)
			System.out.println(u);
		
		
		

	}

}
