package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;
import caplcom.codingAge.capl.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/capl/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/create/player")
    public Player createPlayer(@RequestBody PlayerRequest playerRequest){
        return playerService.createPlayer(playerRequest);
    }
    @GetMapping("/get/player")
    public Player getPlayerById(@RequestParam String playerId){
        return playerService.getPlayerById(playerId);
    }

    @GetMapping("listOf/Player")
    public List<Player> getListOfPlayer(){
        return playerService.getListOfPlayer();
    }
    @GetMapping("/get/economy/Rate")
    public String getEconomyRate(@RequestParam String playerId){
        return  playerService.getEconomyRate(playerId);
    }
    @GetMapping("/get/strike/Rate")
    public String getStikeRate(@RequestParam String playerId){
        return playerService.getStikeRate(playerId);
    }
}
