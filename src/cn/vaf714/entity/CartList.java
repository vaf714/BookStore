package cn.vaf714.entity;

public class CartList {
	private String userName;
	private String commodityName;
	private float commodityPrice;
	private int buyNum;
	public CartList(String userName, String commodityName, Float commodityPrice, int buyNum) {
		super();
		this.userName = userName;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.buyNum = buyNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public float getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(Float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	
	public CartList() {
		super();
	}
	
}
