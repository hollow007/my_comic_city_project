package za.ac.cput.domain;

//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

import jakarta.persistence.*;

import java.util.Objects;

// What have  I done ,  I have changed the address class  and made it into  a Pojo
// The Billing Address and shipping Address will then Inherit from this class excluding the ID
// I changed to change the address back into an Entity because Address contact maps it
// I have made the address class to use Joined Table. This will make the Children Inherit the primary key as a foreign key



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    Address(AddressBuilder<?> builder) {
        this.street = builder.street;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }


    public  Long getId(){return id;}

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

    public static abstract class AddressBuilder<T extends AddressBuilder<T>>{
        protected String street;
        protected String suburb;
        protected String city;
        protected String postalCode;

    
        public T setStreet(String street) {
            this.street = street;
            return self();
        }

        public T setSuburb(String suburb) {
            this.suburb = suburb;
            return self();
        }

        public T setCity(String city) {
            this.city = city;
            return self();
        }

        public T setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return self();
        }

        public T copy(Address address) {
            this.street = address.street;
            this.suburb = address.suburb;
            this.city = address.suburb;
            this.postalCode = address.postalCode;
            return self();
        }

        protected abstract T self();

        public abstract Address build();
    }
}
