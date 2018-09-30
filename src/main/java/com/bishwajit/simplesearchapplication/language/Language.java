package com.bishwajit.simplesearchapplication.language;
        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;

    @ManyToMany(mappedBy = "languageEntities",cascade = {CascadeType.REMOVE},fetch = FetchType.LAZY)
    @JsonIgnoreProperties("languageEntities")
    private List<Developer> developerEntities = new ArrayList<>();

    public Language(String code){
        this.code = code;
    }



}

