package cn.vaf714.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.vaf714.entity.AdminUser;
import cn.vaf714.util.DBUtil;

public class AdminUserDao {
	/**
	 * 查找管理员用户
	 * 
	 * @param username
	 * @return
	 */
	public AdminUser getUser(String username) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		AdminUser user = null;
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		String sql;
		// 2.准备 sql 语句
		sql = "select * from admin where name=?";

		try {
			// 3.执行 sql 语句
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			rs = preparedStatement.executeQuery();
			// 4.处理结果
			while (rs.next()) {
				user = new AdminUser(rs.getString("name"), rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.关闭连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}
		return user;
	}

}
