package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

public class HaveIBeenPwnedUtil {
    public static boolean verificarSenha(String senha) {
        try {
            // 1. Gera o hash SHA-1 da senha
            String sha1 = sha1Hex(senha).toUpperCase();
            String prefixo = sha1.substring(0, 5);
            String sufixo = sha1.substring(5);

            // 2. Consulta a API com os 5 primeiros caracteres do hash
            URL url = new URL("https://api.pwnedpasswords.com/range/" + prefixo);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String linha;

            // 3. Verifica se o sufixo aparece na resposta
            while ((linha = in.readLine()) != null) {
                if (linha.startsWith(sufixo)) {
                    in.close();
                    return true;
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println("Erro ao verificar senha: " + e.getMessage());
        }

        return false;
    }

    private static String sha1Hex(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] digest = md.digest(input.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
