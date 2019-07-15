package cards.management.model.response;

public class CardGenerationResponse {
    private Long number;
    private Integer cvv;
    private Integer pin;

    public CardGenerationResponse(Long number, Integer cvv, Integer pin) {
        this.number = number;
        this.cvv = cvv;
        this.pin = pin;
    }

    public CardGenerationResponse() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
