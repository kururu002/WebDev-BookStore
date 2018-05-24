package action;

import java.sql.Date;

import model.Order;
import service.AppService;

public class AddOrderAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private int status;
	private int userid;
	private Date date;

	private AppService appService;

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

		Order order = new Order(userid, date,status);
		appService.addOrder(order);

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
