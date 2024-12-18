package caplcom.codingAge.capl.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Tournament")
public class Tournament {
    @Id
    private String tournamentId;
    private String tournamentName;
    private String seasonYear;
    private String tournamentCreatorId;
    private String highestScoreBatterId;
    private String highestScoreBowlerId;
    private String winnerTeam;
    private Date tournamentStartDate;
    private Date tournamentEndDate;
    private String stadiumName;
    private String stadiumAddress;
    private List<TeamStats> teamStatsList;
    private List<Team> teamList;

    public Tournament(){
        super();
        this.teamList = new ArrayList<>();
        this.teamStatsList = new ArrayList<>();
    }
}