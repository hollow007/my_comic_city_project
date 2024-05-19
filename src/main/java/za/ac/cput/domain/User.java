package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity

public class User {
    @Id
    @GeneratedValue
    private String userName;
    private String firstName ;
    private String lastName;

    public User() {}

    private User (UserBuilder userBulider){
        this.userName = userBulider.userName;
        this.firstName = userBulider.firstName;
        this.lastName = userBulider.lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class UserBuilder{

        protected String userName;
        protected String firstName ;
        protected String lastName;

        public UserBuilder setUsername(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public UserBuilder copy (User o){
            this.userName = o.userName;
            this.firstName = o.firstName;
            this.lastName = o.lastName;
            return this;
        }


        public User build(){return new User(this);}
    }


}
