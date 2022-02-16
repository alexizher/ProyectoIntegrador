package co.udea.hero.api.exception;

public class DataNotFoundException extends GeneralRuntimeException{
    public static final long serialVersionUID = 1L;
    public DataNotFoundException(String message){
        super(message);

    }
}
