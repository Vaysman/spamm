package com.oboz.spam.entrypoint;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spam")
@Data
@NoArgsConstructor
public class SpamProperties {
    String email;
    String password;
    String publicKey;
    String privateKey;
    SpamPropertiesSmtp smtp;
}
