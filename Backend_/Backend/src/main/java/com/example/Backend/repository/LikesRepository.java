package com.example.Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Backend.entity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer>{
    
}
