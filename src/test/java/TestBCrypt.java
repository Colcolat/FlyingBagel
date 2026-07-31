import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestBCrypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = "$2a$10$G0N4v9Y6J/r1q8vF5h/t.eO.31M.uX6J0q9vF5h/t.eO.31M.uX6J";
        boolean matches = encoder.matches("1234", hash);
        System.out.println("Matches: " + matches);
    }
}
