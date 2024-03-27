package hellojpa.jpabook.jpql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team")
    private List<Member> memberList = new ArrayList<>();



}
