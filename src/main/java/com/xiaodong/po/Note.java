package com.xiaodong.po;

import javax.persistence.*;

/**
 * Created by xiaodong chen on 2/16/2017.
 */

@Entity
@Table(name="cxd_note")
public class Note {

    @Id @GeneratedValue
    @Column (name= "note_id")
    private int id;

    @Column(name ="note_content")
    private String content;

    @Column(name="note_time")
    private String time;

    @Column (name ="note_type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Note() {}

    public Note(User user,String content) {
        this.content = content;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                '}';
    }
}
