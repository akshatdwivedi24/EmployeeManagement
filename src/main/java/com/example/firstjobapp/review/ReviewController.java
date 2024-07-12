package com.example.firstjobapp.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Long companyId, @RequestBody Review review) {

        reviewService.addReview(companyId, review);
        return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);

    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {

        boolean isReviewUpdated = reviewService.updateReview(companyId , reviewId , review);
        if(isReviewUpdated){
            return new ResponseEntity<>("Review Updated Successfully" , HttpStatus.OK);
        }
                return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
    }


}


