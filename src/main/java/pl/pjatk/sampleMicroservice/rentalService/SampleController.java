package pl.pjatk.sampleMicroservice.rentalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

        @GetMapping
    public ResponseEntity<Movie> findAll() {
        return ResponseEntity.ok(sampleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(sampleService.findMovieById(id));
    }

    @PutMapping("/{id}/true")
    public ResponseEntity<Movie> changeFlag(@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.changeFlag(id));
    }

    @PutMapping("/{id}/false")
    public ResponseEntity<Movie> changeFlagFalse(@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.changeFlagFalse(id));
    }
}