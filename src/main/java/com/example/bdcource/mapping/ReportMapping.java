package com.example.bdcource.mapping;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.entity.ReportEntity;
import com.example.bdcource.repository.CommentRepository;
import com.example.bdcource.repository.ReportTypesRepository;
import com.example.bdcource.repository.ReviewRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportMapping {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReportTypesRepository reportTypesRepository;
    @Autowired
    private UserRepository userRepository;

    public ReportDto mapToReportDto(ReportEntity entity) {
        ReportDto tempDto = new ReportDto();
        tempDto.setReportId(entity.getReportId());
        tempDto.setReportText(entity.getReportText());
        tempDto.setReportTime(entity.getReportTime());
        tempDto.setReportType(entity.getReportType().getTypeId());
        tempDto.setReportedUser(entity.getReportedUser().getUserId());
        if (entity.getReportedReview() == null)
            tempDto.setReportedReview(null);
        else
            tempDto.setReportedReview(entity.getReportedReview().getReviewId());
        if (entity.getReportedComment() == null)
            tempDto.setReportedComment(null);
        else
            tempDto.setReportedComment(entity.getReportedComment().getCommentId());
        return tempDto;
    }

    public ReportEntity mapToReportEntity(ReportDto dto) {
        ReportEntity tempEntity = new ReportEntity();
        tempEntity.setReportId(dto.getReportId());
        tempEntity.setReportText(dto.getReportText());
        tempEntity.setReportTime(dto.getReportTime());
        tempEntity.setReportType(reportTypesRepository.findByTypeId(dto.getReportType()));
        tempEntity.setReportedReview(reviewRepository.findByReviewId(dto.getReportedReview()));
        tempEntity.setReportedComment(commentRepository.findByCommentId(dto.getReportedComment()));
        tempEntity.setReportedUser(userRepository.findByUserId(dto.getReportedUser()));
        return tempEntity;
    }

}
