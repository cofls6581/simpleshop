package simplebook.simpleshop.Repository;

import org.springframework.stereotype.Repository;
import simplebook.simpleshop.Domain.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository //스프링 빈으로 등록
public class UserRepository {

    @PersistenceContext
    private EntityManager em; //스프링 부트가 생성한 엔티티매니저 em에 주입

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }
    public List<User> findAll() {
        return em.createQuery("select m from User m", User.class)
                .getResultList();
    }
    public List<User> findByName(String name) {
        return em.createQuery("select u from User u where u.userName = :name",
                User.class)
                .setParameter("name", name)
                .getResultList();
    }
}
