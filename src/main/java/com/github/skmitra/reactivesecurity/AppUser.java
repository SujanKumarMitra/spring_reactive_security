package com.github.skmitra.reactivesecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author skmitra
 * @since Aug 14/08/21, 2021
 */
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    private String username;
    private String password;


}
