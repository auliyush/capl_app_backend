package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.request.CreateRequests.ExtrasRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdateExtras;
import caplcom.codingAge.capl.Services.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/capl/Extras")
@CrossOrigin(origins = "*")
public class ExtrasController {
    @Autowired
    ExtrasService extrasService;

    @PostMapping("/create")
    Extras createExtras(ExtrasRequest extrasRequest) {
        return extrasService.createExtras(extrasRequest);
    }

    @GetMapping("/{id}")
    Extras getExtrasById(String id) {
        return extrasService.getExtrasById(id);
    }

    @GetMapping("/byTeamId")
    List<Extras> getExtrasByTeamId(String teamId) {
        return extrasService.getExtrasByTeamId(teamId);
    }

    @PutMapping("/update")
    Extras updateExtrasById(UpdateExtras updateExtras) {
        return extrasService.updateExtrasById(updateExtras);
    }
}
