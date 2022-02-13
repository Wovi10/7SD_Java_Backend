package Exceptions;

public class NoIntegerException extends RuntimeException{
    public NoIntegerException(){
        super("Enter an integer!");
    }
}
