import com.zxy.springboot.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<Object, User> redisTemplate;
    private User user1;
    @Before
    public void before() {
        user1 = new User();
        user1.setUname("zz");
    }
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("user",user1);
        System.out.println((redisTemplate.opsForValue().get("user")));
    }
}