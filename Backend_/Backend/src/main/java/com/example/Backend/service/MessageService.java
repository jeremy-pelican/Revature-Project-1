package com.example.Backend.service;

import com.example.Backend.entity.Message;
import com.example.Backend.repository.AccountRepository;
import com.example.Backend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository) {
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    //need function for message creation. since the message's poster needs to be checked, might be useful to import AccountRepository
    public Message newMessage(Message message) {
        if (message.getMessageText().isEmpty() || message.getMessageText().length() > 255) {
            return null;
        }
        if (accountRepository.findById(message.getPostedBy()).isEmpty()) {
            return null;
        }
        messageRepository.save(message);
        return message;
    }

    public List<Message> getAllMessages() {
        return (List<Message>) messageRepository.findAll();
    }

    public Message getMessageByID(int id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        return optionalMessage.orElse(null);
    }

    public Message deleteMessage(int id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            messageRepository.deleteById(id);
            return optionalMessage.get();
        }
        return null;
    }

    public Message updateMessage(int id, String newText) {
        if (newText == null || newText.isEmpty() || newText.length() > 255) {
            return null;
        }
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setMessageText(newText);
            messageRepository.save(message);
            return message;
        }
        return null;
    }

    public List<Message> getMessagesFromUser(int postedBy) {
        //probably needs custom query to get messages based on postedBy field
        return (List<Message>) messageRepository.findAllByPostedBy(postedBy);
    }

    public List<Message> findMessages(String search) {
        List<Message> messages = messageRepository.findAll();
        List<Message> matches = new ArrayList<>();
        search = search.toUpperCase();
        for (int i = 0; i < messages.size(); i++) {
            String mText = messages.get(i).getMessageText().toUpperCase();
            if (mText.contains(search)) {
                matches.add(messages.get(i));
            }
        }
        return matches;
    }
}