package com.dev.vault.controller.project;

import com.dev.vault.helper.payload.request.project.JoinProjectDto;
import com.dev.vault.helper.payload.response.project.JoinResponse;
import com.dev.vault.service.interfaces.project.JoinRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.dev.vault.model.enums.JoinStatus.*;


/**
 * REST controller for managing join project requests.
 */
@RestController
@RequestMapping("/api/v1/join_request")
@RequiredArgsConstructor
public class JoinRequestController {

    private final JoinRequestService joinRequestService;


    /**
     * Sends a join project request for the specified project.
     *
     * @param projectId  the ID of the project to send the join project request to
     * @param joinCoupon the coupon that project leader or project admin gave to user
     * @return ResponseEntity containing the JoinResponse object returned by the service
     */
    @PostMapping
    public Mono<ResponseEntity<JoinResponse>> sendJoinRequest(
            @RequestParam String projectId,
            @RequestParam String joinCoupon
    ) {
        return joinRequestService.sendJoinRequest(projectId, joinCoupon)
                .map(ResponseEntity::ok);
    }


    /**
     * Retrieves all join project requests for the specified project with the specified status.
     *
     * @param projectId the ID of the project to retrieve join requests for
     * @return ResponseEntity containing a List of JoinRequest objects with the specified status
     */
//    @PreAuthorize("hasAnyRole('PROJECT_LEADER', 'PROJECT_ADMIN')")
    @GetMapping("/requests")
    public Mono<ResponseEntity<Flux<JoinProjectDto>>> getAllJoinRequestsByStatus(@RequestParam String projectId) {
        Flux<JoinProjectDto> joinRequests = joinRequestService.getJoinRequestsByProjectIdAndStatus(projectId, PENDING);
        return Mono.just(ResponseEntity.ok().body(joinRequests));
    }


    /**
     * Approves the specified join project request.
     *
     * @param joinRequestId the ID of the join project request to approve
     * @return ResponseEntity containing the JoinRequest object after it has been updated
     */
//    @PreAuthorize("hasAnyRole('PROJECT_LEADER', 'PROJECT_ADMIN')")
    @PostMapping("/{joinRequestId}/approve")
    public Mono<ResponseEntity<JoinResponse>> approveJoinRequest(@PathVariable String joinRequestId) {
        return joinRequestService.updateJoinRequestStatus(joinRequestId, APPROVED)
                .map(ResponseEntity::ok);
    }


    /**
     * Rejects the specified join project request.
     *
     * @param joinRequestId the ID of the join project request to reject
     * @return ResponseEntity containing the JoinRequest object after it has been updated
     */
//    @PreAuthorize("hasAnyRole('PROJECT_LEADER', 'PROJECT_ADMIN')")
    @PostMapping("/{joinRequestId}/reject")
    public Mono<ResponseEntity<JoinResponse>> rejectJoinRequest(@PathVariable String joinRequestId) {
        return joinRequestService.updateJoinRequestStatus(joinRequestId, REJECTED)
                .map(ResponseEntity::ok);
    }

}
