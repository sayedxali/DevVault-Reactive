package com.dev.vault.model.group;

import com.dev.vault.model.user.User;
import com.dev.vault.model.user.enums.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // manager the relationships between group and its members
@Table(name = "project_members")
public class ProjectMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectMemberId;

    /* relationships */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;
    /* end of relationships */

    private Roles role;

    public ProjectMembers(User user, Project project, Roles role) {
        this.user = user;
        this.project = project;
        this.role = role;
    }
}
