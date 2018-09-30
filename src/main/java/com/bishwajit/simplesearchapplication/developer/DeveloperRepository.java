package com.bishwajit.simplesearchapplication.developer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer,Long> {
    List<Developer> findByEmailLike(String email);
}
