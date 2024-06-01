package kz.diploma.auth.service.model.enums;

public enum Roles {
    CLIENT("client"), ADMIN("admin");

    public final String name;

    Roles(String name) {
        this.name = name;
    }
}
