package simplebook.simpleshop.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String userName;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders=new ArrayList<>();

}
