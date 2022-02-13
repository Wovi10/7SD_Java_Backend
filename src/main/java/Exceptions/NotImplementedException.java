package Exceptions;

public class NotImplementedException extends RuntimeException{
    public NotImplementedException(){
        super("This method has not yet been implemented");
    }
}
