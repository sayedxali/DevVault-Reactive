package com.dev.vault.helper.payload.user;

import com.dev.vault.model.group.enums.JoinStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String username;
    private String major;
    private String education;
    private List<String> role;
    private JoinStatus joinStatus;
}
