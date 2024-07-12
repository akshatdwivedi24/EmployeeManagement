package com.example.firstjobapp.review.Impl;

import com.example.firstjobapp.company.Company;
import com.example.firstjobapp.company.CompanyService;
import com.example.firstjobapp.review.Review;
import com.example.firstjobapp.review.ReviewRepository;
import com.example.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository , CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public String addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company!= null){
            review.setCompany(company);
            reviewRepository.save(review);
        }

        return "Company Doesn't Exist";
    }

    @Override
    public Review getReview(Long companyId, Long ReviewId) {
     List<Review> reviews = reviewRepository.findByCompanyId(companyId);
     if(reviews.equals(ReviewId)){
         return (Review) reviews;
     }
     return null;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId) != null){
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }


}
