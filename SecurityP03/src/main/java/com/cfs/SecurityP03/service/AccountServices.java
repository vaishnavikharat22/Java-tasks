package com.cfs.SecurityP03.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {

    @PreAuthorize("hasRole('USER')")
    public String getBalance()
    {
        return "Your balance is = 800000";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String closeAccount()
    {
        return "Account closed";
    }

}
