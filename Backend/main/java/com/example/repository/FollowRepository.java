package java.com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.example.entity.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Integer>{
    
}
