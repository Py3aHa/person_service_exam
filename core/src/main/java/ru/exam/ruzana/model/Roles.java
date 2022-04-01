package ru.exam.ruzana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements GrantedAuthority {
    private Long id;

    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
