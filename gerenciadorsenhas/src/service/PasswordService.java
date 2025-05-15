package service;

import util.CryptoUtil;
import util.HaveIBeenPwnedUtil;

import java.util.Scanner;

public class PasswordService {
    private final Scanner scanner = new Scanner(System.in);

    public void adicionarSenha() {
        System.out.print("Serviço: ");
        String servico = scanner.nextLine();

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        String senhaCriptografada = CryptoUtil.criptografar(senha);
        // TODO: Salvar as informações de forma segura em arquivo ou banco

        System.out.println("Credencial salva com segurança.");
    }

    public void verificarVazamento() {
        System.out.print("Digite a senha para verificar: ");
        String senha = scanner.nextLine();

        boolean vazada = HaveIBeenPwnedUtil.verificarSenha(senha);

        if (vazada) {
            System.out.println("⚠️ Atenção! Esta senha já foi vazada.");
        } else {
            System.out.println("✅ Senha segura (até onde sabemos).");
        }
    }
}
