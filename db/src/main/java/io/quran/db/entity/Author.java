package io.quran.db.entity;

import io.quran.db.entity.template.AbsEntity;
import io.quran.db.entity.verse.VerseDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
@Where(clause = "deleted = false")
public class Author extends AbsEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}