package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import model.Book;
import model.Order;
import model.Orderitem;
import service.AppService;

public class MyHistoryAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	private AppService appService;
	private int userid;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {
				
		int uid=(Integer) session().getAttribute("uid");
		List<List<Orderitem>> allitems=new ArrayList<List<Orderitem>>();
		List<Order> orders=appService.getOrderListByUser(uid);	
		
		if(orders==null)return ERROR;

		List<Book> books = appService.getAllBooks();
                request().setAttribute("books", books);
		
		
		request().setAttribute("orders", orders);
		//request().setAttribute("allitems", allitems);
		//request().setAttribute("amounts", amounts);
		//System.out.println("POOz:");
		return SUCCESS;
	}

	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
