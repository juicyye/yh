package hellojpa.jpabook.hello;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item{
    private String Author;
    private String isbn;

}
