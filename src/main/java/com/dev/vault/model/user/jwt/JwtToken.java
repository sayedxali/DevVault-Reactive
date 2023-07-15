package com.dev.vault.model.user.jwt;

import com.dev.vault.model.user.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Entity for saving JWT token that has been generated by registration and or authentication/login.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtToken {
    @Id
    private Long jwtTokenId;

    private String token;
    private TokenType type;
    private boolean expired;
    private boolean revoked;

    /* relationships */
    @Transient
    private User user;
    /* end of relationships */

}
