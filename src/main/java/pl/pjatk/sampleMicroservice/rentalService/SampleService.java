package pl.pjatk.sampleMicroservice.rentalService;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleService {

    private final RestTemplate restTemplate;

    public SampleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie findMovieById(Long id) {
        Movie movie = restTemplate.getForEntity("http://localhost:8080/movies/" + id, Movie.class).getBody();
        return movie;
    }

    public Movie changeFlag(Long id) {
        Movie movie = restTemplate.exchange("http://localhost:8080/movies/" + id + "/true/" ,  HttpMethod.PUT, null,Movie.class).getBody();
        return movie;
    }

    public Movie changeFlagFalse(Long id) {
        Movie movie = restTemplate.exchange("http://localhost:8080/movies/" + id + "/false/" ,  HttpMethod.PUT, null,Movie.class).getBody();
        return movie;
    }
}
