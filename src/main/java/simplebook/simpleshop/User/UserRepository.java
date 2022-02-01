package simplebook.simpleshop.User;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {

    @PersistenceContext
    private final EntityManager em; //스프링 부트가 em 자동으로 생성해줌

    public Long save(User user){
        em.persist(user);
        return  user.getId();
    }

    public User find(Long id){
        return em.find(User.class,id);
    }
}
