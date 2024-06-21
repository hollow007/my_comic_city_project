package za.ac.cput.domain;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class Contact {
    @Id
    private  String email;
    private  String mobile;

    @OneToOne
    private BillingAdress billingAdress;

    @OneToOne
    private ShippingAddress shippingAddress;

    protected Contact() {

    }

    private Contact(ContactBuilder contactBuilder) {
        this.email = contactBuilder.email;
        this.mobile = contactBuilder.mobile;
        this.shippingAddress = contactBuilder.shippingAddress;
        this.billingAdress = contactBuilder.billingAdress;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public BillingAdress getBillingAdress() {
        return billingAdress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(billingAdress, contact.billingAdress) && Objects.equals(shippingAddress, contact.shippingAddress);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", billingAdress=" + billingAdress +
                ", shippingAddress=" + shippingAddress +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile, billingAdress, shippingAddress);
    }

    public static class ContactBuilder{
        private  String email;
        private  String mobile;
        private BillingAdress billingAdress;
        private ShippingAddress shippingAddress;

        public ContactBuilder() {
        }


        public ContactBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }


        public ContactBuilder setBillingAdress(BillingAdress billingAdress) {
            this.billingAdress = billingAdress;
            return this;
        }


        public ContactBuilder setShippingAddress(ShippingAddress shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public ContactBuilder copy(Contact contact) {
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.shippingAddress = contact.shippingAddress;
            this.billingAdress = contact.billingAdress;

            return this;
        }

        public Contact build(){
            return new Contact(this);

        }
    }
}
