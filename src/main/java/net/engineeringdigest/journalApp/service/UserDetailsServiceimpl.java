package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceimpl implements UserDetailsService { // I will provide logic to load user from database”

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         User user = userRepository.findByUserName(username); // searching in db



         if(user != null){

             UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()

                     // niche explaination
                     //You are NOT creating your database User
                     //👉 You are creating a special object that Spring Security understands
                     //2 diff user h ek db entity wala aur dusra spring security user(internal object)
                     // this is springs's built-in class
                     //used internally for authentication
                      //👉 You are creating a Spring Security User object
                     //
                     //⚠️ Important:
                     //
                     //This is NOT your User entity
                     //This is Spring’s internal user

            // Why do we need to create this object?

                    // Because:

//👉 Spring Security does NOT understand your custom User class It only understands:
//
//UserDetails
//
//So you must convert your User → UserDetails
                     .username(user.getUserName()) //Set username from DB
                     .password(user.getPassword())
                     .roles(user.getRoles().toArray(new String[0])) //setting roles ki user h ya admin
                     .build();  // Builds the final UserDetails object

             return userDetails;

             //User enters login →
             //Spring Security →
             //calls loadUserByUsername() →
             //fetch user from DB →
             //convert to UserDetails →
             //check password →
             //grant/deny access


         }

        throw new UsernameNotFoundException("User not found with username: "+username);
    }
}
