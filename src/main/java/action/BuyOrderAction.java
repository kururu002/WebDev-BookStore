package action;
import java.sql.Date;

import model.Order;
import service.AppService;

public class BuyOrderAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int id;
	
	
	private AppService appService;
	@Override
	public String execute() throws Exception {
		//System.out.println("DMN0");
		Order order = appService.getOrderById(id);
		order.setStatus(order.getStatus()+1);
		appService.updateOrder(order);
		//System.out.println("DMN");
		System.out.println(order.getStatus());
		return SUCCESS;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the appService
	 */
	public AppService getAppService() {
		return appService;
	}
	/**
	 * @param appService the appService to set
	 */
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
}