package com.ITVDN.DFD.entities;

import com.ITVDN.DFD.security.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RESTAURANTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private final Role role = Role.RESTAURANT;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
