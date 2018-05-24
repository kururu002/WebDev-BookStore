package dao.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class IMGDaoImpl implements dao.IMGDao {
    private MongoClient mongoClient;
       public String getIMG(String filename) throws Exception {
//           ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//           MongoClient client = (MongoClient) context.getBean("mongoClient");
           GridFS gridFS = new GridFS(mongoClient.getDB("bookstore"));
           GridFSDBFile out =gridFS.findOne( new BasicDBObject( "filename" , filename) );
           if(out==null) return null;
           InputStream is = out.getInputStream();
           byte[] bytes = IOUtils.toByteArray(is);
           String ecstring= java.util.Base64.getEncoder().encodeToString(bytes);
//           System.out.println("DMN0");
//           System.out.println(ecstring);
           return ecstring;
       }
       public String getProfile(String filename)throws Exception{
           GridFS gridFS = new GridFS(mongoClient.getDB("bookstore"));
           GridFSDBFile out =gridFS.findOne( new BasicDBObject( "filename" , filename) );
           if(out==null) return null;
           InputStream is = out.getInputStream();
           byte[] bytes = IOUtils.toByteArray(is);
           return new String(bytes,"utf-8");
       }
       public void saveIMG(String filename,File file,String description) throws Exception{
           GridFS gridFS = new GridFS(mongoClient.getDB("bookstore"));
           
           if(file!=null){
               gridFS.remove(filename);
               InputStream is = new FileInputStream(file);
               GridFSInputFile in = gridFS.createFile(is,filename);  
               in.save();
           }
           
           if(!description.isEmpty()){
           System.out.println(description);
           gridFS.remove(filename+"des");
           InputStream stream = new ByteArrayInputStream(description.getBytes(StandardCharsets.UTF_8));      
           GridFSInputFile in=gridFS.createFile(stream, filename+"des");
           in.save();
           }
       }
    /**
     * @return the mongoClient
     */
    public MongoClient getMongoClient() {
        return mongoClient;
    }
    /**
     * @param mongoClient the mongoClient to set
     */
    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
}
