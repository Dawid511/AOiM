package com.example.restapi.rate;

import com.example.restapi.group.GroupEmployee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "rating")
public class Rating {


    public Rating(){
        this.data = new Date();
    };
    public Rating(int ocena, GroupEmployee grupa, String komentarz){
        this.oceny = ocena;
        this.group = grupa;
        this.komentarz=komentarz;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "oceny")
    int oceny;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "grupa_id")
    private GroupEmployee group;

    @Column(name = "data")
    private Date data;

    @Column(name = "komentarz")
    private String komentarz;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOcena() {
        return oceny;
    }

    public void setOcena(int ocena) {
        this.oceny = ocena;
    }

    public GroupEmployee getGrupa() {
        return group;
    }

    public void setGrupa(GroupEmployee grupa) {
        this.group = grupa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getKomentarz() {
        return komentarz;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }
}
