package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.NameFactory;

import java.util.Objects;
import java.util.Random;

@Entity
public class Admin extends User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long employeeId;

    public Admin() {
        super();
    }

    public Admin(AdminBuilder builder) {
        this.name = builder.name;
        this.password = builder.password;
    }

    @Override
    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(employeeId, admin.employeeId) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeId, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "password='" + password + '\'' +
                ", name=" + name +
                '}';
    }

    public static class AdminBuilder extends User{
        public AdminBuilder setFName(String name) {
            this.name = NameFactory.buildFirstName(name);
            return this;
        }

        public AdminBuilder setMName(String name) {
            this.name = NameFactory.buildMiddleName(name);
            return this;
        }

        public AdminBuilder setLName(String name) {
            this.name=NameFactory.buildlastName(name);
            return this;
        }


        public AdminBuilder setName(String firstName, String middleName, String lastName){
            this.name = NameFactory.buildName(firstName, middleName, lastName);
            return this;
        }


        public AdminBuilder setPassword(String password){
            this.password = password;
            return this;
        }


            public  AdminBuilder copy (Admin admin){
            this.password = admin.password;
            return this;
       }

       public  Admin build (){return new Admin(this);}

    }


}
