package com.example.springboot.dao;

import com.example.springboot.entity.Notes;
import com.example.springboot.util.mapper.MyMapper;

public interface NotesMapper extends MyMapper<Notes> {

    Notes selectNotesDesc(Integer limit);

}