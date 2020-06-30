package com.ITVDN.DFD.entities;

import com.ITVDN.DFD.security.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "_USERS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>(Arrays.asList(Role.USER));

    public void addRole(Role role) {
        roles.add(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "email='" + email + "'";
    }
}
