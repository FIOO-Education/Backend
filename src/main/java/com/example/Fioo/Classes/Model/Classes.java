
package com.example.Fioo.Classes.Model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codclass")
    private Long codClass;
    @Column(name = "nameclass")
    private String nameClass;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "videolink")
    private String videoLink;
    @Column(name = "subject")
    private String subject;


}
