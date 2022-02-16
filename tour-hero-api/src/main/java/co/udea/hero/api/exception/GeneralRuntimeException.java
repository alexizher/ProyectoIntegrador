package co.udea.hero.api.exception;

public class GeneralRuntimeException extends  RuntimeException{

    public static final long serialVersionUID = 1L;

    private String message;
    private String translationKey;

    public GeneralRuntimeException(String message){
        super(message);
        this.message = message;
    }

    public GeneralRuntimeException(String message, Throwable throwable){
        super(message, throwable);
        this.message = message;
    }

    public GeneralRuntimeException(String message, String translationKey){
        super(message);
        this.message = message;
        this.translationKey = translationKey;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
