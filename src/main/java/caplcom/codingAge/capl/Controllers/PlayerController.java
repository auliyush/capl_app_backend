package caplcom.codingAge.capl.Controllers;

import caplcom.codingAge.capl.Models.Player;
import caplcom.codingAge.capl.Models.request.CreateRequests.PlayerRequest;
import caplcom.codingAge.capl.Models.request.UpdateRequests.UpdatePlayer;
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

//    @PostMapping("/create/player")
//    public Player createPlayer(@RequestBody PlayerRequest playerRequest){
//        return playerService.createPlayer(playerRequest);
//    }
    @GetMapping("/get/player")
    public Player getPlayerById(@RequestParam String playerId){
        return playerService.getPlayerById(playerId);
    }

    @PutMapping("/update/profile")
    public Player updatePlayer(@RequestBody UpdatePlayer updatePlayer){
        return playerService.updatePlayer(updatePlayer);
    }
    @GetMapping("listOf/Player")
    public List<Player> getListOfPlayer(){
        return playerService.getListOfPlayer();
    }

    @GetMapping("listOf/player/ByRole")
    public List<Player> getListOfPlayerByRole(@RequestParam String playerRole){
        return  playerService.getListOfPlayerByRole(playerRole);
    }
}
// this is checked 28/08/2024 12:20
