package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.domain.User.UserBuilder;

public class UserFactory {

    public static User createUser(String userName, String firstName, String lastName) {
        UserBuilder userBuilder = new UserBuilder();
        User user = userBuilder
                .setUsername(userName)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();
        return user;
    }

    public static User createUser(User user) {
        UserBuilder userBuilder = new UserBuilder();
        User newUser = userBuilder
                .copy(user)
                .build();
        return newUser;
    }
}