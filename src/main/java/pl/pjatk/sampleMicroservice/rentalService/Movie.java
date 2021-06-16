package pl.pjatk.sampleMicroservice.rentalService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Movie {

    private Long id;
    private String name;

    private boolean isAvailable;

//    @JsonIgnore
    private Category category;

    public Movie() {
    }

    public Movie(long id, String name, Category category, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}