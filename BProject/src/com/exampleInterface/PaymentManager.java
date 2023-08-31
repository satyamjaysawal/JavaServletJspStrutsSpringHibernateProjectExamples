package com.exampleInterface;

import java.util.List;

public class PaymentManager {
 public void processPayments(List<PaymentMethod> methods, double amount) {
     for (PaymentMethod method : methods) {
         method.processPayment(amount);
     }
 }
}
