package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;

import model.User;

import org.springframework.data.repository.query.parser.Part;

import com.mongodb.gridfs.GridFSInputFile;

import service.AppService;

public class UploadAction extends BaseAction{
    private static final long serialVersionUID = 1L;
    private AppService appService;
    private String description;
    private File file;
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
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the filePart
     */
    public File getFile() {
        return file;
    }
    /**
     * @param filePart the filePart to set
     */
    public void setFile(File file) {
        this.file = file;
    }
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public String execute() throws Exception {
        int uid = (Integer) session().getAttribute("uid");
        appService.saveIMG(("user"+uid),file,description);
        return SUCCESS;
    }
}
