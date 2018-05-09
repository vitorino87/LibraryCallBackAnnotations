/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.callback;

import com.tutorialspoint.entity.Book;
import javax.persistence.PostLoad;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author tiago.lucas
 */
public class BookCallBackListener {
    
    @PrePersist
    public void prePersist(Book book){
        System.out.println("BookCallbackListener.postPersist::"+
                "Book created with book id: "+((Book)book).getId());
    }
    
    @PreRemove
    public void preRemove(Book book){
        System.out.println("BookCallbackListener.preRemove:"+
                " About to delete Book: "+book.getId());
    }
    
    @PostRemove
    public void postRemove(Book book){
        System.out.println("BookCallbackListener.postRemove: "+
                "Deleted Book: "+ book.getId());
    }
    
    @PreUpdate
    public void preUpdate(Book book){
        System.out.println("BookCallbackListener.preUdate: "+
                "About to update Book: "+book.getId());
    }
    
    @PostUpdate
    public void postUpdate(Book book){
        System.out.println("BookCallbackListener.postUpdate: "+
                "Update Book: "+book.getId());
    }
    
    @PostLoad
    public void postLoad(Book book){
        System.out.println("BookCallbackListener.postLoad: "+
                "Loaded Book: "+book.getId());
    }
    
}
