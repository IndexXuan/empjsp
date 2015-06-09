package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

import util.DBUtil;

public class UserDao {
	public void save(User u){
		//Ԥ����sql���
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep;
		try{
			prep= conn
					.prepareStatement("insert into t_user (username,name,pwd,gendar) values (?,?,?,?)");
			//��sql����е������н��и�ֵ
			prep.setString(1, u.getUsername());
			prep.setString(2, u.getName());
			prep.setString(3, u.getPwd());
			prep.setString(4, u.getGendar());
			//ִ��sql
			prep.executeUpdate();
			DBUtil.close(conn);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User findByUsername(String username){
		User u = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep;
		try {
			prep=conn.prepareStatement("select * from t_user where username=?");
			prep.setString(1, username);
			ResultSet rs=prep.executeQuery();
			while(rs.next()){
				u=new User();
				u.setGendar(rs.getString("gendar"));
				u.setUsername(rs.getString("username"));
				u.setId(rs.getLong("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public static void main(String[] args) {
		User u=new User();
		u.setId(2);
		u.setUsername("����2");
		u.setName("����");
		u.setPwd("1234");
		u.setGendar("m");
		new UserDao().save(u);
	}
}
