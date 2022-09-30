package com.mutant.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name="DNA")
public class DNAEntity {

    @Id
    @Column(name = "DNA")
    private String dna;

    @Column(name = "TYPE")
    private String type;

}
