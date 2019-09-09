package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {

	public static boolean isValid(String email, String password) {
		boolean status = false;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from employee where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}
	
	public static boolean isRegistered(String email) {
		boolean status = false;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from employee where email=?");
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			System.out.println("status: " +status);
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}

}
