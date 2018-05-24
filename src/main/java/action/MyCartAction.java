package action;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

import model.Book;
import model.Order;
import model.Orderitem;
import service.AppService;

public class MyCartAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    private AppService appService;
    private int userid;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {
        if(session().getAttribute("uid")==null||session().getAttribute("uid")==""){return LOGIN;};
        int uid = (Integer) session().getAttribute("uid");
        
        Order foundhisorder = appService.getOrderByStatus(0, uid);
        // System.out.println("UID:");
        // System.out.println(uid);
        if (foundhisorder == null)
            return ERROR;
        List<String>IMGs=new ArrayList<String>();
        List<Book> books = new ArrayList<Book>();
        // List<Integer> amounts=new ArrayList<Integer>();
        Set<Orderitem> orderitemset = foundhisorder.getOrderitems();
        List<Orderitem> orderitems = new ArrayList<Orderitem>();
        orderitems.addAll(orderitemset);
        Iterator iterator = orderitems.iterator();
        //System.out.println("DMN0");
        while (iterator.hasNext()) {
            Orderitem item = (Orderitem) iterator.next();
            int itemBookId = item.getBookid();
            Book addingbook = appService.getBookById(itemBookId);
            books.add(addingbook);
            //System.out.println("DMN1");
            // amounts.add(item.getAmount());
            
            IMGs.add(appService.getIMG(addingbook.getTitle()));
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            out.writeTo(baos);
//            byte[] bytes = baos.toByteArray();
//            IMGs.add(bytes);
//            System.out.println(out);
//            System.out.println(bytes);
         // writes out correctly
//            OutputStream oot=new OutputStream();
//            out.writeTo("D:\\test1.JPG");

           
            

        }

        request().setAttribute("books", books);
        request().setAttribute("orderitems", orderitems);
        request().setAttribute("myorder", foundhisorder);
        request().setAttribute("IMGs",IMGs);
        // request().setAttribute("amounts", amounts);
        // System.out.println("POOz:");
        return SUCCESS;
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
}
