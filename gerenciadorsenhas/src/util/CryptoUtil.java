package util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Base64;

public class CryptoUtil {
    private static final String ALGORITMO = "AES";
    private static final String CHAVE_SECRETA = "1234567890123456"; // 16 bytes para AES-128 (substitua por algo seguro!)

    public static String criptografar(String texto) {
        try {
            SecretKeySpec key = new SecretKeySpec(CHAVE_SECRETA.getBytes(), ALGORITMO);
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(texto.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar", e);
        }
    }

    public static boolean validarSenhaMestre(String senha) {
        // Exemplo de hash bcrypt de senha mestre: substitua pelo seu hash real
        String hashSalvo = "$2a$10$B7npGFaG7nh0SXUdhuc0HeUVZkFFB5h8WrJsZxJc85ZPY/oSF6QUy"; 
        return BCrypt.checkpw(senha, hashSalvo);
    }
}
