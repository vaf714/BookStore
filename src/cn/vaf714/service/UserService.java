package cn.vaf714.service;

import java.util.List;

import cn.vaf714.dao.AdminUserDao;
import cn.vaf714.dao.CartDao;
import cn.vaf714.dao.CommodityDao;
import cn.vaf714.dao.GeneralUserDao;
import cn.vaf714.entity.Cart;
import cn.vaf714.entity.CartList;
import cn.vaf714.entity.Commodity;
import cn.vaf714.entity.GeneralUser;
import cn.vaf714.entity.User;

public class UserService {
	/**
	 * 调用 DAO 添加新用户
	 */
	public boolean addUser(User user) {
		boolean isSuccess = new GeneralUserDao().addUser(user);
		return isSuccess;
	}

	/**
	 * 登陆时查询用户
	 * 
	 * @param type
	 * @param userFromJsp
	 * @return
	 */
	public User login(int type, User userFromJsp) {
		// 1.获取用户名
		String userName = userFromJsp.getUserName();
		User user = null;

		// 2.根据用户名查询用户
		if (type == 1) {
			user = new GeneralUserDao().getUser(userName);
		} else {
			user = new AdminUserDao().getUser(userName);
		}
		return user;
	}

	/**
	 * 加入购物车
	 * 
	 * @param user
	 * @param shoppingNum
	 * @param id
	 */
	public void addToCart(GeneralUser user, int buyNum, String buyCommodityId) {

		// 一.更新数据库商品的库存
		// 1.查找该商品
		Commodity commodity = new CommodityDao().querySingleCommodity(buyCommodityId);
		// 2.更新
		System.out.println(commodity.getNum() - buyNum);
		commodity.setNum(commodity.getNum() - buyNum);
		new CommodityDao().alterCommoditybyId(buyCommodityId, commodity);

		// 二、判断该商品是否已在
		Cart cart = new CartDao().queryCart(user.getUserName(), commodity.getId());
		if (cart != null) {
			// 1.该商品已经存在于购物车,更新该记录
			new CartDao().alterCart(user.getUserName(), commodity.getId(),
					cart.getBuyNum() + buyNum);
		} else {
			// 2.该商品不存在与购物车,直接添加
			new CartDao().addToCart(new Cart(user.getUserName(), commodity.getId(), buyNum));
		}
	}

	/**
	 * 添加到用户的购物车
	 * 
	 * @param commodity
	 * @param num
	 */
	// private void addToCart(CommodityByShopping
	// commodityByShopping,GeneralUser user){
	// int indexOf = -1;
	// int i = 0;
	// List<CommodityByShopping> shoppingCart = user.getShoppingCart();
	// // 1.判断是否已有该商品
	// for(CommodityByShopping commodity : shoppingCart){
	// if (commodity.getName().equals(commodityByShopping.getName())) {
	// //System.out.println(commodity.getName() + "," +
	// commodityByShopping.getName());
	// indexOf = i;
	// break;
	// }
	// i++;
	// }
	// //System.out.println(indexOf);
	// if (indexOf != -1) {
	// //已存在
	// commodityByShopping.setNum(shoppingCart.get(indexOf).getNum() +
	// commodityByShopping.getNum());
	// shoppingCart.remove(indexOf);
	//// System.out.println(commodityByShopping);
	// }
	// shoppingCart.add(commodityByShopping);
	// }

	/**
	 * 得到用户的购物车Map
	 * 
	 * @param user
	 * @return
	 */
	public List<CartList> getCart(GeneralUser user) {
		List<CartList> cartList = new CartDao().getCart(user);
		return cartList;
	}

	/**
	 * 计算购物车的总价
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public float countShoppingCartPrice(List<CartList> shoppingCart) {
		float allPrice = 0.0f;// 购物车的总价
		for (CartList commodityByShopping : shoppingCart) {
			allPrice += commodityByShopping.getCommodityPrice() * commodityByShopping.getBuyNum();
		}

		return allPrice;

	}

	/**
	 * 计算购物车的总数
	 * 
	 * @param shoppingCart
	 * @return
	 */
	public int countShoppingCartNum(List<CartList> shoppingCart) {
		int allNum = 0;// 购物车的总数
		for (CartList commodityByShopping : shoppingCart) {
			allNum += commodityByShopping.getBuyNum();
		}

		return allNum;

	}
}
