package action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import service.AppService;
import service.SalesService;

public class SalesAction extends BaseAction{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private AppService appService;
    private int userid;
    private int bookid;
    
    public AppService getAppService() {
        return appService;
    }
    /**
     * @param appService the appService to set
     */
    public void setAppService(AppService appService) {
        this.appService = appService;
    }
    

    public int getUserid() {
        return userid;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }


    public int getBookid() {
        return bookid;
    }


    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public String execute(){
        int amount=appService.sales(userid, bookid);
        request().setAttribute("amount", amount);
        return SUCCESS;
    }
}