package com.dev.vault.service.interfaces.task;

import com.dev.vault.helper.exception.ResourceAlreadyExistsException;
import com.dev.vault.helper.exception.ResourceNotFoundException;
import com.dev.vault.helper.payload.request.task.TaskRequest;
import com.dev.vault.helper.payload.response.task.TaskResponse;
import com.dev.vault.model.enums.TaskPriority;
import com.dev.vault.model.enums.TaskStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service interface for managing tasks.
 */
public interface TaskManagementService {

    /**
     * Creates a new task for a given project.
     *
     * @param projectId   the ID of the project to create the task for
     * @param taskRequest the request object containing the details of the task to create
     * @return a TaskResponse object containing the details of the created task
     * @throws ResourceNotFoundException      if the project with the given ID is not found
     * @throws ResourceAlreadyExistsException if a task with the same name already exists in the project
     */
    Mono<TaskResponse> createNewTask(String projectId, TaskRequest taskRequest);

    /**
     * Searches for tasks based on the given criteria.
     *
     * @param status           the status of the tasks to search for (optional)
     * @param priority         the priority of the tasks to search for (optional)
     * @param projectId        the ID of the project that the tasks belong to (optional)
     * @param assignedToUserId the ID of the user that the tasks are assigned to (optional)
     * @return a Flux that emits the task responses that match the search criteria
     */
    Flux<TaskResponse> searchTaskBasedOnDifferentCriteria(TaskStatus status, TaskPriority priority, String projectId, String assignedToUserId);
}
