package pl.pjatk.sampleMicroservice.rentalService;

import io.swagger.annotations.ApiModelProperty;

public class Movie {

    @ApiModelProperty(notes = "This is an id of the movie", required = true, value = "id", example = "1")
    private Long id;
    @ApiModelProperty(notes = "This is a name of the movie", required = true, value = "name", example = "xd")
    private String name;
    @ApiModelProperty(notes = "This is a category id of the movie", required = true, value = "category", example = "Horror")
    private boolean isAvailable;

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