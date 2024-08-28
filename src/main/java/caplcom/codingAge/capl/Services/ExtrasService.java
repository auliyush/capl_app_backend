package caplcom.codingAge.capl.Services;

import caplcom.codingAge.capl.Models.Extras;
import caplcom.codingAge.capl.Models.request.CreateRequests.ExtrasRequest;

import java.util.List;

public interface ExtrasService {
    Extras createExtras(ExtrasRequest extrasRequest);

    Extras getExtrasById(String id);

    Extras getExtrasByScoreBoardId(String scoreBoardId);

//    Extras updateExtrasById(UpdateExtras updateExtras);
// there is no need of update extras
}
