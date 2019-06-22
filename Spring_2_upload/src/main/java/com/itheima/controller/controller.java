package com.itheima.controller;


import com.sun.deploy.util.SessionState;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class controller {

    /**
     * 跨服务器上传
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传。。");
        //定义上传服务器路径
        String path="http://localhost:9090/uploads/";

        //说明文件上传项
        //获取文件上传的名称
        String filename=upload.getOriginalFilename();
        //文件名称设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;

        //创建客户端对象
        Client client=Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path +filename);

        //文件上传
        webResource.put(upload.getBytes());
        return "success";
    }

    /**
     * SpringMVC 文件上传
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springmvc文件shangc");
        //
        String path=request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.exists();
        }
        String filename=upload.getOriginalFilename();
        String uuid=UUID.randomUUID().toString().replace("-","");
        filename=uuid+"_"+filename;
        upload.transferTo(new File(path,filename));
        return "success";

    }

}
