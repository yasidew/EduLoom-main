package com.ds.edustack.notification.repository;

import com.ds.edustack.notification.entity.EmailDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailDetails, String> {

    List<EmailDetails> findByToEmail(String toEmail);
}
