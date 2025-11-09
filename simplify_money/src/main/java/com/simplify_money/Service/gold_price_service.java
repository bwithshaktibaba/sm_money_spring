package com.simplify_money.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplify_money.Model.Gold;
import com.simplify_money.Repo.GoldRepository;

@Service
public class gold_price_service {

    @Autowired
    private GoldRepository goldRepository;

    public Gold getCurrentGoldPrice() {
        Gold gold = new Gold();
        gold.setPricePerGram(5000.0);
        gold.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        goldRepository.save(gold);
        return gold;
    }
}
