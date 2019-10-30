package sample.Authorization;

public class User {
//    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String password;

    public User(String name, String surname, String patronymic, String login, String password) {
//        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
