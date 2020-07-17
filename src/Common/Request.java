package Common;

public class Request {
    private User user1;
    private User user2;
    private boolean isRequestAccepted;

    public Request(User user1,User user2){
        this.user1 = user1;
        this.user2 = user2;
        isRequestAccepted = false;
    }

    public void setRequestAccepted(boolean b){
        this.isRequestAccepted = b;
    }
}
