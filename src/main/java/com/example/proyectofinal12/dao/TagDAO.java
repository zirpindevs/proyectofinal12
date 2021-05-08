package com.example.proyectofinal12.dao;

import com.example.proyectofinal12.model.Tag;

import java.util.List;

public interface TagDAO {

    List<Tag> findAll();
    Tag findById(Long id);
    Tag findByName(String name);
    void deleteTag(Tag tagToDelete);
    List<Tag> findAllByFilter(String nombre, String limite, String pagina);
    List<Tag> findByAllByName(String name);

/*
    List<Tag> findAllFromSession();
*/

    Tag createTag(String tagName);
    Tag modifyTag(Tag tag, Tag findedTag);



}
