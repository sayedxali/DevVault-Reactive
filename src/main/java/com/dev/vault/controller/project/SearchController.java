package com.dev.vault.controller.project;

import com.dev.vault.helper.payload.response.project.SearchResponse;
import com.dev.vault.service.interfaces.project.SearchProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * REST controller for searching projects.
 */

@RestController
@RequestMapping("/api/v1/search_project")
@RequiredArgsConstructor
//@PreAuthorize("hasAnyRole('PROJECT_LEADER', 'TEAM_MEMBER', 'PROJECT_ADMIN')")
public class SearchController {

    private final SearchProjectService searchProjectService;

    /**
     * Returns a list of all projects.
     *
     * @return a ResponseEntity containing a list of SearchResponse objects
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<SearchResponse>>> searchResultForAllProjects() {
        return Mono.just(ResponseEntity.ok().body(searchProjectService.listAllProjects()));
    }


    /**
     * Returns a list of projects that match the provided projectName.
     *
     * @param projectName the name of the project to search for
     * @return a ResponseEntity containing a list of SearchResponse objects
     */
    @GetMapping("/{projectName}")
    public ResponseEntity<List<SearchResponse>> searchForAProject(@PathVariable String projectName) {
        return ResponseEntity.ok(searchProjectService.searchForProject(projectName));
    }

}
