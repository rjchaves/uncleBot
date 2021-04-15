package io.rjchaves.login;

public class LoginController {
    private final Loggable loggable;
    private final String user;
    private final String password;
    private final Integer world;

    public LoginController(Loggable loggable, String user, String password, Integer world) {
        this.loggable = loggable;
        this.user = user;
        this.password = password;
        this.world = world;
    }


    public void login() {
        loggable.fillUser(user);
        loggable.fillPassword(password);
        loggable.pressButton();
        loggable.selectWorld(world);
    }
}
