package com.dev.vault.repository.user;

import com.dev.vault.model.entity.user.Roles;
import com.dev.vault.model.enums.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface RolesReactiveRepository extends ReactiveMongoRepository<Roles, Long> {
    Flux<Roles> findAllByRoleId(String roleId);
    Mono<Roles> findByRole(Role role);
}