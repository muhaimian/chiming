package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/file")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/upload")
    public String upload(Album t, MultipartFile alFile, HttpServletRequest request){
        albumService.addItem(t,alFile,request);
        return "success";
    }
}
