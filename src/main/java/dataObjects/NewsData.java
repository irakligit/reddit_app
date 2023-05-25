package dataObjects;


public class NewsData implements Comparable<NewsData> {
    private final int upVotes, numberOfComments;
    private final String pageName, user, publishName;


    public NewsData(int upVotes, int numberOfComments, String pageName, String user, String publishTime) {
        this.upVotes = upVotes;
        this.numberOfComments = numberOfComments;
        this.pageName = pageName;
        this.user = user;
        this.publishName = publishTime;

    }

    public String getPageName() {
        return pageName;
    }

    public String getUser() {
        return user;
    }

    public String getPublishName() {
        return publishName;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    @Override
    public int compareTo(NewsData newDataObj) {
        return Integer.compare(upVotes,newDataObj.getUpVotes());
    }
}
