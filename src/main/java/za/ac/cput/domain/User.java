package za.ac.cput.domain;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
//
//Role Entity
//
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    protected String password;

    @Embedded
    protected Name name;

    @OneToOne()
    protected Contact contact;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    protected Set<Role> roles;

    protected User() {}

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.password = builder.password;
        this.contact = builder.contact;
        this.roles = builder.roles;
    }

    public String getPassword() {
        return password;
    }

    public Long getUserId() {
        return userId;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public String getEmail() {
        return contact.getEmail();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", name=" + name +
                ", contact=" + contact +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(contact, user.contact) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, name, contact, roles);
    }

    public static  class UserBuilder {
        protected Long userId;
        protected Name name;
        protected String password;
        protected Contact contact;
        protected Set<Role> roles;

        public  UserBuilder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.password = user.password;
            this.contact = user.contact;
            this.roles = user.roles;
            return this;
        }

        public UserBuilder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }



        public UserBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public UserBuilder setRoles(Set<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}