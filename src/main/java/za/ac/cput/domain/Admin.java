package za.ac.cput.domain;

import jakarta.persistence.*;



import java.util.Objects;


@Entity
public class Admin extends User {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Long employeeId;

    public Admin() {

    }

    public Admin(AdminBuilder builder) {

        this.employeeId=builder.employeeId;
        this.name = builder.name;
        this.password = builder.password;
        this.contact=builder.contact;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin admin)) return false;
        return Objects.equals(employeeId, admin.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "employeeId=" + employeeId +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                '}';
    }

    public static class AdminBuilder {
        private Long employeeId;
        private String password;

        private Name name;
        private  Contact contact;

        public AdminBuilder() {
        }

        public AdminBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public AdminBuilder setEmployeeId(Long employeeId) {
            this.employeeId = employeeId;
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
            this.employeeId=admin.employeeId;
            this.name=admin.name;
            this.contact=admin.contact;
            this.password=admin.password;
            return this;
        }

        public  Admin build (){return new Admin(this);}

    }


}
