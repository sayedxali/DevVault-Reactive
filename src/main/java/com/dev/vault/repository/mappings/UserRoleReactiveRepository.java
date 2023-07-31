package com.dev.vault.repository.mappings;

import com.dev.vault.model.domain.relationship.UserRole;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRoleReactiveRepository extends ReactiveMongoRepository<UserRole, String> {
    Flux<UserRole> findAllByUser_UserId(String userId);

    Mono<UserRole> findByUser_UserIdAndRoles_RoleId(String userId, String roleId);
}
