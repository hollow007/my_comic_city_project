
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
    private Long shippingAdressid ;
    private LocalTime preffered_delivery_time;


    public ShippingAddress() {}

    private ShippingAddress(ShippingAddressBuilder builder)  {
        super(builder);
        this.shippingAdressid = builder.shippingAdressid;
        this.preffered_delivery_time = builder.preffered_delivery_time;
    }

    public LocalTime getPreffered_delivery_time() {
        return preffered_delivery_time;
    }
    public Long getShippingAdressid(){return shippingAdressid;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShippingAddress that = (ShippingAddress) o;
        return Objects.equals(shippingAdressid, that.shippingAdressid) && Objects.equals(preffered_delivery_time, that.preffered_delivery_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shippingAdressid, preffered_delivery_time);
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                ", shippingAddressid= " + shippingAdressid +
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
        protected Long shippingAdressid;


        public ShippingAddressBuilder setPreffered_delivery_time(LocalTime preffered_delivery_time) {
            this.preffered_delivery_time = preffered_delivery_time;
            return this;
        }

        public ShippingAddressBuilder setShippingAdressid(Long shippingAdressid) {
            this.shippingAdressid = shippingAdressid;
            return this;
        }

        public ShippingAddressBuilder copy (ShippingAddress o){
            this.shippingAdressid = o.shippingAdressid;
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
