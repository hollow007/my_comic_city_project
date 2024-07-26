
//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_projec


package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class BillingAddress extends Address{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    public Long getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillingAddress that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paymentMethod , id);
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", id=" + id +
                ", street='" + street + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
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
