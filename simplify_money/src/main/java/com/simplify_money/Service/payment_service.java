package com.simplify_money.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplify_money.Model.Payment;
import com.simplify_money.Model.Vault;
import com.simplify_money.Repo.PaymentRepository;
import com.simplify_money.Repo.UserRepository;
import com.simplify_money.Repo.VaultRepository;

@Service
public class payment_service {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private VaultRepository vaultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private gold_price_service goldPriceService;

    public Payment processPayment(String userId, double quantity) {
        
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }

        
        var gold = goldPriceService.getCurrentGoldPrice();
        double rate = gold.getPricePerGram();
        double totalAmount = quantity * rate;

        
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setQuantity(quantity);
        payment.setRate(rate);
        payment.setTotalAmount(totalAmount);
        payment.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        payment.setStatus("completed");

        paymentRepository.save(payment);

        
        Vault vault = new Vault();
        vault.setUserId(userId);
        vault.setQuantity(quantity);
        vault.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        vault.setCurrentValue(quantity * rate);
        vaultRepository.save(vault);

        return payment;
    }
}
