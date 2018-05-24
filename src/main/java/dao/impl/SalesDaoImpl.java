package dao.impl;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import model.Order;
import model.Orderitem;
import model.User;
import service.LoginService;

public class SalesDaoImpl extends HibernateDaoSupport implements dao.SalesDao {
    @Override
    public int sales(int userid, int bookid) {
    	List<Order> order = (List<Order>)getHibernateTemplate().find("from Order as orders where orders.userid=?",userid);
    	
    	Order userorder = null;
    	for(int i = 0 ; i < order.size() ; i++){
    		if(order.get(i).getUserid()==userid){
    			userorder = order.get(i);
    		}
    	}
    	
    	int amount = 0;
    	
    	if(userorder!=null){
    	    int orderid = userorder.getId();
    	  
    	    
    	    if(bookid == 0){
    	    	
    	    	List<Orderitem> o=(List<Orderitem>)getHibernateTemplate().find("from Orderitem as os where os.orderid=? ",orderid);
    	    	for(int j = 0 ; j < o.size() ; j++){
            		if( o.get(j).getOrderid()==orderid){
            			amount += o.get(j).getAmount();
            		}
            	}
    	    }
    	    else{
    	    	List<Orderitem> o=(List<Orderitem>)getHibernateTemplate().find("from Orderitem as os where os.orderid=? and os.bookid=?",orderid,bookid);
                for(int j = 0 ; j < o.size() ; j++){
        		    if(o.get(j).getBookid()==bookid && o.get(j).getOrderid()==orderid){
        			    amount += o.get(j).getAmount();
        		    }
        	    }
    	    }
    	}
        else{
        	List<Orderitem> o=(List<Orderitem>)getHibernateTemplate().find("from Orderitem as os where os.bookid=?",bookid);
            for(int j = 0 ; j < o.size() ; j++){
        		if(o.get(j).getBookid()==bookid ){
        			amount += o.get(j).getAmount();
        		}
        	}
        }
        
        return amount;
    }

}