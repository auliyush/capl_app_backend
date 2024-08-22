package caplcom.codingAge.capl.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Extras")
public class Extras {
    @Id
    private String id;
    private String matchId;
    private String teamId;
    private String wideRun;
    private String legByRun;
    private String noBallRun;
    //
}
