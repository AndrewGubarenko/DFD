package com.ITVDN.DFD.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
@Getter
@Setter
@NoArgsConstructor
public class Administrator extends User {

    @Override
    public String toString() {
        return "Administrator{" + super.toString() + "}";
    }

}
