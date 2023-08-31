package com.exampleInterface;


public class CreditCard implements PaymentMethod {
 private String cardNumber;
 private String cardHolder;

 public CreditCard(String cardNumber, String cardHolder) {
     this.cardNumber = cardNumber;
     this.cardHolder = cardHolder;
 }

 @Override
 public void processPayment(double amount) {
     System.out.println("Processing credit card payment of $" + amount +
                        " using card ending in " + cardNumber.substring(cardNumber.length() - 4));
 }
}
