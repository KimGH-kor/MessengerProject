package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "C##DEV";
		String pw = "111111";

		try {
			Class.forName(driver);
			System.out.println("드라이브 가동");
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("드라이버 접속");
			
			String sql = "SELECT * FROM USERS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			//하나 가져오기
			//next는 불린 데이터값이다.
			
			while(rs.next()) {
				System.out.println(rs.getString(2));
			}
			
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

