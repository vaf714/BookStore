package cn.vaf714.entity;

public class Cart {
	private String userName;
	private String commodityId;
	private int buyNum;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public Cart(String userName, String commodityId, int buyNum) {
		super();
		this.userName = userName;
		this.commodityId = commodityId;
		this.buyNum = buyNum;
	}
	public Cart() {
		super();
	}
}
