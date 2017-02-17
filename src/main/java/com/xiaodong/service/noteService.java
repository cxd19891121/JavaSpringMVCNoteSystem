package com.xiaodong.service;

import com.xiaodong.po.Note;
import com.xiaodong.po.User;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */
public interface noteService {

    void addNote(Note note);
    void updateNote(Note note);
    List<Note> getAllNote();
    Note getNoteById(int id);
    void deleteNote(Note note);
    List<Note> getAllNoteByUser(User user);
    List<Note> getAllNoteByUserId(int id);

}
