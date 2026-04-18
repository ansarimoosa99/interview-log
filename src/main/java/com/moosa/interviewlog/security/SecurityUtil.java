package com.moosa.interviewlog.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String getCurrentUserEmail() {
        // Get Logged-in User (from JWT)
        // After JWT validation:Spring stores email in SecurityContex
        return (String) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}