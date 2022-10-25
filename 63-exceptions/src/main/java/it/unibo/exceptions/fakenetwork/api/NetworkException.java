package it.unibo.exceptions.fakenetwork.api;
import java.io.IOException;

public class NetworkException extends IOException{
    private String message;

    public NetworkException(){
        super("Network error: no response");
    }

   
    public NetworkException(String msg){
        super("Network error while sending message " + msg);
    }
}
