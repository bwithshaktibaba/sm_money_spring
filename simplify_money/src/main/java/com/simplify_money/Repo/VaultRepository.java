package com.simplify_money.Repo;

import com.simplify_money.Model.Vault;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface VaultRepository extends MongoRepository<Vault, String> {
    List<Vault> findByUserId(String userId);
}
