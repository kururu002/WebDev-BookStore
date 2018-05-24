package dao.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.LoginDao;
import model.User;

public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {

    @Override
    public boolean login(String username, String password) {
        List<User> u=this.getHibernateTemplate().find("from User where username=? and password=?",username,password);
        Boolean flag=false;
        User fu=u.get(0);
        if(u.size()>0){
            flag=true;
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("role", fu.getRole());
            session.setAttribute("uid",fu.getId());
        }
        return flag;
    }

}