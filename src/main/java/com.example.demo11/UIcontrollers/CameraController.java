package com.example.demo11.UIcontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@RestController
public class CameraController {

    @PostMapping("/webcam")
    public String captureImage(MultipartFile imageFile) {
        try {
            String fileName = imageFile.getOriginalFilename();
            Path imagePath = Path.of("static/idTypes/" + fileName);
            Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);

            return "Image captured and saved: " + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to capture and save the image.";
        }
    }
}