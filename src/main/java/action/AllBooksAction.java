package action;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import service.AppService;

public class AllBooksAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@Override
	public String execute() throws Exception {

		List<Book> books = appService.getAllBooks();
		List<String> imgs=new ArrayList<String>();
		for(int i=0;i<books.size();i++){
		    imgs.add(appService.getIMG("setting"));
		}
		//request().setAttribute("imgs", imgs);
		request().setAttribute("books", books);

		return SUCCESS;
	}
}
