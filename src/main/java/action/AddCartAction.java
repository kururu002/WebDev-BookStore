package action;



import model.Order;
import model.Orderitem;
import service.AppService;

public class AddCartAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private int userid;
	private int bookid;
	private int amount;

	private AppService appService;

	

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {
		Order foundCart=appService.getOrderByStatus(0, userid);//0 represent still in shopping cart
		if(foundCart==null){
			
			Order newcart=new Order(userid,null,0);
			
			appService.addOrder(newcart);
			foundCart=appService.getOrderByStatus(0, userid);
		}
		
		int orderid=foundCart.getId();
		if(amount>0){
		Orderitem orderitem = new Orderitem(orderid, bookid, amount);
		appService.addOrderitem(orderitem);}
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
