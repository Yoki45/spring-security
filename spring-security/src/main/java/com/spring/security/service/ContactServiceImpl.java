package com.spring.security.service;

import com.spring.security.dto.ContactDTO;
import com.spring.security.model.Contact;
import com.spring.security.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;


    @Override
    public void addContact(ContactDTO contact) {
        Contact newContact = this.toContact(contact);
        newContact.setContactId(getServiceReqNumber());
        newContact.setCreateDt(new Date(System.currentTimeMillis()));
        contactRepository.save(newContact);
    }


    @Override
    public List<ContactDTO> getContacts() {
        return contactRepository.findAll().stream()
                .map(ContactDTO::new)
                .collect(Collectors.toList());

    }

    @Override
    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }


    public static Contact toContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setContactEmail(contactDTO.getContactEmail());
        contact.setContactId(contactDTO.getContactId());
        contact.setContactName(contactDTO.getContactName());
        contact.setCreateDt(contactDTO.getCreateDt());
        contact.setMessage(contactDTO.getMessage());
        contact.setSubject(contactDTO.getSubject());
        return contact;
    }
}
