package com.example.cleaning.configuration;

import com.example.cleaning.context.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CurrentTenantResolverImpl  implements CurrentTenantIdentifierResolver<String> {
    static final String DEFAULT_TENANT = "public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        // Prende il tenant dal TenantContext
        return  Objects.requireNonNullElse(TenantContext.getTenant(), DEFAULT_TENANT);
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        // true: Hibernate può riutilizzare le sessioni esistenti
        return true;
    }
}
