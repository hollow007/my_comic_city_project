package za.ac.cput.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
@DiscriminatorValue("AdminContact_type")
public class AdminContact extends Contact {
    @OneToOne
    private Address address;

    public AdminContact() {

    }

    protected AdminContact(AdminContactBuilder builder) {
        super(builder);
        this.address = builder.address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminContact that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address);
    }

    @Override
    public String toString() {
        return "AdminContact{" +
                "address=" + address +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public static class AdminContactBuilder extends ContactBuilder {
        private Address address;

        public AdminContactBuilder() {
            super();
        }

        public AdminContactBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public AdminContactBuilder copy(AdminContact adminContact) {
            super.copy(adminContact);
            this.address = adminContact.address;
            return this;
        }
        public AdminContact build(){
            return new AdminContact(this);
        }

    }


}
