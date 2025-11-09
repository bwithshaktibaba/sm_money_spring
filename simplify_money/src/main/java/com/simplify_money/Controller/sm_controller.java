package com.simplify_money.Controller;

import com.simplify_money.Model.Gold;
import com.simplify_money.Service.gold_price_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gold")
public class sm_controller {

    @Autowired
    private gold_price_service goldPriceService;

    @GetMapping("/price")
    public Gold getGoldPrice() {
        return goldPriceService.getCurrentGoldPrice();
    }
}
