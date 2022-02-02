package simplebook.simpleshop.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import simplebook.simpleshop.Domain.User;
import simplebook.simpleshop.Repository.UserRepository;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {
        //Given
        User user = new User();
        user.setUserName("bryn");
        //When
        Long saveId = userService.join(user);
        //Then
        assertEquals(user, userRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        User user1 = new User();
        user1.setUserName("bryn");
        User user2 = new User();
        user2.setUserName("bryn");
        //When
        userService.join(user1);
        userService.join(user2); //예외가 발생해야 한다.
        //Then
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> userService.join(user2));
        assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }

}