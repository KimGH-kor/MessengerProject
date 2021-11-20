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
				pstmt.close();
				rs.close();
				return 1;// 접속
			}
			pstmt.close();
			rs.close();
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
			int code1 = Integer.parseInt(code) + 1;
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
			
			pstmt.close();
			rs.close();

			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;// 디비 오류

	}

	// 유저 체크
	public User you(String id) {

		try {
			User u = null;
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
				u = new User(USER_ID, USER_PW, USER_NAME, PHONE);
			}

			pstmt.close();
			rs.close();
			System.out.println("드라이버 제거");
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;// 디비 오류

	}
	
	public void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("디비 연결이 끊겼습니다.");
	}

//messageDAO
//	 2-1. 인서트
	
	//다건 조회 = 반대로 보냅니다.
	public ArrayList<messageDTO> selMsg(String id) {
		ArrayList<messageDTO> arr = new ArrayList<>();
		try {
			String sql = "SELECT * FROM MESSAGE WHERE CHATID = ? AND ROWNUM < 20 ORDER BY MSG_DATE DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				arr.add(new messageDTO(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
			pstmt.close();
			rs.close();
			return arr;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	//인설트
	public int setMsg(String id, String from, String msg_text) {
		int cnt = -1;
		try {
			String sql = "INSERT INTO MESSAGE(CHATID, FROM_ID, MSG_TEXT) VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, from);
			pstmt.setString(3, msg_text);
			
			cnt = pstmt.executeUpdate();
			
			pstmt.close();
			rs.close();
			return cnt;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
}
