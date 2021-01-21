package donors.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DonorDAO {

	int create(Donors donor) throws SQLException;

	int update(Donors donor) throws SQLException;

	boolean delete(Integer id) throws SQLException;

	List<Donors> read() throws SQLException, ParseException;

	Donors read(Integer id) throws SQLException, ParseException;

}