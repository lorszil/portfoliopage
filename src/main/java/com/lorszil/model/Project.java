package com.lorszil.model;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`project`")
@Data
@ToString(exclude = {"token"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
//    private List <Images> imagesList;



    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "project_images",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "images_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "images_id"}))
    private List<Images> interestList;*/

    public Project() {
    }

    public Project(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
