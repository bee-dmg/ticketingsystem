package com.TSystem.TicketSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name = "author")
    private String author;

    @Column(name = "status")
    private String status;

    public Ticket() {
    }

    public Ticket(String title, String description, String date, String author, String status) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.author = author;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", title=" + title + ", desc=" + description + ", date=" + date + ", author="
                + author + ", status" + status + "]";
    }

}