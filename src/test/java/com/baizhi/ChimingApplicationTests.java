package com.baizhi;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChimingApplicationTests {

    @Autowired
    private AlbumDao albumDao;

    @Test
    public void contextLoads() {
        Album t = new Album();
        t.setId("22222222");
        albumDao.insertSelective(t);
        albumDao.insert(t);
    }

}
