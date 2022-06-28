package com.smartech.vendorportal.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.smartech.vendorportal.entities.FileDB;




public interface FileStorageService {
	FileDB store(MultipartFile file) throws IOException;
	FileDB getFile(String id);
	Stream<FileDB> getAllFiles();
}
