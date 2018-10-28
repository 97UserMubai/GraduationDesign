package systemOa.bean;

public class FileBean {

    private  String fileId;
    private  String filePerson;
    private String fileName;
    private String fileDepartment;
    private String fileTime;
    private String fileSource;
    private String fileStatus;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilePerson() {
        return filePerson;
    }

    public void setFilePerson(String filePerson) {
        this.filePerson = filePerson;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileTime() {
        return fileTime;
    }

    public void setFileTime(String fileTime) {
        this.fileTime = fileTime;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public String getFileDepartment() {
        return fileDepartment;
    }

    public void setFileDepartment(String fileDepartment) {
        this.fileDepartment = fileDepartment;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public FileBean(){super();}

    public FileBean(String filePerson, String fileName, String fileDepartment, String fileTime, String fileSource, String fileStatus) {
        this.filePerson = filePerson;
        this.fileName = fileName;
        this.fileDepartment = fileDepartment;
        this.fileTime = fileTime;
        this.fileSource = fileSource;
        this.fileStatus = fileStatus;
    }
}
