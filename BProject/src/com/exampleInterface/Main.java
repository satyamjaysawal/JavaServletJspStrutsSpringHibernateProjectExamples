package com.exampleInterface;



import java.util.ArrayList;
import java.util.List;

public class Main {
 public static void main(String[] args) {
     PaymentMethod creditCard = new CreditCard("1234-5678-9012-3456", "John Doe");
     PaymentMethod paypal = new PayPal("john@example.com");

     List<PaymentMethod> paymentMethods = new ArrayList<>();
     paymentMethods.add(creditCard);
     paymentMethods.add(paypal);

     PaymentManager paymentManager = new PaymentManager();
     double amount = 100.0;

     paymentManager.processPayments(paymentMethods, amount);
 }
}
