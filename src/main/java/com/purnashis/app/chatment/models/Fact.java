package com.purnashis.app.chatment.models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    public String ip;

    @Column
    public String fact;

    @Column
    @CreationTimestamp
    public Date datetime;

    public Fact(){

    }
    public Fact(String ip, String fact){
        this.ip = ip;
        this.fact = fact;
    }
//    public long getId() {
//        return id;
//    }

}
