
//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_projec

// After implementing The inheritance strategy , this subclass will not need us to define a primary key , we will inherit it

package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(name = "BillingAddressID")
public class BillingAddress extends Address{

    private String paymentMethod;

    public BillingAddress(){
        super();
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
        return "BillingAddress{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
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


        public BillingAddressBuilder copy (BillingAddress  billingAddress){
            this.street = billingAddress.street;
            this.suburb = billingAddress.suburb;
            this.postalCode = billingAddress.postalCode;
            this.city = billingAddress.city;
            this.paymentMethod = billingAddress.paymentMethod;
            return this;

        }

        public BillingAddress build (){return new BillingAddress(this);}

    }
}
