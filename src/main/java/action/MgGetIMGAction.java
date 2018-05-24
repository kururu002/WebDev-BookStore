package action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class MgGetIMGAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    @Override
    public String execute() throws Exception {
    ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    MongoClient client = (MongoClient)context.getBean("mongoClient");
    GridFS gridFS = new GridFS(client.getDB("bookstore"));
    InputStream is = new FileInputStream("D:\\User\\T\\HowToAvoidWork.jpg");
    GridFSInputFile in = gridFS.createFile(is,"HowToAvoidWork");
    in.put("meta", 5);  // insert extra metadata here
    in.save();
    //GridFSDBFile out = gridFS.findOne( new BasicDBObject( "filename" , "setting") );
//    System.out.println(out.get("meta")); 
//    System.out.println(out.get("filename")); 
//    System.out.println(out.get("_id")); 
//    DB db=client.getDB("chp");
//    DBCollection collection=db.getCollection("students");
//    collection.insert(new BasicDBObject().append("name", "tan"));
    
    
   System.out.println("DMN");
    return SUCCESS;
    }
}
