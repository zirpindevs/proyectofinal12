package com.example.proyectofinal12.service.impl;

import com.example.proyectofinal12.dao.ExpertDAO;
import com.example.proyectofinal12.dao.TagDAO;
import com.example.proyectofinal12.model.Expert;
import com.example.proyectofinal12.model.Tag;
import com.example.proyectofinal12.service.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {
    private final Logger log = LoggerFactory.getLogger(ExpertServiceImpl.class);

    private final ExpertDAO expertDAO;
    private final TagDAO tagDAO;

    public ExpertServiceImpl(ExpertDAO expertDAO, TagDAO tagDAO) {
        this.expertDAO = expertDAO;
        this.tagDAO = tagDAO;
    }

    @Override
    public Expert createExpert(Expert expert) {
        log.info("REST request to create an expert");
        return this.expertDAO.createExpert(expert);
    }


    @Override
    public Expert updateExpert(Long id, Expert modifiedExpert) {
        log.info("REST request to update an expert");

        Tag findedTag = new Tag();
        Expert findedExpert = this.findOne(id);
        List<Tag> existingTags = findedExpert.getTags();

        if(findedExpert.getTags().size() < modifiedExpert.getTags().size()) {
            findedTag = tagDAO.findByName(modifiedExpert.getTags().get(modifiedExpert.getTags().size()-1).getName());
        }
            return this.expertDAO.updateExpert(modifiedExpert, findedExpert, findedTag, existingTags);
    }


    /*@Override
    public Expert updateExpert(Long id, Expert expert) {
        log.info("REST request to update an expert");

        Expert findExpert = this.findOne(id);
        Tag getNewTag = new Tag();
        List<Tag> listExistedTags = findExpert.getTags();
        Long newTagId = expert.getTags().get(0).getId();
        String newTagName = expert.getTags().get(0).getName();

        if(findExpert == null) {
            return null;
        }

        System.out.println("###########################    SERVICE    ###################################################");

//esto no parece que busque*******************
        if(listExistedTags.contains(newTagId) == false){
            System.out.println("resultado de busqueda falso, podemos insertar");

            //buscamos si ya existe
            getNewTag = tagDAO.findById(newTagId);
            System.out.println(getNewTag);
            //si es null no existe, y hay que crear la etiqueta primero
            if(getNewTag == null){
                getNewTag = tagDAO.createTag(newTagName);
            }
        }

        System.out.println("##############################################################################");

        return this.expertDAO.modifyExpert(expert, findExpert, getNewTag, listExistedTags);
    }*/

    @Override
    public List<Expert> findAll() {
        log.info("REST request to find all expert");

        return this.expertDAO.findAll();
    }

    @Override
    public Expert findOne(Long id) {
        log.info("REST request to find one expert by id");

        if(id == null)
            return null;
        return this.expertDAO.findById(id);
    }

    @Override
    public List<Expert> findAllByName(String name) {
        log.info("REST request to find an expert by name");

        if(name.isEmpty())
            return null;
        return this.expertDAO.findAllByName(name);
    }

    @Override
    public List<Expert> findAllByFilter(String nombre, String estado, String tamano, String pagina) {
        log.info("REST request to find an expert by filter");

    /*    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(params.size());
        params.forEach(param -> System.out.println(param.toString()));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
*/
        return this.expertDAO.findAllByFilter(nombre, estado, tamano, pagina);
    }

    @Override
    public void deleteExpert(Expert expertToDelete){
        log.info("REST request to delete an expert by id");
        this.expertDAO.deleteExpert(expertToDelete);

    }
}
