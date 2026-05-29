package com.example.book_my_show.repository;

import com.example.book_my_show.model.ShowSeat;
import com.example.book_my_show.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long>
{
    List<Theater> findByCity(String city);

}