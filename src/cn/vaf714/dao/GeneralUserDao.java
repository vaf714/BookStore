package cn.vaf714.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.vaf714.entity.GeneralUser;
import cn.vaf714.entity.User;
import cn.vaf714.util.DBUtil;

public class GeneralUserDao {
	/**
	 * 向数据库添加新用户
	 * 
	 * @param user
	 */
	public boolean addUser(User user) {
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		
//		System.out.println(user.getUserName() + user.getPassword());
		// 2.准备 sql 语句
		String sql = "insert into user values(?,?)";
		try {
			// 3.执行 sql 语句
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// 4.关闭连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}
		return true;
	}

	/**
	 * 查询数据库
	 * 
	 * @param username
	 * @return
	 */
	public GeneralUser getUser(String username) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		GeneralUser user = null;
		
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		
		// 2.准备 sql 语句
		String sql = "select * from user where name=?";

		try {
			// 3.执行 sql 语句
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			rs = preparedStatement.executeQuery();
			// 4.处理结果
			while (rs.next()) {
				user = new GeneralUser(rs.getString("name"), rs.getString("password"));
				//System.out.println(rs.getString("name") + rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.关闭连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}
		//System.out.println(user);
		return user;
	}
}
