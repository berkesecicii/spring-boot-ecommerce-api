package edu.wgu.d288_backend.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}