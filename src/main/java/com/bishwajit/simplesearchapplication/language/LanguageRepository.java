package com.bishwajit.simplesearchapplication.language;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language,Long> {
    List<Language> findByCodeLike(String code);
}
