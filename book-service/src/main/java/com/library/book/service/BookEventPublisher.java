package com.library.book.service;

import com.library.book.messaging.JmsConstant;
import com.library.book.model.BookCreatedEvent;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookEventPublisher {

    private final JmsTemplate jmsTemplate;

   public BookEventPublisher(JmsTemplate jmsTemplate){
       this.jmsTemplate = jmsTemplate;
   }

   public void publishEvent(BookCreatedEvent event){
       jmsTemplate.convertAndSend(JmsConstant.BOOK_CREATED_QUEUE,event);
       System.out.println("Event Published To AvtiveMQ :" +event.getName());
   }

}