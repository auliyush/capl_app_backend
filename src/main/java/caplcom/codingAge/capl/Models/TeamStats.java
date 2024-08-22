package caplcom.codingAge.capl.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection ="TeamStat")
@NoArgsConstructor
@AllArgsConstructor
public class TeamStats {
    @Id
    private String id;
    private String teamId;
    private List<Match> matchWinning = new ArrayList<>();
    private List<Match> matchLosing = new ArrayList<>();
    private List<Match> matchDrawn = new ArrayList<>();
}
