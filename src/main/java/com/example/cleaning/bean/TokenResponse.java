package com.example.cleaning.bean;

public record TokenResponse(String accessToken, String refreshToken,
                            String userId, String userEmail, String userName, String companyName,
                            String tenantId, String companyId) {}