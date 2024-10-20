package za.ac.cput.domain;

import jakarta.persistence.*;



import java.util.Objects;
import java.util.Set;


@Entity
@DiscriminatorValue("Admin")
public class Admin extends User {

    protected Admin() {

    }

    public Admin(AdminBuilder builder) {

        this.userId=builder.userId;
        this.name = builder.name;
        this.password = builder.password;
        this.contact=builder.contact;
        this.roles = builder.roles;

        }

    @Override
    public String toString() {
        return "Admin{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                ", roles=" + roles +
                '}';
    }

    public static class AdminBuilder {
        private Long userId;
        private String password;
        private Name name;
        private  Contact contact;
        protected Set<Role> roles;


        public AdminBuilder() {
        }

        public AdminBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public AdminBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }


        public AdminBuilder setRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public AdminBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public AdminBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public AdminBuilder copy(Admin admin){
            this.userId=admin.userId;
            this.name=admin.name;
            this.contact=admin.contact;
            this.password=admin.password;
            this.roles = admin.roles;
            return this;
        }

        public  Admin build (){return new Admin(this);}

    }


}
