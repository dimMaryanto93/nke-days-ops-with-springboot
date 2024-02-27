package com.maryanto.dimas.example.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/media/v1")
public class ApiUploadFileController {

    @Value("${files.store_location}")
    private String fileLocation;

    @PostMapping(
            value = "/upload",
            consumes = {
                    MediaType.MULTIPART_FORM_DATA_VALUE,
                    MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<?> uploadFile(
            @RequestPart("content")  MultipartFile file) throws IOException {
        String fileName = String.format(
                "%s.%s",
                UUID.randomUUID().toString(),
                FilenameUtils.getExtension(file.getOriginalFilename())
        );

        File dir = new File(fileLocation);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String location = new StringBuilder(fileLocation)
                .append(File.separator)
                .append(fileName).toString();
        Path path = Paths.get(location);
        Files.write(path, file.getBytes());

        return ResponseEntity.ok(location);
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> files() throws IOException {
        File dir = new File(fileLocation);
        List<String> collect = Arrays.stream(dir.listFiles())
                .filter(data -> data.isFile())
                .map(File::getName)
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

}
