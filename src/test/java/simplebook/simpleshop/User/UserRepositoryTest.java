package simplebook.simpleshop.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import simplebook.simpleshop.Domain.User;
import simplebook.simpleshop.Domain.UserRepository;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Test
    public void testUser() throws Exception{
        User user=new User();
        user.setUserName("user1");
        Long saveId = userRepository.save(user);
        User findUser = userRepository.find(saveId);
        Assertions.assertThat(findUser.getId()).isEqualTo(user.getId());
        Assertions.assertThat(findUser.getUserName()).isEqualTo(user.getUserName());
    }
}