package za.ac.cput.domain;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
@DiscriminatorValue("CustomerContact_type")
public class CustomerContact extends Contact {
    @OneToOne
    private BillingAddress billingAddress;

    @OneToOne
    private ShippingAddress shippingAddress;

    protected CustomerContact() {

    }

    private CustomerContact(CustomerContactBuilder customerContactBuilder) {
        super(customerContactBuilder);
        this.shippingAddress = customerContactBuilder.shippingAddress;
        this.billingAddress = customerContactBuilder.billingAddress;
    }



    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerContact that)) return false;
        return Objects.equals(billingAddress, that.billingAddress) && Objects.equals(shippingAddress, that.shippingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingAddress, shippingAddress);
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public static class CustomerContactBuilder extends ContactBuilder{

        private BillingAddress billingAddress;
        private ShippingAddress shippingAddress;

        public CustomerContactBuilder() {
            super();
        }



        public CustomerContactBuilder setBillingAddress(BillingAddress billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public CustomerContactBuilder setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public CustomerContactBuilder copy(CustomerContact contact) {
            super.copy(contact);
            this.shippingAddress = contact.shippingAddress;
            this.billingAddress = contact.billingAddress;
            return this;
        }

        public CustomerContact build(){
            return new CustomerContact(this);

        }
    }
}
