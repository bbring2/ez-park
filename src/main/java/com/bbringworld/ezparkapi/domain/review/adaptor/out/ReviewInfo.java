package com.bbringworld.ezparkapi.domain.review.adaptor.out;

import com.bbringworld.ezparkapi.domain.review.dao.entity.Review;
import com.bbringworld.ezparkapi.domain.review.dao.entity.ReviewImage;
import com.bbringworld.ezparkapi.domain.review.dao.entity.ReviewList;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public record ReviewInfo(
        long id,
        String carNumber,
        List<ReviewListInfo> reviewListInfos,
        List<String> imageList,
        String content,
        Integer score,
        Boolean recommend,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ReviewInfo of(Review review) {
        List<String> imageList = review.getReviewImageList()
                .stream()
                .map(ReviewImage::getImageUrl)
                .collect(Collectors.toList());

        return ReviewInfo.builder()
                .id(review.getId())
                .carNumber(review.getCarNumber())
                .reviewListInfos(List.of(ReviewListInfo.of(ReviewList.builder().build())))
                .imageList(imageList)
                .content(review.getContent())
                .score(review.getScore())
                .recommend(review.isRecommend())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
