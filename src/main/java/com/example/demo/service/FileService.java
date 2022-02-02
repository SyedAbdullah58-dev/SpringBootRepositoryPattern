package com.example.demo.service;

import com.example.demo.model.FileDB;
import com.example.demo.repository.IFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileService {
    @Autowired
private IFileRepository fileRepository;



    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        return fileRepository.save(FileDB);
    }
    public FileDB getFile(Long id) {
        return fileRepository.findById(id).get();
    }

    public Stream<FileDB> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}
