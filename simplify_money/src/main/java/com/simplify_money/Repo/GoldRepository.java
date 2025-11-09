package com.simplify_money.Repo;

import com.simplify_money.Model.Gold;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoldRepository extends MongoRepository<Gold, String> {
}
