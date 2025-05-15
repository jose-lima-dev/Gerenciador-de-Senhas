package controller;

import service.AuthService;

public class AuthController {
    private final AuthService authService = new AuthService();

    public boolean login() {
        return authService.autenticarUsuario();
    }
}
