package com.ua.armordrive.armor_drive.repos;

import com.ua.armordrive.armor_drive.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByFirstNameIgnoreCase(String firstName);

    boolean existsByLastNameIgnoreCase(String lastName);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByPhoneNumberIgnoreCase(String phoneNumber);

}
