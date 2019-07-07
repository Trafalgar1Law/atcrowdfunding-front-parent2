package com.atguigu.atcrowdfundingproject;

import com.aliyun.oss.OSSClient;
import com.atguigu.project.component.OssTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtcrowdfundingProjectApplicationTests {
    @Autowired
    OssTemplate ossTemplate;
    @Test
    public void contextLoads() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\JesseYe\\Pictures\\微信图片_20190524194348.jpg");
        byte[] bytes=new byte[fileInputStream.available()];
        int read = fileInputStream.read(bytes);
        String upload = ossTemplate.upload(bytes, "微信图片_20190524194348.jpg");
        System.out.println("上传完成"+upload);
    }

}
