package hellojpa.jpabook.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;



}
