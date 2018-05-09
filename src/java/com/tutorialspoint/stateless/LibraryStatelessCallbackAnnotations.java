/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.stateless;

import com.tutorialspoint.entity.Book;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tiago.lucas
 */
@Stateless
public class LibraryStatelessCallbackAnnotations implements LibraryStatelessCallbackAnnotationsRemote {

    @PersistenceContext(unitName = "LibraryCallBackAnnotationsPU")
    private EntityManager entityManager;

    public void addBooks(Book book) {
        entityManager.persist(book);
    }

    public List<Book> getBooks() {
        return entityManager.createQuery("From Book").getResultList();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct:: LibraryStatelessCallbackAnnotations: "
                + "session bean created with entity Manager object.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy: LibraryStatelessCallbackAnnotations"
                + " session bean is removed");
    }

    @PostActivate
    public void postActivate() {
        System.out.println("LibraryStatefulSessionBean.postActivate:"
                + " bean activated.");
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("LibraryStatefulSessionBean.prePassivate:"
                + " bean passivated.");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
