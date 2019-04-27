package com.blanche.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blanche.model.StudentInfo;
import com.blanche.model.User;
import com.blanche.util.JDBCUtil;

public class UserDao {
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	private User user;
	
	/*
	 * 注册用户数据
	 * 参数:User对象
	 */
	public void saveUser(User user) {
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into user(user_name,password,`right`) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRight());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("数据添加失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
	}
	/*
	 * 更新用户密码
	 */
	public int updatePassword(User user) {
		int result=0;
		try {
			con = JDBCUtil.getConnection();
			String sql = "update user set password=? where user_name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUserName());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("信息更新失败");
			e.printStackTrace();
		}
		
		return result;
	}
	/*
	 * 通过用户名查询账户
	 * 参数:userName
	 * 返回值:User对象
	 */
	public User queryByUserName(String userName) {
		User user = null;

		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from user where user_name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setRight(rs.getString("right"));
			}
		} catch (SQLException e) {
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return user;
	}
	
	public List<User> querryUserInfo(){
		List<User> users = new ArrayList<User>(); 
		
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from user";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				users.add(user);
				}
		} catch (SQLException e) {
			System.out.println("数据查询失败");
		}finally {
			JDBCUtil.clear(con, ps, rs);
		}
		return users;
	}
	
	public static void main(String[] args) {
		boolean flag = ("3117004669".matches("311[0-9]+"));
//		System.out.println(flag);
		User user = new User();
		UserDao userDao = new UserDao();
		user.setPassword("mx123123");
		user.setUserName("user01");
		int result = userDao.updatePassword(user);
		System.out.println(result);
	}
}
