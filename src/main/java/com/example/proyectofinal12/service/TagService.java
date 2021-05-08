package com.example.proyectofinal12.service;

import com.example.proyectofinal12.model.Tag;

import java.util.List;

public interface TagService {

    Tag createTag(String tagName);
    Tag updateTag(Long id, Tag tag);
    void deleteTag(Tag tagToDelete);
    List<Tag> findAllByFilter(String nombre, String limite, String pagina);
    List<Tag> findAll();
    Tag findByName(String name);

    Tag findOne(Long id);
    List<Tag> findByAllByName(String name);

    }
