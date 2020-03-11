package com.kim.security.ctrl;

import com.kim.security.dto.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

/**
 * @auther: kim
 * @create: 2019-09-24 11:45
 * @description:
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        String folder = "E:\\develop\\workspace\\learn\\security-1\\security-demo\\src\\main\\java\\com\\kim\\security\\ctrl";
        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }
}
