package br.com.jaia.b1naryinspec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "segmento")
public class Segmento {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "segmento_id")
    private Long id;

    @Column(name =  "segmento_nome", unique = true )

    private String nome;


    @ManyToMany(mappedBy = "segmentos")
    private Set<Checklist> checklistList = new HashSet<>();


    @OneToMany(mappedBy = "segmento", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<PrestadorServico> prestadorServicos;

    public Segmento(Long id, String nome, Set<Checklist> checklistList, Set<PrestadorServico> prestadorServicos) {
        this.id = id;
        this.nome = nome;
        this.checklistList = checklistList;
        this.prestadorServicos = prestadorServicos;
    }

    public Segmento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Checklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(Set<Checklist> checklistList) {
        this.checklistList = checklistList;
    }

    public Set<PrestadorServico> getPrestadorServicos() {
        return prestadorServicos;
    }

    public void setPrestadorServicos(Set<PrestadorServico> prestadorServicos) {
        this.prestadorServicos = prestadorServicos;
    }
}
