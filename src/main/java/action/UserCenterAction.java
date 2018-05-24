package action;

import service.AppService;

public class UserCenterAction extends BaseAction{
    /**
     * 
     */
    private AppService appService;
    private static final long serialVersionUID = 1L;
    @Override
    public String execute() throws Exception{
        int uid = (Integer) session().getAttribute("uid");
        String myphoto=appService.getIMG("user"+uid);
        String des=appService.getProfile("user"+uid+"des");
        request().setAttribute("myphoto", myphoto);
        request().setAttribute("mydes", des);
        return SUCCESS;
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
    }}
