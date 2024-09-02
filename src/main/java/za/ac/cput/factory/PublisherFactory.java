package za.ac.cput.factory;

import za.ac.cput.domain.Publisher;
import za.ac.cput.exception.InvalidArgumentException;
import za.ac.cput.util.Helper;

public class PublisherFactory {

    public static Publisher buildPublisher(Long publisherId, String name, int yearFounded) {
        if (publisherId <= 0) {
            throw new InvalidArgumentException("Publisher ID must be greater than zero");
        }
        if (Helper.isStringNullorEmpty(name)) {
            throw new InvalidArgumentException("Name cannot be null or empty");
        }
        if (Helper.isInvalidInt(yearFounded)) {
            throw new InvalidArgumentException("Year founded must be a valid positive integer");
        }

        return new Publisher.PublisherBuilder()
                .setPublisherId(publisherId)
                .setName(name)
                .setYearFounded(yearFounded)
                .build();
    }

    public static Publisher buildPublisher(String name, int yearFounded) {
        if (Helper.isStringNullorEmpty(name)) {
            throw new InvalidArgumentException("Name cannot be null or empty");
        }
        if (Helper.isInvalidInt(yearFounded)) {
            throw new InvalidArgumentException("Year founded must be a valid positive integer");
        }

        return new Publisher.PublisherBuilder()
                .setName(name)
                .setYearFounded(yearFounded)
                .build();
    }
}
