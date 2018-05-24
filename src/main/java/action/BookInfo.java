package action;

import model.Book;
import service.AppService;

public class BookInfo extends BaseAction {
        private static final long serialVersionUID = 1L;
        
        private AppService appService;
        private int bookid;
        
        public void setAppService(AppService appService) {
                this.appService = appService;
        }
        
        public void setBookid(int bookid) {
                this.bookid = bookid;
        }
        
        @Override
        public String execute() throws Exception {
                
                Book book= appService.getBookById(bookid);
                String IMG=appService.getIMG(book.getTitle());
                request().setAttribute("book", book);
                request().setAttribute("IMG", IMG);
                return SUCCESS;
        }
}