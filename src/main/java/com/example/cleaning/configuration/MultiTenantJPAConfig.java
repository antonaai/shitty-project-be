package com.example.cleaning.configuration;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class MultiTenantJPAConfig {
    @Bean
    public HibernatePropertiesCustomizer multiTenantHibernatePropertiesCustomizer(
            SchemaMultiTenantConnectionProvider connectionProvider,
            CurrentTenantResolverImpl tenantResolver) {

        return (Map<String, Object> hibernateProperties) -> {
            hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, connectionProvider);
            hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantResolver);
            // Forza Hibernate a saltare il rilevamento automatico che causa il NPE
            hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);

            // IMPORTANTE: Se usi PostgreSQL (o altro), forza il dialetto qui
            hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        };
    }
}
