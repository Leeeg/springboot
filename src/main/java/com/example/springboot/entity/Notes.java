package com.example.springboot.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "v_notes")
public class Notes implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 笔记Id
     */
    @Column(name = "note_id")
    private Long noteId;

    /**
     * 笔记作者Id == 用户Id
     */
    @Column(name = "note_author_id")
    private Long noteAuthorId;

    /**
     * 笔记Title
     */
    @Column(name = "note_title")
    private String noteTitle;

    /**
     * 笔记作者Name == 用户Name
     */
    @Column(name = "note_author_name")
    private String noteAuthorName;

    /**
     * 笔记创建时间
     */
    @Column(name = "note_create_time")
    private Date noteCreateTime;

    /**
     * 笔记最后修改时间
     */
    @Column(name = "note_modified_time")
    private Date noteModifiedTime;

    /**
     * 笔记字数
     */
    @Column(name = "note_words")
    private Integer noteWords;

    /**
     * 笔记阅读数
     */
    @Column(name = "note_reads")
    private Integer noteReads;

    /**
     * 笔记喜欢数
     */
    @Column(name = "note_likes")
    private Integer noteLikes;

    /**
     * 笔记权限 0表示public
     */
    @Column(name = "note_permission")
    private Boolean notePermission;

    /**
     * 笔记类型 0表示个人笔记 1表示技术文档 2表示普通文档
     */
    @Column(name = "note_type")
    private Boolean noteType;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取笔记Id
     *
     * @return note_id - 笔记Id
     */
    public Long getNoteId() {
        return noteId;
    }

    /**
     * 设置笔记Id
     *
     * @param noteId 笔记Id
     */
    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    /**
     * 获取笔记作者Id == 用户Id
     *
     * @return note_author_id - 笔记作者Id == 用户Id
     */
    public Long getNoteAuthorId() {
        return noteAuthorId;
    }

    /**
     * 设置笔记作者Id == 用户Id
     *
     * @param noteAuthorId 笔记作者Id == 用户Id
     */
    public void setNoteAuthorId(Long noteAuthorId) {
        this.noteAuthorId = noteAuthorId;
    }

    /**
     * 获取笔记Title
     *
     * @return note_title - 笔记Title
     */
    public String getNoteTitle() {
        return noteTitle;
    }

    /**
     * 设置笔记Title
     *
     * @param noteTitle 笔记Title
     */
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
    }

    /**
     * 获取笔记作者Name == 用户Name
     *
     * @return note_author_name - 笔记作者Name == 用户Name
     */
    public String getNoteAuthorName() {
        return noteAuthorName;
    }

    /**
     * 设置笔记作者Name == 用户Name
     *
     * @param noteAuthorName 笔记作者Name == 用户Name
     */
    public void setNoteAuthorName(String noteAuthorName) {
        this.noteAuthorName = noteAuthorName == null ? null : noteAuthorName.trim();
    }

    /**
     * 获取笔记创建时间
     *
     * @return note_create_time - 笔记创建时间
     */
    public Date getNoteCreateTime() {
        return noteCreateTime;
    }

    /**
     * 设置笔记创建时间
     *
     * @param noteCreateTime 笔记创建时间
     */
    public void setNoteCreateTime(Date noteCreateTime) {
        this.noteCreateTime = noteCreateTime;
    }

    /**
     * 获取笔记最后修改时间
     *
     * @return note_modified_time - 笔记最后修改时间
     */
    public Date getNoteModifiedTime() {
        return noteModifiedTime;
    }

    /**
     * 设置笔记最后修改时间
     *
     * @param noteModifiedTime 笔记最后修改时间
     */
    public void setNoteModifiedTime(Date noteModifiedTime) {
        this.noteModifiedTime = noteModifiedTime;
    }

    /**
     * 获取笔记字数
     *
     * @return note_words - 笔记字数
     */
    public Integer getNoteWords() {
        return noteWords;
    }

    /**
     * 设置笔记字数
     *
     * @param noteWords 笔记字数
     */
    public void setNoteWords(Integer noteWords) {
        this.noteWords = noteWords;
    }

    /**
     * 获取笔记阅读数
     *
     * @return note_reads - 笔记阅读数
     */
    public Integer getNoteReads() {
        return noteReads;
    }

    /**
     * 设置笔记阅读数
     *
     * @param noteReads 笔记阅读数
     */
    public void setNoteReads(Integer noteReads) {
        this.noteReads = noteReads;
    }

    /**
     * 获取笔记喜欢数
     *
     * @return note_likes - 笔记喜欢数
     */
    public Integer getNoteLikes() {
        return noteLikes;
    }

    /**
     * 设置笔记喜欢数
     *
     * @param noteLikes 笔记喜欢数
     */
    public void setNoteLikes(Integer noteLikes) {
        this.noteLikes = noteLikes;
    }

    /**
     * 获取笔记权限 0表示public
     *
     * @return note_permission - 笔记权限 0表示public
     */
    public Boolean getNotePermission() {
        return notePermission;
    }

    /**
     * 设置笔记权限 0表示public
     *
     * @param notePermission 笔记权限 0表示public
     */
    public void setNotePermission(Boolean notePermission) {
        this.notePermission = notePermission;
    }

    /**
     * 获取笔记类型 0表示个人笔记 1表示技术文档 2表示普通文档
     *
     * @return note_type - 笔记类型 0表示个人笔记 1表示技术文档 2表示普通文档
     */
    public Boolean getNoteType() {
        return noteType;
    }

    /**
     * 设置笔记类型 0表示个人笔记 1表示技术文档 2表示普通文档
     *
     * @param noteType 笔记类型 0表示个人笔记 1表示技术文档 2表示普通文档
     */
    public void setNoteType(Boolean noteType) {
        this.noteType = noteType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", noteId=").append(noteId);
        sb.append(", noteAuthorId=").append(noteAuthorId);
        sb.append(", noteTitle=").append(noteTitle);
        sb.append(", noteAuthorName=").append(noteAuthorName);
        sb.append(", noteCreateTime=").append(noteCreateTime);
        sb.append(", noteModifiedTime=").append(noteModifiedTime);
        sb.append(", noteWords=").append(noteWords);
        sb.append(", noteReads=").append(noteReads);
        sb.append(", noteLikes=").append(noteLikes);
        sb.append(", notePermission=").append(notePermission);
        sb.append(", noteType=").append(noteType);
        sb.append("]");
        return sb.toString();
    }
}