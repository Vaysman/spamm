package com.oboz.spam.entrypoint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpamPropertiesSmtp {
    private String auth;
    private String starttlsEnable;
    private String host;
    private String port;
}
