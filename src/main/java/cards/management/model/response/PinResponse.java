package cards.management.model.response;

public class PinResponse {
    private Integer code;
    private Integer tryNumber;

    public PinResponse(Integer code, Integer tryNumber) {
        this.code = code;
        this.tryNumber = tryNumber;
    }

    public PinResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(Integer tryNumber) {
        this.tryNumber = tryNumber;
    }
}
