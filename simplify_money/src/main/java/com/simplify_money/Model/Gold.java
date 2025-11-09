package com.simplify_money.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "gold")
@Data
public class Gold {
    @Id
    private String id;
    private double pricePerGram;
    private String timestamp;
}
