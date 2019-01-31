package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.POJO.ResourceDetails;
import com.heyong.lenrn_net.Service.ResourceDetailsService;
import com.heyong.lenrn_net.Service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**上传文件
 * Create By Yong
 */

@Controller
@RequestMapping("/upload")
public class UploadController {

    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceDetailsService detailsService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/uploading",method = RequestMethod.POST)
    public String upload(@RequestParam("imgfile")MultipartFile imgfile ,@RequestParam("resourceName")String resourceName,@RequestParam(value = "file",required = false) MultipartFile file,
                         @RequestParam(value = "resourceCategory",defaultValue = "文档")String resourceCategory,
                         @RequestParam("resourceSubject")String resourceSubject,@RequestParam("resourceGrade")String resourceGrade,
                         @RequestParam("uploaderId")Integer uploaderId,@RequestParam("content")String content) {

        Resource resource = new Resource();
        //文件路径
        String path = "";
        //判断文件是否为空以判断程序是否继续往下执行
        int filestate = 1;
        try {
            if (file.isEmpty()) {
                logger.info("资源文件为空");
                filestate = 0;
            }
            if(imgfile.isEmpty()){
                logger.info("头像文件为空");
//                return null;
            }
            logger.info("开始上传");
            // 获取文件名
            if(filestate==1){
                String fileName = file.getOriginalFilename();
                logger.info("资源上传的文件名为：" + fileName);
                // 设置文件存储路径
                String filePath = "D://aim//";
                path = filePath + fileName;
                File dest = new File(path);

                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();// 新建文件夹
                }
                file.transferTo(dest);// 文件写入
                logger.info("资源上传成功");
            }


            String imgfileName = imgfile.getOriginalFilename();
            logger.info("图片资源上传的文件名为：" + imgfileName);
            // 获取文件的后缀名
//            String suffixName = fileName.substring(fileName.lastIndexOf("."));
//            logger.info("文件的后缀名为：" + suffixName);




            String imgfilePath = "F://IDEA//lenrn_net//src//main//resources//static//images//"+imgfileName;
            File dest2 = new File(imgfilePath);

            //数据库图片头像路径
            String imagesPath = imgfilePath.replaceAll("//","/");
            imagesPath = ".."+imgfilePath.split("static")[1];
            logger.info("头像路径："+imagesPath);

            resource.setResourceImg(imagesPath);
            resource.setResourceName(resourceName);
            resource.setResourceAddress(path);
            resource.setResourceCategory(resourceCategory);
            resource.setResourceGrade(resourceGrade);
            resource.setResourceSubject(resourceSubject);
            resource.setUploaderId(uploaderId);


            if (!dest2.getParentFile().exists()){
                dest2.getParentFile().mkdirs();
            }
            imgfile.transferTo(dest2);// 图片文件写入
            logger.info("资源上传成功");

            Resource resultResource = resourceService.addResource(resource);
            logger.info("Id:{}",resultResource.getResourceId());

            detailsService.addDetails(content,resultResource.getResourceId());
//            return resultResource;
            return "success";
        }catch (IllegalStateException e) {
            logger.info(e.getMessage());
            e.printStackTrace();

        }catch (IOException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        logger.info("资源上传失败");
//        return resource;
        return "false";
    }



    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/uploading2",method = RequestMethod.POST)
    public void upload(@RequestParam(value = "file") MultipartFile file,HttpServletResponse response) {

        String fileName = "";
        String path = "";
        //判断文件是否为空以判断程序是否继续往下执行
        int filestates = 1;
        try {
            if (file.isEmpty()) {
                logger.info("资源文件为空");
                filestates = 0;
            }
            logger.info("开始上传");
            // 获取文件名
            if(filestates==1){
                fileName = file.getOriginalFilename();
                logger.info("资源上传的文件名为：" + fileName);
                // 设置文件存储路径  F:\IDEA\lenrn_net\src\main\resources\static\images
                String filePath = "F://IDEA//lenrn_net//src//main//resources//images//";
                path = filePath + fileName;
                File dest = new File(path);

                // 检测是否存在目录
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();// 新建文件夹
                }
                file.transferTo(dest);
                logger.info("资源上传成功");
            }
            //让浏览器用utf8来解析返回的数据
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            //告诉servlet用UTF-8转码，而不是用默认的ISO8859
            response.setCharacterEncoding("UTF-8");
            //不需要返回值
            response.getWriter().write("../images/"+fileName);
//            return "../images/"+fileName;
            return;
        }catch (IllegalStateException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }
        logger.info("资源上传失败");
//        return "false";
    }
}
