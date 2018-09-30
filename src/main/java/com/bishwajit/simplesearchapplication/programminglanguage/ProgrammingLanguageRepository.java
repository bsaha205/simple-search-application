package com.bishwajit.simplesearchapplication.programminglanguage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage,Long> {
    List<ProgrammingLanguage> findByNameLike(String name);
}
