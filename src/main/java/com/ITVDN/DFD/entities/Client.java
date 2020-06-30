package com.ITVDN.DFD.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("CLIENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends User{

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "NAME")
    private String name;

    @Override
    public String toString() {
        return "Client{" +
                super.toString() + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return address.equals(client.address) &&
                phone.equals(client.phone) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, phone, name);
    }
}
