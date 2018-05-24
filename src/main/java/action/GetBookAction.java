package action;

import org.json.JSONObject;

import com.opensymphony.xwork2.Action;

import model.Book;
import service.AppService;

public class GetBookAction extends BaseAction{
    private static final long serialVersionUID = 1L;
    private String result;
    private int bookid;
    private AppService appService;

    public void setAppService(AppService appService) {
            this.appService = appService;
    }

    @Override
    public String execute() throws Exception {
        System.out.println("DMN");
        Book book=appService.getBookById(5);
        System.out.println(book);
        JSONObject jsonbook=new JSONObject(book);
        System.out.println(jsonbook);
        System.out.println(jsonbook.toString());
        result=jsonbook.toString();
        return Action.SUCCESS;
    }

    /**
     * @return the json
     */
    public String getResult() {
        return result;
    }

    /**
     * @param json the json to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the bookid
     */
   
    /**
     * @param bookid the bookid to set
     */
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
