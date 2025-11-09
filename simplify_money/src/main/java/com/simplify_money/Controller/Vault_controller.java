package com.simplify_money.Controller;

import com.simplify_money.Model.Vault;
import com.simplify_money.Service.vault_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vault")
public class Vault_controller {

    @Autowired
    private vault_service vaultService;

    @GetMapping("/user/{userId}")
    public List<Vault> getVault(@PathVariable String userId) {
        return vaultService.getVaultByUserId(userId);
    }
}
