package edu.wgu.d288_backend.controllers;

import edu.wgu.d288_backend.services.CheckoutService;
import edu.wgu.d288_backend.services.Purchase;
import edu.wgu.d288_backend.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        return checkoutService.placeOrder(purchase);
    }
}