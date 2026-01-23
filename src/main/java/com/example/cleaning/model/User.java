package com.example.cleaning.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "app_user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;

    // relazione molti-a-uno verso Tenant
    @ManyToOne(fetch = FetchType.LAZY) // Lazy è consigliato per evitare join automatici
    @JoinColumn(name = "tenant_id", nullable = false) // il campo nella tabella user
    private Tenant tenant;
}