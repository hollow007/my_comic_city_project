
//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_project

package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


import java.time.LocalTime;
import java.util.Objects;

@Entity
@DiscriminatorValue("shippingAddress_type")
public class ShippingAddress extends Address{

    private static final Address.AddressBuilder AddressBuilder = new AddressBuilder();
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
                "preffered_delivery_time='" + preffered_delivery_time + '\'' +
                '}'+ super.toString();
    }


    public static class ShippingAddressBuilder extends AddressBuilder{
        protected LocalTime preffered_delivery_time;



        @Override
        public ShippingAddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        @Override
        public ShippingAddressBuilder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        @Override
        public ShippingAddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public ShippingAddressBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public ShippingAddressBuilder setPreffered_delivery_time(LocalTime preffered_delivery_time) {
            this.preffered_delivery_time = preffered_delivery_time;
            return this;
        }


        public ShippingAddressBuilder copy (ShippingAddress o){
            this.street = o.street;
            this.suburb = o.suburb;
            this.postalCode = o.postalCode;
            this.city = o.city;
            this.preffered_delivery_time = o.preffered_delivery_time;
            return this;

        }

        public ShippingAddress build (){return new ShippingAddress(this);}

    }
}
