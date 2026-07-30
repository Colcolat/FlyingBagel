package flyinginc.flyingbagel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlyingBagelApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testHash() {
        org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        System.out.println("HASH MATCHES: " + encoder.matches("1234", "$2a$10$G0N4v9Y6J/r1q8vF5h/t.eO.31M.uX6J0q9vF5h/t.eO.31M.uX6J"));
    }

}
