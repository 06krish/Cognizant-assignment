package org.example.MockitoExercise2;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Test
    void verifyExample() {

        PaymentService paymentService = mock(PaymentService.class);

        OrderService orderService = new OrderService(paymentService);

        orderService.placeOrder();

        verify(paymentService, times(1)).processpayment();
        verify(paymentService, atLeastOnce()).processpayment();
        verify(paymentService, atMost(2)).processpayment();
    }
}