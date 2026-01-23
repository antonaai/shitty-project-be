package com.example.cleaning.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSessionData {
    private String username;
    private String tenant;
}
