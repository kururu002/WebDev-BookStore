package Manager;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LoginDao;
import dao.UserDao;
import dao.impl.LoginDaoImpl;
import model.User;

public class LoginManagerImpl implements LoginManager {

    private LoginDao logindao;

    public void setLogindao(LoginDaoImpl loginDao) {
        this.logindao = loginDao;
    }

    @Override
    public boolean login(String username, String password) {
        return logindao.login(username, password);
    }

}
