package stepDefinations;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaymentService;
import pages.PaymentRequest;
import pages.PaymentResponse;
import static org.junit.Assert.assertEquals;

public class PaymentStepDefination {

    private PaymentService paymentService;
    private PaymentRequest paymentRequest;
    private PaymentResponse paymentResponse;

    @Given("the user has a valid credit card")
    public void the_user_has_a_valid_credit_card() {
        paymentService = new PaymentService();
    }

    @Given("the user has an invalid credit card")
    public void the_user_has_an_invalid_credit_card() {
        paymentService = new PaymentService();
        paymentService.setValidCreditCard(false);
    }

    @Given("the user has a valid credit card but insufficient balance")
    public void the_user_has_a_valid_credit_card_but_insufficient_balance() {
        paymentService = new PaymentService();
        paymentService.setInsufficientBalance(true);
    }

    @Given("the user has a valid credit card during a server error")
    public void the_user_has_a_valid_credit_card_during_a_server_error() {
        paymentService = new PaymentService();
        paymentService.setServerError(true);
    }

    @Given("the user has a valid credit card during a network error")
    public void the_user_has_a_valid_credit_card_during_a_network_error() {
        paymentService = new PaymentService();
        paymentService.setNetworkError(true);
    }

    @Given("the user has a valid credit card during a browser error")
    public void the_user_has_a_valid_credit_card_during_a_browser_error() {
        paymentService = new PaymentService();
        paymentService.setBrowserError(true);
    }

    @When("the user attempts to process a payment")
    public void the_user_attempts_to_process_a_payment() {
        paymentRequest = new PaymentRequest("4111111111111111", "12/25", "123", 100.0);
        paymentResponse = paymentService.processPayment(paymentRequest);
    }

    @Then("the payment should be successful")
    public void the_payment_should_be_successful() {
        assertEquals("SUCCESS", paymentResponse.getStatus());
    }

    @Then("the payment should fail with an invalid card error")
    public void the_payment_should_fail_with_an_invalid_card_error() {
        assertEquals("INVALID_CARD", paymentResponse.getStatus());
    }

    @Then("the payment should fail with an insufficient balance error")
    public void the_payment_should_fail_with_an_insufficient_balance_error() {
        assertEquals("INSUFFICIENT_BALANCE", paymentResponse.getStatus());
    }

    @Then("the payment should fail with a server error")
    public void the_payment_should_fail_with_a_server_error() {
        assertEquals("SERVER_ERROR", paymentResponse.getStatus());
    }

    @Then("the payment should fail with a network error")
    public void the_payment_should_fail_with_a_network_error() {
        assertEquals("NETWORK_ERROR", paymentResponse.getStatus());
    }

    @Then("the payment should fail with a browser error")
    public void the_payment_should_fail_with_a_browser_error() {
        assertEquals("BROWSER_ERROR", paymentResponse.getStatus());
    }
}