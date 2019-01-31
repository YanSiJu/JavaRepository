package com.heyong.lenrn_net.Controller;

import com.heyong.lenrn_net.POJO.Resource;
import com.heyong.lenrn_net.Service.CollectService;
import com.heyong.lenrn_net.Service.ResourceService;
import com.sun.deploy.net.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**下载文件
 * Create By Yong
 */

@Controller
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CollectService collectService;

    private static Logger logger = LoggerFactory.getLogger(DownloadController.class);

    @RequestMapping("/downloading")
    public String DowanloadImg(){
        return "downloading";
    }


    //文件下载相关代码
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response,@RequestParam("resourceAddress") String resourceAddress) {
        logger.info("Address:{}",resourceAddress);

        //按“\”分割字符串
        String[] nameList = resourceAddress.split("\\\\");

        String fileName = nameList[nameList.length-1];

        logger.info("fileName:{}",fileName);
        if (fileName != null) {
            //设置文件路径
            String realPath = resourceAddress;
            File file = new File(realPath);
            if (file.exists()) {
                response.setContentType("application/force-download");
                // 设置强制下载不打开
                try{
                    fileName = new String(fileName.getBytes("GB2312"),"ISO8859-1");
                    response.addHeader("Content-Disposition", "attachment;fileName="+fileName);
                }catch (Exception e){

                }


                // 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    logger.info("下载成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try { bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } if (fis != null) {
                        try { fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
