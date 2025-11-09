package com.simplify_money.Controller;

import com.simplify_money.Model.Payment;
import com.simplify_money.Service.payment_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class payment_controller {

    @Autowired
    private payment_service paymentService;

    @PostMapping("/purchase")
    public Payment purchaseGold(@RequestParam String userId, @RequestParam double quantity) {
        return paymentService.processPayment(userId, quantity);
    }
}
