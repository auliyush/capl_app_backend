package caplcom.codingAge.capl.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Wicket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wicket {
    @Id
    private String wicketId;
    private String wicketDescription;
    private String bowlerId;
    private String teamId;
    private String batterId;
    private String fielderId;

}
