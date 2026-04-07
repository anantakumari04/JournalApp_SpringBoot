package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

 //  @GetMapping
   // public ResponseEntity<?> getAll(){
       //particular user k liye bna rhe h ab isiliye in sb ko comment kr diya
    // ye puri entries dega jo bhi db me h
//        List<JournalEntry> all = journalEntryService.getAll();
//        if(all != null && !all.isEmpty()){
//            return new ResponseEntity<>(all, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  // }
    @GetMapping("{userName}")
   public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
       User user =   userService.findByUserName(userName);
       List<JournalEntry> all = user.getJournalEntries(); //user ka journal entry lao
       if(all != null && !all.isEmpty()){
           return new ResponseEntity<>(all, HttpStatus.OK);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);

   }

//    @PostMapping
//    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
////      try{
////          myEntry.setDate(LocalDateTime.now());
////          journalEntryService.saveEntry(myEntry);
////          return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
////
////      } catch (Exception e) {
////          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////
////      }
//    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName){

        try{
            journalEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
////         Optional<JournalEntry> journalEntry = journalEntryService.findById(myId); //optional mtlb ek box
////        if(journalEntry.isPresent()){
////            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);//box ko lo fir get kro
////        }
////        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
//
//    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId); //optional mtlb ek box
        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);//box ko lo fir get kro
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

//    @DeleteMapping("id/{myId}")
//    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){ //? mtlb kisi aur class ka bhi return kra skte h
//
////       journalEntryService.deleteById(myId);
////       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("id/{userName}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String userName){
        journalEntryService.deleteById(myId, userName);
       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("id/{id}")
//    public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry){
//
////       JournalEntry old = journalEntryService.findById(id).orElse(null);
////
////       if(old !=null){
////           old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle(): old.getTitle());
////           old.setContent(newEntry.getContent() !=null && !newEntry.equals("") ? newEntry.getContent(): old.getContent());
////           journalEntryService.saveEntry(old);
////           return new ResponseEntity<>(old, HttpStatus.OK);
////       }
////       return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//
//    }

    @PutMapping("id/{userName}/{myId}")
        public ResponseEntity<?> updateJournalEntryById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry, @PathVariable String userName){

       JournalEntry old = journalEntryService.findById(id).orElse(null);

       if(old !=null){
           old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle(): old.getTitle());
           old.setContent(newEntry.getContent() !=null && !newEntry.equals("") ? newEntry.getContent(): old.getContent());
           journalEntryService.saveEntry(old);
           return new ResponseEntity<>(old, HttpStatus.OK);
       }
       return  new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

}
