package pages;

public class PaymentService {
    private boolean validCreditCard;
    private boolean insufficientBalance;
    private boolean serverError;
    private boolean networkError;
    private boolean browserError;

    public PaymentService() {
        this.validCreditCard = true;
        this.insufficientBalance = false;
        this.serverError = false;
        this.networkError = false;
        this.browserError = false;
    }

    public void setValidCreditCard(boolean validCreditCard) {
        this.validCreditCard = validCreditCard;
    }

    public void setInsufficientBalance(boolean insufficientBalance) {
        this.insufficientBalance = insufficientBalance;
    }

    public void setServerError(boolean serverError) {
        this.serverError = serverError;
    }

    public void setNetworkError(boolean networkError) {
        this.networkError = networkError;
    }

    public void setBrowserError(boolean browserError) {
        this.browserError = browserError;
    }

    public PaymentResponse processPayment(PaymentRequest request) {
        if (!validCreditCard) {
            return new PaymentResponse("INVALID_CARD");
        }

        if (insufficientBalance) {
            return new PaymentResponse("INSUFFICIENT_BALANCE");
        }

        if (serverError) {
            return new PaymentResponse("SERVER_ERROR");
        }

        if (networkError) {
            return new PaymentResponse("NETWORK_ERROR");
        }

        if (browserError) {
            return new PaymentResponse("BROWSER_ERROR");
        }

        return new PaymentResponse("SUCCESS");
    }
}