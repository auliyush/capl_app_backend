package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Feedback;
import caplcom.codingAge.capl.Models.request.CreateRequests.FeedbackRequest;
import caplcom.codingAge.capl.Services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Feedback")
public class FeedbackController {
    @Autowired
    public FeedbackService feedbackService;

    @PostMapping("/createFeedback")
    public Feedback createFeedback(@RequestBody FeedbackRequest feedbackRequest){
        return feedbackService.createFeedback(feedbackRequest);
    }
    @GetMapping("/ListOfFeedback")
    public  List<Feedback> getListOfFeedback()
    {
        return feedbackService.getListOfFeedback();
    }
}
