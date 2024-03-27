package hellojpa.jpabook.domain;

import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    @Embedded
    private Address address;
    private DeliveryStatus status;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}