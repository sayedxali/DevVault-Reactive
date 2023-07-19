package com.dev.vault.repository.user;

import com.dev.vault.model.entity.user.VerificationToken;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface VerificationTokenReactiveRepository extends ReactiveMongoRepository<VerificationToken, Long> {
    Mono<VerificationToken> findByToken(String token);
}