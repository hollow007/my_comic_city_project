package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Publisher;
import za.ac.cput.util.Helper;

public class PublisherFactory {
    public static Publisher buildPublisher(long publisherId, String name, int yearFounded){
        if(publisherId<=0 || Helper.isStringNullorEmpty(name) || Helper.isValidInt(yearFounded)
        ){
            return null;
        }
        return new Publisher.PublisherBuilder().setPublisherId(publisherId)
                .setName(name)
                .setYearFounded(yearFounded)
                .build();
    }
}
