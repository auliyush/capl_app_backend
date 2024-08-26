package caplcom.codingAge.capl.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ad")
@Getter
@Setter
@NoArgsConstructor
public class AdminUser {
    @Id
    private String adminId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPassword;
    private String userProfilePhotoUrl;
}
