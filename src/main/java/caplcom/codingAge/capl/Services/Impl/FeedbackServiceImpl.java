package caplcom.codingAge.capl.Services.Impl;

import caplcom.codingAge.capl.Models.Feedback;
import caplcom.codingAge.capl.Models.request.CreateRequests.FeedbackRequest;
import caplcom.codingAge.capl.Repositories.FeedbackRepository;
import caplcom.codingAge.capl.Services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;
    @Override
    public Feedback createFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback=new Feedback();
        feedback.setUserId(feedbackRequest.getUserId());
        feedback.setFeedbackSubmitDate(feedbackRequest.getFeedbackSubmitDate());
        feedback.setFeedbackDescription(feedbackRequest.getFeedbackDescription());
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getListOfFeedback() {
        return feedbackRepository.findAll();
    }
}
