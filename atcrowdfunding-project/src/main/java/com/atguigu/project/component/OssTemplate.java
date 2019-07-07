package com.atguigu.project.component;

import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@ConfigurationProperties(prefix = "oss")
@Component
public class OssTemplate {
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;
    private String bucketName;
    public String upload(byte[] content,String fileName) throws FileNotFoundException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。

// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。

//用户登录名称 Ye@1622360688130099.onaliyun.com
//AccessKey ID LTAIlsyqXQPSbWhe
//AccessKeySecret 7BbSgNFtrR4BJmv65VHfasRSVo3svH
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流。
      //以后使用流数据
        fileName=UUID.randomUUID().toString().replace("-","")+"_"+fileName;

        //但是目前这样只能上传到文件管理整个界面，想放入其中某个文件夹可以进行拼接
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());

        ossClient.putObject(bucketName, "pic/"+format+"/"+fileName, new ByteArrayInputStream(content));
// 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("上传成功");

        //我们也要返回文件的访问地址存到数据库
        String url="https://"+bucketName+"."+endpoint.substring(7)+"/pic/"+format+"/"+fileName;
        return url;
    }
}
