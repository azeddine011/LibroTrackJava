package com.librotrackapp.librotrack.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user_reading_lists")
public class UserReadingList {
    @Id
    @Column(name = "id", updatable = false)
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_at", updatable = false)
    private Date addedAt;

    public UserReadingList() {
        this.addedAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    @PrePersist
    protected void onCreate() {
        addedAt = new Date();
    }

    @Override
    public String toString() {
        return String.format("%s's reading list: %s", user.getUsername(), book.getTitle());
    }
}
