package com.dev.vault.repository.group;

import com.dev.vault.model.entity.project.Project;
import com.dev.vault.model.entity.project.ProjectMembers;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectMembersRepository extends ReactiveMongoRepository<ProjectMembers, Long> {
//    @Query("""
//             SELECT p FROM ProjectMembers p
//             WHERE p.project =:project
//            """)
    List<ProjectMembers> findByProject(Project project);

    Optional<ProjectMembers> findByProject_ProjectNameAndUser_Email(String projectName, String email);
}