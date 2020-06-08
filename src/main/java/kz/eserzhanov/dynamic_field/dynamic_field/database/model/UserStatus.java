package kz.eserzhanov.dynamic_field.dynamic_field.database.model;

public enum UserStatus {
    ACTIVE(1),
    NON_ACTIVE(2),
    DELETED(3);

    private long value;

    UserStatus(long val) {
        this.value = val;
    }

    public long getValue() {
        return value;
    }
}
