package pages;

public class PaymentResponse {
    private String status;

    public PaymentResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
