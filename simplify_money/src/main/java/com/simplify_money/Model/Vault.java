package com.simplify_money.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "vaults")
@Data
public class Vault {
    @Id
    private String id;
    private String userId;
    private double quantity;
    private String timestamp;
    private double currentValue;
}
