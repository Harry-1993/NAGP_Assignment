package com.nagarro.msa.orders.orderdto;

public class OrderDto {
	private Integer orderid;
	private double orderamount;
	private String orderdate;

	public OrderDto(Integer orderid, double orderamount, String orderdate) {
		super();
		this.orderid = orderid;
		this.orderamount = orderamount;
		this.orderdate = orderdate;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public double getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(double orderamount) {
		this.orderamount = orderamount;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

}
