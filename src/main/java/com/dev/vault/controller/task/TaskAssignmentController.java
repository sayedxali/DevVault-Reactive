package com.dev.vault.controller.task;

import com.dev.vault.helper.exception.DevVaultException;
import com.dev.vault.helper.exception.NotLeaderOfProjectException;
import com.dev.vault.helper.exception.NotMemberOfProjectException;
import com.dev.vault.helper.exception.ResourceNotFoundException;
import com.dev.vault.helper.payload.response.ApiResponse;
import com.dev.vault.helper.payload.response.task.TaskResponse;
import com.dev.vault.service.interfaces.task.TaskAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * REST Controller for assigning tasks services.
 */
@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
// @PreAuthorize("hasAnyRole('PROJECT_LEADER','PROJECT_ADMIN')")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;


    /**
     * Assigns a task to a list of users in the project.
     *
     * @param taskId     the ID of the task to assign
     * @param projectId  the ID of the project the task belongs to
     * @param userIdList the list of user IDs to assign the task to
     * @return a {@link Mono} of {@link ResponseEntity} with an OK HTTP status code and a map of responses for each assigned user.
     * @throws DevVaultException           If the task does not belong to the project.
     * @throws NotLeaderOfProjectException If the current user is not a leader or admin of the project.
     * @throws ResourceNotFoundException   If the task or project is not found.
     */
    @PostMapping("/assignTask")
    public Mono<ResponseEntity<TaskResponse>> assignTaskToUsers(
            @RequestParam("taskId") String taskId,
            @RequestParam("projectId") String projectId,
            @RequestBody List<String> userIdList
    ) throws ResourceNotFoundException, NotLeaderOfProjectException, DevVaultException {
        return taskAssignmentService.assignTaskToUsers(taskId, projectId, userIdList)
                .map(ResponseEntity::ok);
    }


    /**
     * Assigns a task to all users in a project.
     *
     * @param taskId    the ID of the task to assign
     * @param projectId the ID of the project that the task belongs to
     * @return a ResponseEntity containing a TaskResponse object and an HTTP status code
     */
    @PostMapping("/assignTask/all")
    public Mono<ResponseEntity<TaskResponse>> assignTaskToAllUserInProject(
            @RequestParam("taskId") String taskId,
            @RequestParam("projectId") String projectId
    ) {
        return taskAssignmentService.assignTaskToAllUsersInProject(taskId, projectId)
                .map(ResponseEntity::ok);
    }


    /**
     * Unassigns a task from a user in a given project.
     *
     * @param taskId    the ID of the task to unassign
     * @param projectId the ID of the project containing the task
     * @param userId    the ID of the user to unassign the task from
     * @return a {@code Mono<ResponseEntity<ApiResponse>>} that completes when the task has been unassigned
     * @throws ResourceNotFoundException   if the task, project or the user with the given ID is not found.
     * @throws NotMemberOfProjectException if the current user is not a member of the project.
     * @throws NotLeaderOfProjectException if the current user is not the leader or admin of the project.
     */
    @DeleteMapping("/unassignTask")
    public Mono<ResponseEntity<ApiResponse>> unassignTaskFromUser(
            @RequestParam("taskId") String taskId,
            @RequestParam("projectId") String projectId,
            @RequestParam("userId") String userId
    ) throws ResourceNotFoundException, NotLeaderOfProjectException, NotMemberOfProjectException {
        return taskAssignmentService.unAssignTaskFromUser(taskId, projectId, userId)
                .then(Mono.just(ResponseEntity.ok(new ApiResponse("Task unassigned successfully.", true))));
    }
//
//    */
///**
// * Unassigns a task from a list of users.
// *
// * @param taskId    the ID of the task to unassign
// * @param projectId the ID of the project the task belongs to
// * @param userIdList    the IDs of the users to unassign the task from
// * @return a ResponseEntity with an OK HTTP status code
// *//*
//
//    @DeleteMapping("/unassignTask/multiple/users") //TODO
//    public ResponseEntity<Void> unassignTaskFromUsers(
//            @RequestParam("taskId") Long taskId,
//            @RequestParam("projectId") Long projectId,
//            @RequestBody List<Long> userIdList
//    ) {
////        taskService.unassignTaskFromUser(taskId, projectId, userId);
////        return ResponseEntity.ok().build();
//        return null;
//    }
//
//    */
///**
// * Unassigns a task from a all users in a project.
// *
// * @param taskId    the ID of the task to unassign
// * @param projectId the ID of the project the task belongs to
// * @return a ResponseEntity with an OK HTTP status code
// *//*
//
//    @DeleteMapping("/unassignTask/all") //TODO
//    public ResponseEntity<Void> unassignTaskFromAllUsersInProject(
//            @RequestParam("taskId") Long taskId,
//            @RequestParam("projectId") Long projectId
//    ) {
////        taskService.unassignTaskFromUser(taskId, projectId, userId);
////        return ResponseEntity.ok().build();
//        return null;
//    }
//}
//*/
}
