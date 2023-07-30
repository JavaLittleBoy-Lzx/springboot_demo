package com.lzx.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName FormController
 * @Description TODO
 * @Author lzx
 * @Date 2023/7/28 10:24:21
 * @Version 1.0
 **/
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String getForm() {
        return "form/form_layouts";
    }
    //文件上传的方法
    @PostMapping("upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos)  throws IOException{
        if (!headerImg.isEmpty()) {
            //保存到文件服务器
            String originalFilename = headerImg.getOriginalFilename(); //原始文件名称
            headerImg.transferTo(new File("E:\\img\\" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String photoOriginalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\img\\" + photoOriginalFilename));
                }
            }
        }
        return "main";
    }
}
