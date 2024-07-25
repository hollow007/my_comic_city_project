package za.ac.cput.domain;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Address_type", discriminatorType = DiscriminatorType.STRING)


public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String street;
    protected String suburb;
    protected String city;

    protected String postalCode;

    public Address() {
    }

    Address(AddressBuilder builder) {
        this.id=builder.id;
        this.street = builder.street;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(suburb, address.suburb) && Objects.equals(city, address.city) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, suburb, city, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class AddressBuilder {
        protected Long id;
        protected String street;
        protected String suburb;
        protected String city;
        protected String postalCode;

        public AddressBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        AddressBuilder copy(Address adress) {
            this.id= adress.id;
            this.street = adress.street;
            this.suburb = adress.suburb;
            this.city = adress.suburb;
            this.postalCode = adress.postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
