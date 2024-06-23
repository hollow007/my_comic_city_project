
//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_projec


package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
@DiscriminatorValue("BillingAddress_type")
public class BillingAddress extends Address{

    private String paymentMethod;
    public BillingAddress(){
    }

    private BillingAddress(BillingAddressBuilder builder){
        super(builder);
        this.paymentMethod = builder.paymentMethod;

    }


    public String getPaymentMethod() {
        return paymentMethod;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BillingAddress that = (BillingAddress) o;
        return Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paymentMethod);
    }

    @Override
    public String toString() {
        return "BillingAdress{" +
                "paymentMethod='" + paymentMethod + '\'' +
                "Street='" + super.toString()+ '\'' +
                '}';

    }

    public static class BillingAddressBuilder extends AddressBuilder{
        public BillingAddressBuilder() {
            super();
        }

        protected String paymentMethod;

        public BillingAddressBuilder setPaymentMethod (String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }


        public BillingAddressBuilder copy (BillingAddress  o){
            this.street = o.street;
            this.suburb = o.suburb;
            this.postalCode = o.postalCode;
            this.city = o.city;
            this.paymentMethod = o.paymentMethod;
            return this;

        }

        public BillingAddress build (){return new BillingAddress(this);}

    }
}
