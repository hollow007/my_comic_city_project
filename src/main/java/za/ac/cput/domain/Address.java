package za.ac.cput.domain;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project


import jakarta.persistence.*;

import java.util.Objects;

// What have  i done ,  I have changed the adress class  and made it into  a Pojo
// The Billing Address and shipping Address will then Inherit from this class excluding the ID 




public class Address {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
=======
    
>>>>>>> release/0.0.0
    protected String street;
    protected String suburb;
    protected String city;
    protected String postalCode;

    public Address() {
    }

    Address(AddressBuilder builder) {
        this.street = builder.street;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
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
        return Objects.equals(street, address.street) && Objects.equals(suburb, address.suburb) && Objects.equals(city, address.city) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, suburb, city, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                ", street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class AddressBuilder {
        protected String street;
        protected String suburb;
        protected String city;
        protected String postalCode;

    
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

<<<<<<< HEAD
        AddressBuilder copy(Address adress) {
            this.id= adress.id;
            this.street = adress.street;
            this.suburb = adress.suburb;
            this.city = adress.suburb;
            this.postalCode = adress.postalCode;
=======
        public AddressBuilder copy(Address address) {
            this.street = address.street;
            this.suburb = address.suburb;
            this.city = address.suburb;
            this.postalCode = address.postalCode;
>>>>>>> release/0.0.0
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
