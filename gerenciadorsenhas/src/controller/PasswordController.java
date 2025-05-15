package controller;

import service.PasswordService;
import service.PasswordGenerator;

import java.util.Scanner;

public class PasswordController {
    private final PasswordService passwordService = new PasswordService();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcao;

        do {
            System.out.println("\n---- Menu ----");
            System.out.println("\n1. Adicionar senha");
            System.out.println("2. Gerar senha segura");
            System.out.println("3. Verificar vazamento de senha");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> passwordService.adicionarSenha();
                case 2 -> System.out.println("Senha gerada: " + PasswordGenerator.gerarSenha(16) + "\n");
                case 3 -> passwordService.verificarVazamento();
                case 0 -> System.out.println("Saindo do gerenciador...");
                default -> System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        } while (opcao != 0);
    }
}
