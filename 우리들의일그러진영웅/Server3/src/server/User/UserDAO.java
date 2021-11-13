package server.User;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public static HashMap<String, User> hash = new HashMap<>();

	public UserDAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "C##DEV";
		String pw = "111111";
		try {
			Class.forName(driver);
			System.out.println("드라이브 가동");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("드라이버 접속");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 로그인
	public int logUser(String id, String pass) {
		try {
			String sql = "SELECT * FROM USERS WHERE USER_ID = ? AND USER_PW = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("드라이버 제거");
				System.out.println("접속 성공");
				return 1;// 접속
			}
			return -1;// 아이디가 없음

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -2;// 디비 오류
	}

	// 회원가입
	public int regUser(String id, String pass, String name, String tel) {
		try {
			String code = "0";
			String sql = "SELECT MAX(USER_CODE) FROM USERS";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				code = rs.getString(1);
			}
			int code1 = Integer.parseInt(code)+1;
			System.out.println(code1);
			
			sql = "INSERT INTO USERS VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(code1));
			pstmt.setString(2, id);
			pstmt.setString(3, pass);
			pstmt.setString(4, name);
			pstmt.setString(5, tel);
			System.out.println("드라이버 제거");
			pstmt.executeUpdate();
			rs.close();
			con.close();
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;// 디비 오류

	}
	public User you(String id) {

		try {
			String USER_CODE = null;
			String USER_ID = null;
			String USER_PW = null;
			String USER_NAME = null;
			String PHONE = null;
			
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				USER_CODE = rs.getString(1);
				USER_ID = rs.getString(2);
				USER_PW = rs.getString(3);
				USER_NAME = rs.getString(4);
				PHONE = rs.getString(5);
			}
			User u = new User(USER_ID, USER_PW, USER_NAME, PHONE);
			rs.close();
			con.close();
			System.out.println("드라이버 제거");
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;// 디비 오류

	}
	}
