package java.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.example.entity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer>{
    
}
