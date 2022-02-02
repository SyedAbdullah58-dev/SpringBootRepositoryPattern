package com.example.demo.repository;

import com.example.demo.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFileRepository extends JpaRepository<FileDB,Long> {
}
