package com.example.firstjobapp.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);
    String addReview(Long companyId , Review review);
    Review getReview(Long companyId , Long ReviewId);
    boolean updateReview(Long companyId , Long reviewId , Review review);


}
