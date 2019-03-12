package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    public void addItem(Album t, MultipartFile alFile, HttpServletRequest request) {
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/proimg");//存的路径
            String filename = alFile.getOriginalFilename();//获取文件的名字
            File file = new File(realPath);
            if(!file.exists()){
                file.mkdir();
            }
            alFile.transferTo(new File(realPath+"\\"+filename));
            t.setCoverImg("proimg/"+filename);
            t.setId(UUID.randomUUID().toString().substring(30));
            t.setPublicTime(new Date());
            albumDao.insertSelective(t);
            albumDao.insert(t);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
