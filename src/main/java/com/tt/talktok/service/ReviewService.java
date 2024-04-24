package com.tt.talktok.service;

import com.tt.talktok.dto.ReviewDto;
import com.tt.talktok.entity.Review;
import com.tt.talktok.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void reviewWrite(ReviewDto reviewDto) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        Review review = Review
                .builder()
                .rev_name(reviewDto.getRev_name())
                .rev_detail(reviewDto.getRev_detail())
                .rev_writer(reviewDto.getRev_writer())
                .rev_score(reviewDto.getRev_score())
                .rev_date(currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .lec_no(reviewDto.getLec_no())
                .tea_no(reviewDto.getTea_no())
                .build();
        reviewRepository.save(review);
    }

    public List<ReviewDto> reviewFindAll() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReviewDto convertToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setRev_no(review.getRev_no());
        reviewDto.setRev_name(review.getRev_name());
        reviewDto.setRev_detail(review.getRev_detail());
        reviewDto.setRev_writer(review.getRev_writer());
        reviewDto.setRev_score(review.getRev_score());
        reviewDto.setRev_date(review.getRev_date());
        reviewDto.setLec_no(review.getLec_no());
        reviewDto.setTea_no(review.getTea_no());
        reviewDto.setRev_detail(reviewDto.getRev_detail().replace("\\n","<br/>"));
        // 엔티티 클래스의 필드를 DTO 클래스에 설정

        return reviewDto;
    }
}
