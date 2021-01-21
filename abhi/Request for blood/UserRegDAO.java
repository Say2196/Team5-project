package bloodbank;

import java.sql.SQLException;
import java.util.List;

public interface UserRegDAO {

	int create(UserReg user) throws SQLException;

	List<UserReg> read() throws SQLException;

	UserReg read(String id) throws SQLException;

	int update(UserReg user) throws SQLException;

	boolean delete(String id) throws SQLException;
	
	//int delete(String id) throws SQLException;

	

}