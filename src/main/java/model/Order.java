package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private int id;
	private int userid;
	private Date date;
	private int status;
	public Order() {
	}

	public Order(int userid, Date date,int status) {
		this.userid = userid;
		this.date = date;
		this.status=status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Set<Orderitem> orderitems = new HashSet<Orderitem>();

	public Set<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}
