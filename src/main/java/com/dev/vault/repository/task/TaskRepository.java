package com.dev.vault.repository.task;

import com.dev.vault.model.group.Project;
import com.dev.vault.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByProjectAndTaskName(Project project, String taskName);
}