package com.simplify_money.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplify_money.Model.Vault;
import com.simplify_money.Repo.UserRepository;
import com.simplify_money.Repo.VaultRepository;

@Service
public class vault_service {

    @Autowired
    private VaultRepository vaultRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Vault> getVaultByUserId(String userId) {
        
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        
        return vaultRepository.findByUserId(userId);
    }
}
