package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;

import com.SpringProject.SpringBootProject.entity.Books;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "Reports")
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reports_id;
    @ManyToOne
    @JoinColumn(name = "books_id")
    private Books book;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @NotBlank
    @Size(min = 6, max = 150, message = "report should contain minimum 6 and maximum 150 characters! ")
    @Column(name = "description")
    private String description;
    public Reports(){

    }

    public Reports(Books book, User user, String description) {
        this.book = book;
        this.user = user;
        this.description = description;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
