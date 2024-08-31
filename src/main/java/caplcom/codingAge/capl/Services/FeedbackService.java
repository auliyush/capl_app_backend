package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Feedback;
import caplcom.codingAge.capl.Models.request.CreateRequests.FeedbackRequest;

import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(FeedbackRequest feedbackRequest);
    List<Feedback> getListOfFeedback();
}
