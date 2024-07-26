package za.ac.cput.domain;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import java.io.Serializable;
import java.util.Objects;

@Deprecated
public class AddressId implements Serializable {

    private String postalCode ;
    private String street;

    public AddressId() {
    }

    public AddressId(String postalCode, String street) {
        this.postalCode = postalCode;
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressId addressId = (AddressId) o;
        return Objects.equals(postalCode, addressId.postalCode) && Objects.equals(street, addressId.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, street);
    }
}
