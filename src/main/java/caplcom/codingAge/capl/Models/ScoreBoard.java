package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection ="Scoreboard")
@Getter
@Setter
@NoArgsConstructor
public class ScoreBoard {

    @Id
    private String scoreBoardId;
    private String matchId;
    private String teamId;
    private boolean inning;
    private String strikerId;
    private String nonStrikerId;
    private String bowlerId;
    private int totalRuns;
    private int totalWickets;
    private double overs;
    private int noOfWickets;
    private List <BatterStat> batterStatList = new ArrayList<>();
    private List <BowlerStat> bowlerStatList = new ArrayList<>();
    private List <Extras> extrasList=new ArrayList<>();



}
