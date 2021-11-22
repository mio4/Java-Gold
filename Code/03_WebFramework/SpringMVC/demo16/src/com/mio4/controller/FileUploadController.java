package com.mio4.controller;

import com.mio4.pojo.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(description);

        if(!file.isEmpty()){
            String path = request.getServletContext().getRealPath("/images/");
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            System.out.println("path " + path);
            System.out.println("filename " + filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            return "success"; //@Controller返回的String参数是视图名称
        }else{
            return "error";
        }
    }

    //使用@ModelAttribute将传来的username和image和user对象的属性绑定
    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request,
                           @ModelAttribute User user,
                           Model model) throws Exception{
        System.out.println(user.getUsername());
        if(!user.getFile().isEmpty()){
            String path = request.getServletContext().getRealPath("/images/");
            String filename = user.getFile().getOriginalFilename();
            File filepath = new File(path,filename);
            if(filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            System.out.println("parentFile" + filepath.getParentFile());
            user.getFile().transferTo(new File(path + File.separator + filename));
            model.addAttribute("user",user);
            return "userinfo";
        } else{
            return "error";
        }
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model
                                           ) throws Exception{
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();

        //下载时显示的中文名，访问乱码
        String download_filename = new String(filename.getBytes("UTF-8"),"iso-8859-1");

        //以下载方式打开文件
        headers.setContentDispositionFormData("attachment",download_filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
    }
}




