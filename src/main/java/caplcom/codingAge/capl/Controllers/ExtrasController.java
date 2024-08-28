package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Base.ApiResponse;
import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.request.CreateRequests.ExtrasRequest;
import caplcom.codingAge.capl.Services.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/capl/Extras")
@CrossOrigin(origins = "*")
public class ExtrasController {
    @Autowired
    private ExtrasService extrasService;

    @PostMapping("/create")
    public ApiResponse<Extras> createExtras(@RequestBody ExtrasRequest extrasRequest) {
        return new ApiResponse<>(extrasService.createExtras(extrasRequest), HttpStatus.ACCEPTED);
    }
//    @GetMapping("/{id}")
//    Extras getExtrasById(String id) {
//        return extrasService.getExtrasById(id);
//    }

    // todo think there is no need of get by team id in controller because list of extras already
    //  exists in scoreboard
    @GetMapping("/byScoreBoardId")
    public ApiResponse<Extras> getExtrasByScoreBoardId(String scoreBoardId) {
        return new ApiResponse<>(extrasService.getExtrasByScoreBoardId(scoreBoardId), HttpStatus.OK);
    }

//    @PutMapping("/update")
//    Extras updateExtrasById(UpdateExtras updateExtras) {
//        return extrasService.updateExtrasById(updateExtras);
//    }

    // there is no need of update extras
}

// this is checked 28/08/2024  12:20
