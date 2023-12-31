package com.dev.vault.model.domain.task;

import com.dev.vault.model.domain.relationship.TaskUser;
import com.dev.vault.model.enums.TaskPriority;
import com.dev.vault.model.enums.TaskStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Task {

    @Id
    private String taskId;

    private String taskName;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime completionDate;
    private TaskStatus taskStatus;
    private TaskPriority taskPriority;
    private boolean hasOverdue;

    /* relationships */
    @Transient
    private Set<TaskUser> assignedTaskUser = new HashSet<>();
    private String createdByUserId;
    private String projectId;
    /* end of relationships */

}
