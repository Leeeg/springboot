package com.example.springboot.common;

import com.example.springboot.entity.Notes;

import java.util.List;

/**
 * @Create by lee
 * @emil JefferyLeeeg@gmail.com
 * @Date 18-12-19
 * @Time 下午5:45
 */
public interface NotesEx {

    String addNote(Notes note);//创建文章

    String deleteNotesById(Long... ids);//通过文章id删除文章

    String updateNote(Notes note);//修改文章

    List<Notes> getAllNotes();//获取全部文章列表

    List<Notes> getNotesById(Long... ids);//通过文章id获取文章信息

}
