package com.ra.spring_base_template.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtResponse {
    private String accessToken;
    private final String type = "Bearer";
    @JsonIgnoreProperties({"roles","password"})
//    private User user;
    private Set<String> roles;
}
