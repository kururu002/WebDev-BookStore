package action;

import com.opensymphony.xwork2.ActionSupport;


import service.RegisterService;

public class RegisterAction extends ActionSupport{
    private RegisterService registerservice;
    private String password;
    private String username;
    
    
    


    public String register(){
        Boolean flag=registerservice.register(username, password);
        if(flag){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }





	/**
	 * @return the registerservice
	 */
	public RegisterService getRegisterservice() {
		return registerservice;
	}





	/**
	 * @param registerservice the registerservice to set
	 */
	public void setRegisterservice(RegisterService registerservice) {
		this.registerservice = registerservice;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}





	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}