package kz.diploma.auth.service.model.enums;

public enum Roles {
    CLIENT("CLIENT"), ADMIN("ADMIN");

    public final String name;

    Roles(String name) {
        this.name = name;
    }
}
