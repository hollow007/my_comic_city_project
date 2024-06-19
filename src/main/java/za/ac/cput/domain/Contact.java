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
    private Address address;

    protected Contact() {

    }

    private Contact(ContactBuilder contactBuilder) {
        this.email = contactBuilder.email;
        this.mobile = contactBuilder.mobile;
        this.address = contactBuilder.address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Address getAddress() {
        return address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile, address);
    }

    @Override
    public String toString() {
        return "Domain.Contact{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", workTelephone='" + address + '\'' +
                '}';
    }
    public static class ContactBuilder{
        private  String email;
        private  String mobile;
        private Address address;

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

        public ContactBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }
        public ContactBuilder copy(Contact contact) {
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.address = contact.address;
            return this;
        }

        public Contact build(){
            return new Contact(this);

        }
    }
}
