package dao;

import java.io.File;

public interface IMGDao {
    public String getIMG(String filename) throws Exception;
    public String getProfile(String filename)throws Exception;
    public void saveIMG(String filename,File file,String description) throws Exception;
}
