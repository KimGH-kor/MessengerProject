package server.User;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {
	public static List<User> list = new ArrayList();
	public static HashMap<String, User> hash = new HashMap<>();
	public UserDAO() {
		list.add(new User("mopn", "111", "���ȯ", "010"));
		list.add(new User("yang", "111", "������", "010"));
		list.add(new User("hong", "111", "ȫ����", "010"));
		list.add(new User("woo", "111", "���ѿ�", "010"));
		list.add(new User("kim", "111", "��ưư", "010"));
		list.add(new User("rim", "111", "�Ӵ�õ", "010"));
		System.out.println("���� ��ü ȸ�� �� : "+list.size());
	}
	//�α���
	public int logUser(String id, String pass) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getuID().equals(id)&& list.get(i).getPw().equals(pass)) {
				System.out.println("���� ����");
				return i;//����
			}
		}
		return -1;//������
	}
	//ȸ������
	public int regUser(String id, String pass, String name, String tel) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getuID());
			if(list.get(i).getuID() == id && list.get(i).getPw() == pass) {
				return -1;//�ߺ�
				}
			}
			list.add(new User(id, pass, name, tel));
			return 1;//����
	}
	
}
	