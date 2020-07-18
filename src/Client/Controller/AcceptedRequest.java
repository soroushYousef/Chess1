package Client.Controller;

public class AcceptedRequest {
    public static AcceptedRequest acceptedRequest = new AcceptedRequest();
    private static boolean b = false;
    private AcceptedRequest(){

    }

    public synchronized void setAcceptedRequest(boolean b){
        b = b;
    }

    public synchronized static AcceptedRequest getAcceptedRequest(){
        return acceptedRequest;
    }

    public boolean getb(){
        return b;
    }

}
