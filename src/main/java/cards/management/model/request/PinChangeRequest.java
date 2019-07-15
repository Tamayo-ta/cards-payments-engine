package cards.management.model.request;

public class PinChangeRequest {
    private Integer oldPin;
    private Integer ownerId;
    private Integer newPin;
    private Long number;

    public PinChangeRequest(Integer oldPin, Integer ownerId, Integer newPin, Long number) {
        this.oldPin = oldPin;
        this.ownerId = ownerId;
        this.newPin = newPin;
        this.number = number;
    }

    public PinChangeRequest() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getOldPin() {
        return oldPin;
    }

    public void setOldPin(Integer oldPin) {
        this.oldPin = oldPin;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getNewPin() {
        return newPin;
    }

    public void setNewPin(Integer newPin) {
        this.newPin = newPin;
    }
}
