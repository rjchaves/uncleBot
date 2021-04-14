package io.rjchaves.login;

public class LoginController {
    private final Loggable loggable;
    private final String user;
    private final String password;

    public LoginController(Loggable loggable, String user, String password) {
        this.loggable = loggable;
        this.user = user;
        this.password = password;
    }

    public void login() {
        loggable.fillUser(user);
        loggable.fillPassword(password);
        loggable.pressButton();
    }
}
