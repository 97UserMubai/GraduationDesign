package systemOa.bean;

public class MessageCount {

    private int normalMessageCount;
    private int importantMessageCount;

    public int getNormalMessageCount() {
        return normalMessageCount;
    }

    public void setNormalMessageCount(int normalMessageCount) {
        this.normalMessageCount = normalMessageCount;
    }

    public int getImportantMessageCount() {
        return importantMessageCount;
    }

    public void setImportantMessageCount(int importantMessageCount) {
        this.importantMessageCount = importantMessageCount;
    }

    public MessageCount() {
        super();
    }

    public MessageCount(int normalMessageCount, int importantMessageCount) {
        this.normalMessageCount = normalMessageCount;
        this.importantMessageCount = importantMessageCount;
    }
}
