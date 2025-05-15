package util;

public class TwoFactorUtil {
    private static final String CODIGO_2FA_FIXO = "123456"; // Simulação (pode ser gerado dinamicamente depois)

    public static boolean validarCodigo(String codigo) {
        return CODIGO_2FA_FIXO.equals(codigo);
    }
}
