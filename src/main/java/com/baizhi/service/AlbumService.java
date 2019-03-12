package com.baizhi.service;

import com.baizhi.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface AlbumService {

    void addItem(Album t, MultipartFile alFile, HttpServletRequest request);
}
