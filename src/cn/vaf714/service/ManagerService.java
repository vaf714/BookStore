package cn.vaf714.service;

import java.util.List;

import cn.vaf714.dao.CommodityDao;
import cn.vaf714.entity.Commodity;

public class ManagerService {
	/**
	 * 添加商品
	 */
	public boolean addCommdity(Commodity commodity) {
		// 1.调用 dao 层添加商品到数据库
		boolean isSuccess = new CommodityDao().addCommodity(commodity);

		return isSuccess;
	}

//	/**
//	 * 列出商品
//	 * 
//	 * @return
//	 */
//	public static List<Commodity> listCommodities() {
//		List<Commodity> commodities;
//
//		// 2.查找数据库
//		commodities = new CommodityDao().queryCommodity("");
//		return commodities;
//	}

	/**
	 * 删除商品
	 * 
	 * @param id
	 */
	public void deleteCommodity(String id) {
		// 1.调用 dao 层删除
		new CommodityDao().deleteCommoditybyId(id);
	}

	/**
	 * 修改商品
	 * 
	 * @param beforAlterId
	 * @param commodity
	 */
	public boolean alterCommodity(String beforAlterId, Commodity commodity) {
		// 1.调用 dao 层修改
		boolean isSuccess = new CommodityDao().alterCommoditybyId(beforAlterId,commodity);
		return isSuccess;
	}
	
	/**
	 * 模糊查询商品
	 * @param id
	 * @return
	 */
	public List<Commodity> queryCommodity(String id) {
		List<Commodity> commodity = new CommodityDao().queryCommodity(id);
		return commodity;
	}

}
