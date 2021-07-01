package pl.pjatk.sampleMicroservice.rentalService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @PutMapping("/{id}/true")
    public ResponseEntity<Movie> changeFlag(@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.changeFlag(id));
    }

    @PutMapping("/{id}/false")
    public ResponseEntity<Movie> changeFlagFalse(@PathVariable Long id) {
        return ResponseEntity.ok(sampleService.changeFlagFalse(id));
    }

    @ApiOperation(value = "Find movie by given id",
            response = Movie.class,
            notes = "Getting movie from provided id")

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Everything is alright"),
            @ApiResponse(code = 404, message = "Movie not found!"),
            @ApiResponse(code = 401, message = "UNAUTHORIZED, be careful!"),
            @ApiResponse(code = 403, message = "Forbidden!")
    })

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(
            @ApiParam(name = "id",
                    type = "long",
                    value = "100",
                    example = "1",
                    required = true,
                    defaultValue = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(sampleService.findMovieById(id));
    }
}