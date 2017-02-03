package cn.vaf714.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 获取数据库连接工厂
 * 
 * @author vaf714
 *
 */
public class DBUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private Connection connection;
	static {
		// 进行初始化工作
		Properties properties = new Properties();
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			properties.load(in);
		} catch (IOException e) {
			System.out.println("配置文件读取错误！");
		}
		
		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}

	// 单例模式
	private DBUtil() {

	}

	private static final DBUtil dbUtil = new DBUtil();

	public static DBUtil getInstance() {
		return dbUtil;
	}
	
	/**
	 * 获取数据库连接
	 */
	public Connection getConnection(){
		try {
			//注册数据库驱动
			Class.forName(driver);
			//获取连接
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 关闭连接
	 */
	public void release(ResultSet rs,PreparedStatement ps,Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
