package com.example.springboot.service;

import com.example.springboot.common.NotesEx;
import com.example.springboot.entity.Notes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-19
 * @Time 下午8:32
 */
@Service
public class NotesService extends BaseService<Notes> implements NotesEx {

    Logger logger = LoggerFactory.getLogger(NotesService.class);

    @Autowired
    NotesService notesService;

    @Override
    public String addNote(Notes note) {
        return null;
    }

    @Override
    public String deleteNotesById(Long... ids) {
        return null;
    }

    @Override
    public String updateNote(Notes note) {
        return null;
    }

    @Override
    public List<Notes> getAllNotes() {
        return null;
    }

    @Override
    public List<Notes> getNotesById(Long... ids) {
        return null;
    }

}
