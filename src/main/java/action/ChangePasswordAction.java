package action;

import service.AppService;
import model.User;
public class ChangePasswordAction extends BaseAction  {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private AppService appService;
    private int userid;
    private String password;
    private String newpassword;
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
    @Override
    public String execute() throws Exception {
        
        int uid = (Integer) session().getAttribute("uid");
        User u=appService.getUserById(uid);
        
        if(u.getPassword().equalsIgnoreCase(password)){
            u.setPassword(newpassword);
            appService.updateUser(u);
            return SUCCESS;
        }
        return ERROR;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the newpassword
     */
    public String getNewpassword() {
        return newpassword;
    }
    /**
     * @param newpassword the newpassword to set
     */
    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
