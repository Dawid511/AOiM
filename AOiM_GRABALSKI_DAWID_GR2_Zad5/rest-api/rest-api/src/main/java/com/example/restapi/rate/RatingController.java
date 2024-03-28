package com.example.restapi.rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/rating")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }
    /*
    @PostMapping(path="{nazwa}")
    public void addRate(@RequestBody Rating rating, @PathVariable("nazwa") String nazwa){
        ratingService.addRating(rating, nazwa);
    }*/

    @PostMapping(path="{nazwa}")
    public ResponseEntity<Void> addRate(@RequestBody Rating rating, @PathVariable("nazwa") String nazwa) {
        ratingService.addRating(rating, nazwa);
        return ResponseEntity.ok().build();
    }
}

