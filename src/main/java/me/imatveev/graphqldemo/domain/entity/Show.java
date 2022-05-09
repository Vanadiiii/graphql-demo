package me.imatveev.graphqldemo.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Show {
    @Id
    @GenericGenerator(name = "nano_id", strategy = "me.imatveev.graphqldemo.configuration.NanoIdGenerator")
    @GeneratedValue
    private String id;

    private String title;

    private Integer releaseYear;

    public Show(String title, Integer releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }
}
