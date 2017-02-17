package com.xiaodong.service;

import com.xiaodong.dao.INoteDao;
import com.xiaodong.po.Note;
import com.xiaodong.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */
@Service
@Transactional
public class noteServiceImpl implements  noteService {

    @Autowired
    private INoteDao noteDao;

    public void addNote(Note note) {
        this.noteDao.addNote(note);

    }

    public void updateNote(Note note) {
        this.noteDao.updateNote(note);
    }

    public List<Note> getAllNote() {
        return this.noteDao.getAllNote();
    }

    public Note getNoteById(int id) {
        return this.noteDao.getNoteById(id);
    }

    public void deleteNote(Note note) {
        this.noteDao.deleteNote(note);

    }

    public List<Note> getAllNoteByUser(User user) {
        return this.noteDao.getAllNoteByUser(user);
    }

    public List<Note> getAllNoteByUserId(int id) {
        return this.noteDao.getAllNoteByUserId(id);
    }

}
