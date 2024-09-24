package za.ac.cput.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
//

//Role Entity
//


@MappedSuperclass
public class User{
    protected String password;
    @Embedded
    protected Name name;
    @OneToOne()
    protected Contact contact;


    public String getPassword() {
        return password;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }



}