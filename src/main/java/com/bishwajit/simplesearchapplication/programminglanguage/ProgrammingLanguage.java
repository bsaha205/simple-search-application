package com.bishwajit.simplesearchapplication.programminglanguage;

import com.bishwajit.simplesearchapplication.developer.Developer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "programming_languages")
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "programming_languages_developers",
            joinColumns = {@JoinColumn(name = "programming_languagesid")},
            inverseJoinColumns = {@JoinColumn(name="developersid")}
    )
    private List<Developer> developerEntitiesP = new ArrayList<>();

    public ProgrammingLanguage(long id, String name){
        this.id = id;
        this.name = name;
    }
    public ProgrammingLanguage(String name){
        this.name = name;
    }

}

