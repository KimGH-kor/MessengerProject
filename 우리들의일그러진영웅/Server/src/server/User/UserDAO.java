package server.User;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {
	public static List<User> list = new ArrayList();
	public static HashMap<String, User> hash = new HashMap<>();
	public UserDAO() {
		list.add(new User("mopn", "111", "김경환", "010"));
		list.add(new User("yang", "111", "양지현", "010"));
		list.add(new User("hong", "111", "홍남기", "010"));
		list.add(new User("woo", "111", "우한영", "010"));
		list.add(new User("kim", "111", "김튼튼", "010"));
		list.add(new User("rim", "111", "임대천", "010"));
		System.out.println("현재 전체 회원 수 : "+list.size());
	}
	//로그인
	public int logUser(String id, String pass) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getuID().equals(id)&& list.get(i).getPw().equals(pass)) {
				System.out.println("접속 성공");
				return i;//접속
			}
		}
		return -1;//디비오류
	}
	//회원가입
	public int regUser(String id, String pass, String name, String tel) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getuID());
			if(list.get(i).getuID() == id && list.get(i).getPw() == pass) {
				return -1;//중복
				}
			}
			list.add(new User(id, pass, name, tel));
			return 1;//생성
	}
	
}
	