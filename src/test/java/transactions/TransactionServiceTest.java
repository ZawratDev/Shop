package transactions;

import carts.Cart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import transactions.exceptions.TransactionInWrongState;
import users.User;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
class TransactionServiceTest {
    @Mock
    static User user;
    static Cart cart;

    @Test
    void start_payment_throws_transaction_in_wrong_state_with_NEW_status() {
        var transactionService = new TransactionService();
        transactionService.createTransaction(cart, user);
        assertThrows(TransactionInWrongState.class,
                () -> transactionService.startPayment(transactionService.getTransaction()));
    }
    @Test
    void start_payment_throws_transaction_in_wrong_state_with_FAILED_status() {
        var transactionService = new TransactionService();
        transactionService.createTransaction(cart, user);
        transactionService.getTransaction().setStatus(TransactionStatus.FAILED);
        assertThrows(TransactionInWrongState.class,
                () -> transactionService.startPayment(transactionService.getTransaction()));
    }
    @Test
    void start_Payment_Return() throws TransactionInWrongState {
        var transactionService = new TransactionService();
        transactionService.createTransaction(cart, user);
        transactionService.getTransaction().setStatus(TransactionStatus.IN_PROGRESS);
        transactionService.startPayment(transactionService.getTransaction());
    }
}