package cn.vaf714.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vaf714.entity.Commodity;
import cn.vaf714.util.DBUtil;

public class CommodityDao {
	/**
	 * 管理员添加商品
	 * 
	 * @param commdity
	 * @return
	 */
	public boolean addCommodity(Commodity commodity) {
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;

		try {
			// 2.准备 sql 语句
			String sql = "insert into commodity values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, commodity.getId());
			preparedStatement.setString(2, commodity.getName());
			preparedStatement.setString(3, commodity.getPrice());
			preparedStatement.setInt(4, commodity.getNum());

			// 3.执行 sql 语句
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;// -1代表添加失败
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}

		return true;// 1代表成功
	}

	/**
	 * 得到商品信息放入 List 中
	 * 
	 * @return
	 */
//	public List<Commodity> getCommodities() {
//		List<Commodity> commodities = new ArrayList<>();
//		// 1.获取数据库连接
//		Connection connection = DBUtil.getInstance().getConnection();
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		try {
//			// 2.准备 sql 语句
//			String sql = "select * from commodity";
//			preparedStatement = connection.prepareStatement(sql);
//
//			// 3.执行 sql 语句
//			resultSet = preparedStatement.executeQuery();
//
//			// 4.处理 结果集
//			while (resultSet.next()) {
//				commodities.add(new Commodity(resultSet.getString("id"), resultSet.getString("name"),
//						resultSet.getString("price"), resultSet.getInt("num")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 4.关闭数据库连接
//			DBUtil.getInstance().release(resultSet, preparedStatement, connection);
//		}
//
//		return commodities;
//	}

	/**
	 * 根据商品编号删除商品
	 * 
	 * @param id
	 */
	public void deleteCommoditybyId(String id) {
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		try {
			// 2.准备 sql 语句
			String sql = "delete from commodity where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			// 3.执行 sql 语句
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}
	}

	/**
	 * 修改商品信息
	 * 
	 * @param beforAlterId
	 * @param commodity
	 */
	public boolean alterCommoditybyId(String beforAlterId, Commodity commodity) {
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		try {
			// 2.准备 sql 语句
			String sql = "update commodity set id=?,name=?,price=?,num=? where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, commodity.getId());
			preparedStatement.setString(2, commodity.getName());
			preparedStatement.setString(3, commodity.getPrice());
			preparedStatement.setInt(4, commodity.getNum());
			preparedStatement.setString(5, beforAlterId);
			// 3.执行 sql 语句
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}
		return true;
	}

	/**
	 * 模糊查找商品
	 * 
	 * @param id
	 * @return
	 */
	public List<Commodity> queryCommodity(String id) {
		List<Commodity> commodity = new ArrayList<>();
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 2.准备 sql 语句
			String sql = "select * from commodity where id like ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + id + "%");
			// 3.执行 sql 语句
			resultSet = preparedStatement.executeQuery();

			// 4.处理 结果集
			while (resultSet.next()) {
				commodity.add(new Commodity(resultSet.getString("id"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getInt("num")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(resultSet, preparedStatement, connection);
		}
		//System.out.println(commodity);
		return commodity;
	}
	
	/**
	 * 查找单个商品
	 * 
	 * @param id
	 * @return
	 */
	public Commodity querySingleCommodity(String id) {
		Commodity commodity = null;
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 2.准备 sql 语句
			String sql = "select * from commodity where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			// 3.执行 sql 语句
			resultSet = preparedStatement.executeQuery();

			// 4.处理 结果集
			while (resultSet.next()) {
				commodity = new Commodity(resultSet.getString("id"), resultSet.getString("name"),
						resultSet.getString("price"), resultSet.getInt("num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(resultSet, preparedStatement, connection);
		}

		return commodity;
	}

}
