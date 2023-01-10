package com.beaconfire.timesheet.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String secretKey;
    private Integer expiration;
}
