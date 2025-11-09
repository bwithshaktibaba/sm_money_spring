package com.simplify_money.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "payments")
@Data
public class Payment {
    @Id
    private String id;
    private String userId;
    private double quantity;
    private double rate;
    private double totalAmount;
    private String timestamp;
    private String status;
}
