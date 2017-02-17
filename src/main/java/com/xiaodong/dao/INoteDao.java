package com.xiaodong.dao;

import com.xiaodong.po.Note;
import com.xiaodong.po.User;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */
public interface INoteDao {

    void addNote(Note note);

    Note getNoteById(int note_id);

    List<Note> getAllNote();

    void updateNote(Note note);

    void deleteNote(Note note);

    List<Note> getAllNoteByUser(User user);

    List<Note> getAllNoteByUserId(int id);
}
