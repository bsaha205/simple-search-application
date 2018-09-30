package com.bishwajit.simplesearchapplication.developer;
        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import com.bishwajit.simplesearchapplication.language.Language;
        import com.bishwajit.simplesearchapplication.programminglanguage.ProgrammingLanguage;
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
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(
            name = "developers_languages",
            joinColumns = {@JoinColumn(name = "developersid")},
            inverseJoinColumns = {@JoinColumn(name="languagesid")}
    )
    private List<Language> languageEntities = new ArrayList<>();
    @ManyToMany(mappedBy = "developerEntitiesP")
    @JsonIgnoreProperties("developerEntitiesP")
    private List<ProgrammingLanguage> programmingLanguageEntities = new ArrayList<>();

    public Developer(String email, List<Language> languageEntities, List<ProgrammingLanguage> programmingLanguageEntities){
        this.email = email;
        this.languageEntities = languageEntities;
        this.programmingLanguageEntities = programmingLanguageEntities;
    }
    public Developer(String email){
        this.email = email;
    }



}
