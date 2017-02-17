package com.xiaodong.dao;

import com.xiaodong.hibernate.dbDriver;
import com.xiaodong.po.Note;
import com.xiaodong.po.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */

@Repository
public class NoteDaoImpl implements INoteDao{

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void initialSessionFactory(){

        this.sessionFactory = dbDriver.getSessionFactory();
        this.session = this.sessionFactory.openSession();
        this.transaction = this.session.beginTransaction();

    }

    public void addNote(Note note) {
        initialSessionFactory();
        session.save(note);
        transaction.commit();
    }

    public Note getNoteById(int note_id) {
        initialSessionFactory();
        Note findNote = (Note) session.get(Note.class, new Integer(note_id));
        transaction.commit();
        return findNote;
    }

    public List<Note> getAllNote() {
        initialSessionFactory();
        List<Note> noteList = session.createQuery("from  com.xiaodong.po.Note").list();
        for(Note note : noteList){
            System.out.println("Person List::"+note);
        }
        transaction.commit();
        return noteList;
    }

    public void updateNote(Note note) {
        initialSessionFactory();
        session.update(note);
        transaction.commit();
    }

    public void deleteNote(Note note) {

        initialSessionFactory();
        session.delete(note);
        transaction.commit();

    }

    public List<Note> getAllNoteByUser(User myUser){
        initialSessionFactory();
        Query query= session.createQuery("from  com.xiaodong.po.Note N where N.user.id = :tarId");
        query.setParameter("tarId", myUser.getId());
        List<Note> noteList = query.list();
        return noteList;
    }

    public List<Note> getAllNoteByUserId(int id){

        initialSessionFactory();
        Query query= session.createQuery("from  com.xiaodong.po.Note N where N.user.id = :tarId");
        query.setParameter("tarId",id);
        List<Note> noteList = query.list();
        return noteList;
    }
}
