package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="User")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private String userProfilePhotoUrl;
}

