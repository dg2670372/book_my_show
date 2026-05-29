package com.example.book_my_show.repository;

import com.example.book_my_show.model.Payment;
import com.example.book_my_show.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long>
{
    List<Screen> findByTheaterId(Long theaterId);
}