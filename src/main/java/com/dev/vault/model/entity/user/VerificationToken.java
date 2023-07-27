package com.dev.vault.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class VerificationToken {

    @Id
    private String tokenId;

    private String token;
    private Instant createdAt;
    // TODO: create a expiry date functionality like for 3 hours

    /*mappings*/
    private User user;
    /*end of mappings*/

    public VerificationToken(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
    }
}
