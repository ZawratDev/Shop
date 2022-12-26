package payments;

import org.junit.jupiter.api.Test;
import payments.exceptions.PaymentFailure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentManagerTest {

    @Test
    void redirectToPaymentProviderWhenTransactionSumIsIntReturnsSuccess() {
        var paymentManager = new PaymentManager()
                .createNewPayment();
        assertEquals(PaymentStatus.SUCCESS, paymentManager
                .redirectToPaymentProvider(10));
    }

    @Test
    void redirectToPaymentProviderWhenTransactionSumIsDecimalReturnsSuccess() {
        var paymentManager = new PaymentManager()
                .createNewPayment();
        assertEquals(PaymentStatus.SUCCESS, paymentManager
                .redirectToPaymentProvider(0.1));
    }
    @Test
    void redirectToPaymentProviderWhenTransactionSumIsNegativeReturnsFAILED() {
        var paymentManager = new PaymentManager()
                .createNewPayment();
        assertEquals(PaymentStatus.FAILED, paymentManager
                .redirectToPaymentProvider(-1));
    }
    @Test
    void redirectToPaymentProviderWhenTransactionSumEqualsZeroReturnsFAILED() {
        var paymentManager = new PaymentManager()
                .createNewPayment();
        assertEquals(PaymentStatus.FAILED, paymentManager
                .redirectToPaymentProvider(0));
    }
}
