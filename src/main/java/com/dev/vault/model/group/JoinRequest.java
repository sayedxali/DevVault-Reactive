package com.dev.vault.model.group;

import com.dev.vault.model.group.enums.JoinStatus;
import com.dev.vault.model.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class JoinRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joinRequestId;

    /* relationships */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    /* end of relationships */

    private JoinStatus status;
}
