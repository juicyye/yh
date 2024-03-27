package hellojpa.jpabook.hello;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String zipcode;
    private String street;

    public Address() {
    }
}
