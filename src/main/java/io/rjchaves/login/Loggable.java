package io.rjchaves.login;

public interface Loggable {
    void fillUser(String user);

    void fillPassword(String password);

    void pressButton();

    void selectWorld(Integer world);
}
