package com.example.bugtracker.Entities;


class User implements Serializable {
    private UUID id;
    private String username;
    private String password;

    User(String username, String password) {
        generateID();
        this.username = username;
        this.password = password;
    }

    private void generateID() {
        id = UUID.randomUUID();
    }

    UUID getId() {
        return id;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    boolean equals(User user) {
        if (this.id == user.getId())
            return true
    }
}
