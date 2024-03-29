package com.SpringProject.SpringBootProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.aspectj.weaver.ast.Or;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Books {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long books_id;
    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "Book_Genres",
               joinColumns = @JoinColumn(name = "book_id"),
           inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genres> genres = new HashSet<>() ;

    @ManyToMany
    @JoinTable(name = "Book_Authors"
            , joinColumns = @JoinColumn (name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Authors> authors = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "Book_Languages",
    joinColumns = @JoinColumn(name = "books_id"),
    inverseJoinColumns = @JoinColumn(name = "languages_id"))
    private Set<Languages> languages = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Items_Per_Order",
     joinColumns = @JoinColumn(name = "books_id"),
    inverseJoinColumns = @JoinColumn(name = "Orders_id"))
    private Set<Orders> orders = new HashSet<>();

    @OneToMany(mappedBy = "book")
    private Set<Reports> reports = new HashSet<>();
    @NotNull
    @Size(min = 4, message = "make sure you enter valid year.", max = 4)
    @Column(name = "publishing_year")
    private int publishing_year;
    @NotNull
    @Column(name = "price")
    private int price;
    @NotNull
    @Column(name = "bestseller")
    private boolean bestseller;
    @NotNull
    @Size(min = 13, max = 13, message = "Make sure your isbn number is legit.")
    @Column(name = "isbn")
    private int isbn;
    @NotNull
    @Column(name = "total_pages")
    private int total_pages;
    @NotNull
    @Column(name = "in_stock")
    private boolean in_stock;
    @NotNull
    @Column(name = "availability")
    private boolean availability;

    public Books(){

    }

    public Books(long books_id, String name, Set<Genres> genres, Set<Authors> authors, Set<Languages> languages, Set<Orders> orders, Set<Reports> reports, int publishing_year, int price, boolean bestseller, int isbn, int total_pages, boolean in_stock, boolean availability) {
        this.books_id = books_id;
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.languages = languages;
        this.orders = orders;
        this.reports = reports;
        this.publishing_year = publishing_year;
        this.price = price;
        this.bestseller = bestseller;
        this.isbn = isbn;
        this.total_pages = total_pages;
        this.in_stock = in_stock;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }

    public Set<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Authors> authors) {
        this.authors = authors;
    }

    public Set<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Languages> languages) {
        this.languages = languages;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Reports> getReports() {
        return reports;
    }

    public void setReports(Set<Reports> reports) {
        this.reports = reports;
    }

    public int getPublishing_year() {
        return publishing_year;
    }

    public void setPublishing_year(int publishing_year) {
        this.publishing_year = publishing_year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

