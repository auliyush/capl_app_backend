package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection ="scoreboard")
@Getter
@Setter
@NoArgsConstructor
public class ScoreBoard {

    @Id
    private String id;
    private String matchId;
    private String firstTeamId;
    private String secondTeamId;
    private String strikerId;
    private String nonStrikerId;
    private String bowlerId;
    private int totalRuns;
    private double overs;
    private int noOfWickets;

    private List <Stats> statsList=new ArrayList<>();
    private List <Extras> extrasList=new ArrayList<>();



}
