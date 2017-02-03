package cn.vaf714.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vaf714.entity.Cart;
import cn.vaf714.entity.CartList;
import cn.vaf714.entity.User;
import cn.vaf714.util.DBUtil;

public class CartDao {
	/**
	 * 向购物车添加新购买的物品
	 * 
	 * @param user
	 */
	public boolean addToCart(Cart cart) {
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		// 2.准备 sql 语句
		String sql = "insert into cart values(?,?,?)";
		try {
			// 3.执行 sql 语句
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cart.getUserName());
			preparedStatement.setString(2, cart.getCommodityId());
			preparedStatement.setInt(3, cart.getBuyNum());

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
	 * 得到购买的物品放入 List 中
	 * 
	 * @return
	 */
	public List<CartList> getCart(User user) {

		List<CartList> cartList = new ArrayList<>();
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 2.准备 sql 语句
			String sql = "SELECT co.name, co.price, ca.commodity_num FROM cart ca, commodity co WHERE ca.user_name = ? AND co.id = ca.commodity_id;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			// 3.执行 sql 语句
			resultSet = preparedStatement.executeQuery();

			// 4.处理 结果集
			while (resultSet.next()) {
				cartList.add(new CartList(user.getUserName(), resultSet.getString("name"), resultSet.getFloat("price"),
						resultSet.getInt("commodity_num")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(resultSet, preparedStatement, connection);
		}

		return cartList;

	}

	/**
	 * 查询单个购物车商品
	 * 用于查询是否已经买了某个商品
	 * @param commodityName
	 * @return
	 */
	public Cart queryCart(String userName, String commodityName) {
		Cart cart = null;
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 2.准备 sql 语句
			String sql = "SELECT * FROM cart WHERE commodity_id=? and user_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, commodityName);
			preparedStatement.setString(2, userName);
			// 3.执行 sql 语句
			resultSet = preparedStatement.executeQuery();

			// 4.处理 结果集
			while (resultSet.next()) {
				cart = new Cart(resultSet.getString("user_name"), resultSet.getString("commodity_id"),
						resultSet.getInt("commodity_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(resultSet, preparedStatement, connection);
		}

		return cart;
	}

	/**
	 * 修改一条记录
	 * 当购买相同的商品时调用此方法修改购买数量
	 * @param userName
	 * @param name
	 */
	public void alterCart(String userName, String commodityId, int buyNum) {
		// 1.获取数据库连接
		Connection connection = DBUtil.getInstance().getConnection();
		PreparedStatement preparedStatement = null;
		try {
			// 2.准备 sql 语句
			String sql = "update cart set commodity_num=? WHERE commodity_id=? and user_name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, buyNum);
			preparedStatement.setString(2, commodityId);
			preparedStatement.setString(3, userName);
			// 3.执行 sql 语句
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭数据库连接
			DBUtil.getInstance().release(null, preparedStatement, connection);
		}

	}

}
