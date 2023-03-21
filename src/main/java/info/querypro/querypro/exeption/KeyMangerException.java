package info.querypro.querypro.exeption;

/**
 * 키매니저 오류.
 *
 * @author : 임태원
 * @since : 1.0
 **/
public class KeyMangerException extends RuntimeException {
    public static final String MESSAGE = "키매니저가 뱉는 오류입니다 : ";

    public KeyMangerException(String message) {
        super(MESSAGE + message);
    }
}
