package com.hero.poetry.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FIleUploadController {

    @Value("${file.path}")
    private String filePath;
    @RequestMapping("/poetry/upload")
    @ResponseBody
    public String upload(MultipartFile file){

        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString()+extName;
        try {
            FileCopyUtils.copy(file.getInputStream(),new FileOutputStream(new File(filePath+fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
