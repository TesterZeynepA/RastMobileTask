package pages;

public class PaymentRequest {
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private double amount;

    public PaymentRequest(String cardNumber, String expiryDate, String cvv, double amount) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public double getAmount() {
        return amount;
    }
}