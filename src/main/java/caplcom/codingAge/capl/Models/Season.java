package caplcom.codingAge.capl.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection ="Season")
@Getter
@Setter
@AllArgsConstructor
public class Season {
    @Id
    private String seasonId;
    private String seasonYear;
    private List<Tournament> tournamentList;
    private List<BatterStat> batterStatList;
    private List<BowlerStat> bowlerStatList;
    private List<Match> matchList;

    public Season(){
        this.tournamentList = new ArrayList<>();
        this.bowlerStatList = new ArrayList<>();
        this.batterStatList = new ArrayList<>();
        this.matchList = new ArrayList<>();
    }
}
