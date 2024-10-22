package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends User{
    //address missing

    protected Customer() {
    }

    private Customer(CustomerBuilder c) {
        this.name = c.name;
        this.password = c.password;
        this.contact = c.contact;
        this.roles = c.roles;
        this.userId = c.userId;
        this.password = c.password;
        this.roles = c.roles;

    }


    public static class CustomerBuilder{

        private long userId;
        private Name name;
        private String password;
        private Contact contact;
        protected Set<Role> roles;

        public CustomerBuilder() {
        }

        public CustomerBuilder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public CustomerBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }
        public CustomerBuilder setRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public CustomerBuilder copy(Customer c) {

            if(c.getUserId()  != null){
                this.userId = c.getUserId();
            }

            this.name = c.name;
            this.password = c.password;
            this.contact = c.contact;
            this.roles = c.roles;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
