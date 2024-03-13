package com.example.use_trade.config;

import com.amazonaws.services.s3.AmazonS3Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;

    @Value("${bucket}")
    private String bucket;

    @Value("${removeUrl}")
    private String removeUrl;

//    public String getImageUrl(MultipartFile multipartFile, String dirName) throws IOException {
////        File file = convertImageFile(multipartFile)
////                .orElseThrow(() -> new IllegalStateException("파일 전환에 실패했습니다."));
//    }

    private Optional<File> convertImageFile(MultipartFile multipartFile) throws IOException {
        File convertFile = new File(System.getProperty("user.dir") + "/" + multipartFile.getOriginalFilename());

        if (convertFile.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
                fos.write(multipartFile.getBytes());
            }
            return Optional.of(convertFile);
        }
        return Optional.empty();
    }

    private void removeFile(File file) {
        if (file.delete()) {
            log.info("New File Delete Success");
            return;
        }
        log.info("New File Delete Failed");
    }

//    public String uploadImageFile(File uploadImage, String dirName) {
//        String imageName = dirName + "/" + UUID.randomUUID() + "/" + uploadImage.getName();
//        String imageUrl = putImageFile(uploadImage, imageName);
//        removeNewFile(uploadImage);
//    }

    private void removeNewFile(File uploadImage) {

    }

//    private String putImageFile(File uploadImage, String imageName) {
//
//    }

}
