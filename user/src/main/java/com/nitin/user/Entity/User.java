package com.nitin.user.Entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Size(min = 2, message = "name should be more then two char")
    String name;

    @Past
    Date birthDate;

    @OneToMany(mappedBy = "user")
    List<PostData> postData;
}
