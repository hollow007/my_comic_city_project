
//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

package za.ac.cput.domain;

import jakarta.persistence.*;


import java.time.LocalTime;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name ="ShippingAddress ID")
public class ShippingAddress extends Address{

    private LocalTime preffered_delivery_time;

    public ShippingAddress() {}

    private ShippingAddress(ShippingAddressBuilder builder)  {
        super(builder);
        this.preffered_delivery_time = builder.preffered_delivery_time;
    }

    public LocalTime getPreffered_delivery_time() {
        return preffered_delivery_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShippingAddress that = (ShippingAddress) o;
        return Objects.equals(preffered_delivery_time, that.preffered_delivery_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preffered_delivery_time);
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "preffered_delivery_time=" + preffered_delivery_time +
                ", street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public static class ShippingAddressBuilder extends AddressBuilder{

        public ShippingAddressBuilder() {
            super();
        }

        protected LocalTime preffered_delivery_time;


        public ShippingAddressBuilder setPreffered_delivery_time(LocalTime preffered_delivery_time) {
            this.preffered_delivery_time = preffered_delivery_time;
            return this;
        }


        public ShippingAddressBuilder copy (ShippingAddress builder){
            this.street = builder.street;
            this.suburb = builder.suburb;
            this.postalCode = builder.postalCode;
            this.city = builder.city;
            this.preffered_delivery_time = builder.preffered_delivery_time;
            return this;

        }

        public ShippingAddress build (){return new ShippingAddress(this);}

    }
}
