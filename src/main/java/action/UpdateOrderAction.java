package action;

import java.sql.Date;

import model.Order;
import service.AppService;

public class UpdateOrderAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userid;
	private Date date;
	private int status;

	private AppService appService;

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

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		Order order = appService.getOrderById(id);
		order.setUserid(userid);
		order.setDate(date);
		order.setStatus(status);
		appService.updateOrder(order);

		return SUCCESS;
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
