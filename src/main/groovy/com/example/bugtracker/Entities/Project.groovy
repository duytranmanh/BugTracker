package com.example.bugtracker.Entities



class Project implements Serializable{
    private UUID id
    private String name
    private String description
//members
    private Collection<User> admin
    private Collection<User> user
    private Collection<User> dev

    private Collection<Post> postCollection


    Project(Collection<User> admin, Collection<User> user, Collection<User> dev) {
        generateID()
        this.admin = admin
        this.user = user
        this.dev = dev
        postCollection = new ArrayList<>()
    }

    private void generateID() {
        id = UUID.randomUUID();
    }

    Collection<User> getAdmin() {
        return admin
    }

    void setAdmin(Collection<User> admin) {
        this.admin = admin
    }

    Collection<User> getUser() {
        return user
    }

    void setUser(Collection<User> user) {
        this.user = user
    }

    Collection<User> getDev() {
        return dev
    }

    void setDev(Collection<User> dev) {
        this.dev = dev
    }

    Collection<Post> getGetPostCollection() {
        return postCollection
    }

    void setPostCollection(Collection<Post> bugCollection) {
        this.postCollection = bugCollection
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }
}
