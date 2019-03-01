package cards.payment.engine.model.response;

public class AuthoriseResponse {
    private Integer status;
    private String reason;
    private String session;

    public AuthoriseResponse() {
    }

    public AuthoriseResponse(Integer status, String reason, String session) {
        this.status = status;
        this.reason = reason;
        this.session = session;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
