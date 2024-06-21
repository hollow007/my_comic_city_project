
//Joshua Mokwebo
//Student No 222191562
//GitHubRepository:My_commic_city_projec


package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Objects;

@Entity
@DiscriminatorValue("BillingAddress_type")
public class BillingAdress extends Address{

    private String paymentMethod;

    public BillingAdress(){
    }

    private BillingAdress(BillingAdressBuilder builder){
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
        BillingAdress that = (BillingAdress) o;
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

    public static class BillingAdressBuilder extends AddressBuilder{

        protected String paymentMethod;
        protected String invoiceNotes;


        @Override
        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        @Override
        public AddressBuilder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        @Override
        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        @Override
        public AddressBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }


        public BillingAdressBuilder setPaymentMethod (String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public BillingAdressBuilder setInvoiceNotes(String invoiceNotes) {
            this.invoiceNotes = invoiceNotes;
            return this;
        }



        public BillingAdressBuilder copy (BillingAdress  o){
            this.street = o.street;
            this.suburb = o.suburb;
            this.postalCode = o.postalCode;
            this.city = o.city;
            this.paymentMethod = o.paymentMethod;
            return this;

        }

        public BillingAdress build (){return new BillingAdress(this);}

    }
}
