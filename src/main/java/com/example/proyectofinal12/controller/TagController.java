package com.example.proyectofinal12.controller;

import com.example.proyectofinal12.model.Tag;
import com.example.proyectofinal12.service.TagService;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://proyecto-final-expertos-front-5468r47tm-zirpindevs.vercel.app/etiquetas", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

@RequestMapping("/api")
public class TagController {

    private final Logger log = LoggerFactory.getLogger(TagController.class);

    private final TagService tagService;

        public TagController(TagService tagService) {
        this.tagService = tagService;
    }


    /**
     * CREATE A TAG
     * @param tagName
     * @return ResponseEntity<Tag>
     * @throws URISyntaxException
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/etiquetas")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tagName) throws URISyntaxException {
        log.debug("REST request to create new a tag: {} ", tagName);


        if (tagName.getName() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Tag checkTag = this.tagService.findByName(tagName.getName());

        if(checkTag == null) {
            Tag createTag = this.tagService.createTag(tagName.getName());

            return ResponseEntity
                    .created(new URI("/api/etiquetas/" + createTag.getName()))
                    .body(createTag);
        }
        else
        {
            System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            System.out.println("im used");

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

     /**
     * UPDATE TAG
     * @param id
     * @param modifiedTag
     * @return ResponseEntity<Tag>
     */
    @PutMapping("/etiquetas/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag modifiedTag){
        log.debug("REST request to update one tag: {} ",modifiedTag);

      /*  Session session = HibernateUtil.getSessionFactory().openSession();*/
        Tag updateTag = this.tagService.updateTag(id, modifiedTag);

        if(updateTag.getId() == null) {
            log.warn("update tag without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(updateTag);
    }


    /**
     * FIND ALL TAGS
     * @return List<Tag>
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/etiquetas")
    public List<Tag> findTags(){
        log.debug("REST request to find all Tags");

        return this.tagService.findAll();
    }

    /**
     * FIND ONE TAG BY ID
     * @param id
     * @return ResponseEntity<Tag>
     * @throws URISyntaxException
     */
    @GetMapping("/etiquetas/{id}")
    public ResponseEntity<Tag> findTagId(@PathVariable Long id) throws URISyntaxException {
/*
        Session session = HibernateUtil.getSessionFactory().openSession();


        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);

        criteria.where(builder.equal(root.get("id"), id));
*/

        Tag findTag = this.tagService.findOne(id);

/*
        session.close();
*/
        return ResponseEntity.ok().body(findTag);
    }

    @DeleteMapping("/etiquetas/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        log.debug("REST request to delete a tag: {} ", id);

        Tag tagToDelete = this.tagService.findOne(id);

        if (tagToDelete.getId() == null) {
            log.warn("tag not exists");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.tagService.deleteTag(tagToDelete);
        return ResponseEntity.noContent().build();
    }
}
