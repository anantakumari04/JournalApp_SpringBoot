package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository; //kyuki repo ka object call krengee na ji to uske liye @autowired lga diye


    @Autowired
    private UserService userService;



 @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){

     try{

         User user = userService.findByUserName(userName);
         journalEntry.setDate(LocalDateTime.now());

         //save journal entry in db
         JournalEntry saved = journalEntryRepository.save(journalEntry); //jo journal entry save hui thi db me wo mil jaegi

         //ab jo user h uske database me patak denge
         user.getJournalEntries().add(saved);

         userService.saveEntry(user);

     }catch (Exception e){
         System.out.println(e);

         throw  new RuntimeException("An error occured while saving entry", e);

     }
         //jo user h usko bhi db me save kra diya with new journal entry
    }
    public void saveEntry(JournalEntry journalEntry){

        journalEntryRepository.save(journalEntry); //jo user h usko bhi db me save kra diya with new journal entry
    }


    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public void deleteById(ObjectId id, String userName){
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id)); //user me se wo journal entry delete krdo jo x.id hmare id se equal hogi tb
        userService.saveEntry(user); //user save hogya
        journalEntryRepository.deleteById(id); //journal enrty delete hogya
    }


}
