package com.xiaodong.controller;

import com.xiaodong.po.Note;
import com.xiaodong.service.noteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiaodong chen on 2/16/2017.
 */

@CrossOrigin (origins = "*")
@Controller
public class NoteController {

    @Autowired
    private noteService myNoteService;

    @RequestMapping("/note")
    public @ResponseBody
    ResponseEntity<List<Note>> getAllNote() {
        List<Note> myNote =myNoteService.getAllNote();
        System.out.println("List all Note");
        return new ResponseEntity<List<Note>>(myNote, HttpStatus.OK);
    }

    @RequestMapping("/note/user/{user_id}")
    public @ResponseBody
    ResponseEntity<List<Note>> getAllNoteByUserId(@PathVariable("user_id") int user_id) {

        List<Note> myNote =myNoteService.getAllNoteByUserId(user_id);
        System.out.println("List all Note By UserId");
        return new ResponseEntity<List<Note>>(myNote, HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{note_id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Note> getUserById(@PathVariable("note_id") int note_id){

        System.out.println("Get note by note_Id");
        Note myNote = myNoteService.getNoteById(note_id);
        return new ResponseEntity<Note>(myNote, HttpStatus.OK);
    }

    @RequestMapping(value = "/note",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<Note> postNote(@RequestBody Note req){

        System.out.println("POST request: " + req);
        myNoteService.addNote(req);
        return new ResponseEntity<Note>(req, HttpStatus.OK);
    }

    @RequestMapping(value = "/note",method = RequestMethod.PUT,produces = "application/json", consumes = "application/json")
    public @ResponseBody ResponseEntity<Note>  putNote(@RequestBody Note req){
        System.out.println("PUT request: "+req);
        myNoteService.updateNote(req);
        return new ResponseEntity<Note>(req,HttpStatus.OK);
    }

    @RequestMapping(value = "/note/{note_id}",method = RequestMethod.DELETE)
    public @ResponseBody String  deleteNoteById(@PathVariable("note_id") int note_id){
        Note myNote = myNoteService.getNoteById(note_id);
        myNoteService.deleteNote(myNote);
        return myNote.toString();

    }







}
