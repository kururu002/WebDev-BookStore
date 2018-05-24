package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Order;
import service.AppService;

public class CartAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {
	    List<String>IMGs=new ArrayList<String>();
		List<Book> books = appService.getAllBooks();
		for(int i=0;i<books.size();i++){
		    IMGs.add(appService.getIMG(books.get(i).getTitle()));
		}
		request().setAttribute("books", books);
		request().setAttribute("IMGs",IMGs);
		
		return SUCCESS;
	}
}