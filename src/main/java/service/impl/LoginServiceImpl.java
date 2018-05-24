package service.impl;

import service.LoginService;
import dao.LoginDao;
import dao.impl.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

    private LoginDao logindao;

    public void setLogindao(LoginDaoImpl loginDao) {
        this.logindao = loginDao;
    }

    @Override
    public boolean login(String username, String password) {
        return logindao.login(username, password);
    }

}