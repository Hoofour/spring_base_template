package com.ra.spring_base_template.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FileUploadUtil {
    private final Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) throws IOException {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("resource_type", "auto"));
        return uploadResult.get("secure_url").toString();
    }

    public String uploadFiles(File file, String folder) throws IOException {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file,
                ObjectUtils.asMap("resource_type", "auto", "folder", folder));
        return uploadResult.get("secure_url").toString();
    }
}
