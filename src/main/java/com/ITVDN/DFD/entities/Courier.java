package com.ITVDN.DFD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DiscriminatorValue("COURIER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Courier extends User{

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSPORT_TYPE")
    private TransportType transportType;

    @Override
    public String toString() {
        return "Courier{" +
                super.toString() + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", transportType=" + transportType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;
        if (!super.equals(o)) return false;
        Courier courier = (Courier) o;
        return name.equals(courier.name) &&
                surname.equals(courier.surname) &&
                phone.equals(courier.phone) &&
                transportType == courier.transportType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, phone, transportType);
    }
}
