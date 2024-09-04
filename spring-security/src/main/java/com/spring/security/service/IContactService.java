package com.spring.security.service;

import com.spring.security.dto.ContactDTO;

import java.util.List;


public interface IContactService {

    void addContact(ContactDTO contact);

    List<ContactDTO> getContacts();

    String getServiceReqNumber();

}
