package com.dev.vault.repository.project;

import com.dev.vault.model.entity.project.ProjectMembers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectMembersReactiveRepository extends ReactiveMongoRepository<ProjectMembers, String> {
    Flux<ProjectMembers> findByProjectId(String projectId);

    Mono<ProjectMembers> findByProjectIdAndUserId(String projectId, String userId);

}