package cards.management.model.request;

public class AssignCardRequest {
    private String country;
    private Integer status;
    private Integer ownerId;

    public AssignCardRequest(String country, Integer status, Integer ownerId) {
        this.country = country;
        this.status = status;
        this.ownerId = ownerId;
    }

    public AssignCardRequest() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
