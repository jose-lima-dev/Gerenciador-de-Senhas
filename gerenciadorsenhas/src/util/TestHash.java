package util;
import org.mindrot.jbcrypt.BCrypt;

public class TestHash {
    public static void main(String[] args) {
        String senha = "admin123";
        String hash = BCrypt.hashpw(senha, BCrypt.gensalt());
        System.out.println("Hash gerado: " + hash);
    }
}
