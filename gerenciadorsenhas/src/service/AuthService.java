package service;

import util.CryptoUtil;
import util.TwoFactorUtil;

import java.util.Scanner;

public class AuthService {
    private final Scanner scanner = new Scanner(System.in);

    public boolean autenticarUsuario() {
        System.out.print("Digite a senha mestre: ");
        String senha = scanner.nextLine();

        boolean senhaValida = CryptoUtil.validarSenhaMestre(senha);
        if (!senhaValida) {
            return false;
        }

        System.out.print("Digite o código 2FA: ");
        String codigo = scanner.nextLine();

        return TwoFactorUtil.validarCodigo(codigo);
    }
}
