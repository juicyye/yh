package hellojpa.jpabook.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();
}
