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
@NoArgsConstructor
public class Season {
    @Id
    private String seasonId;
    private String seasonYear;
    private List<Tournament> tournamentList = new ArrayList<>();
    private List<Stats> statsList = new ArrayList<>();
    private List<Match> matchList =new ArrayList<>();
}
