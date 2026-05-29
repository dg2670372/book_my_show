package com.example.book_my_show.repository;

import com.example.book_my_show.model.Movie;
import com.example.book_my_show.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>
{

    Optional<Payment> findByTransactionId(String transactionId);

}