package com.maryanto.dimas.example.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/files")
public class WebUploadFileController {

    @Value("${files.store_location}")
    private String UPLOAD_DIRECTORY;

    @GetMapping("/upload")
    public String form(Model mav) {
        mav.addAttribute("user", "Dimas Maryanto");
        mav.addAttribute("tanggal", LocalDate.now().toString());
        return "upload-file";
    }

    @GetMapping("/list")
    public String list(Model mav) {
        File dir = new File(UPLOAD_DIRECTORY);
        List<String> collect;
        if (dir.exists()) {
            collect = Arrays.stream(dir.listFiles())
                    .filter(data -> data.isFile())
                    .map(File::getName)
                    .collect(Collectors.toList());
        } else
            collect = new ArrayList<>();

        mav.addAttribute("files", collect);
        return "list-file";
    }

    @PostMapping("/proses")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file)
            throws IOException {
        String fileName = String.format(
                "%s.%s",
                UUID.randomUUID().toString(),
                FilenameUtils.getExtension(file.getOriginalFilename())
        );

        File dir = new File(UPLOAD_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String location = new StringBuilder(UPLOAD_DIRECTORY)
                .append(File.separator)
                .append(fileName).toString();
        Path path = Paths.get(location);
        Files.write(path, file.getBytes());
        model.addAttribute("msg", "Uploaded images: " + UPLOAD_DIRECTORY.toString());
        return "redirect:/files/list";
    }
}
