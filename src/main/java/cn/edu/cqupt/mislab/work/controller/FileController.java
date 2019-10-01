package cn.edu.cqupt.mislab.work.controller;

import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 文件上传控制类
 * @author: 宋丽
 * @create: 2019-09-13 16:21
 **/
@Api("文件")
@RestController
@RequestMapping("/File")
@EnableRedisHttpSession
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @ApiOperation(value = "文件上传")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResultUtil.notExist();
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            log.info("上传的文件名为：" + fileName);
            // 获取文件的后缀名
            assert fileName != null;
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            log.info("文件的后缀名为：" + suffixName);
            // 设置文件存储路径
            String filePath = "/Users/dalaoyang/Downloads/";
            String path = filePath + fileName;
            File dest = new File(path);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                if (dest.getParentFile().mkdirs()){
                    file.transferTo(dest);
                    return ResultUtil.success();
                }
            }
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }

    @ApiOperation(value = "文件批量上传")
    @RequestMapping(value = "/batch",method = RequestMethod.POST)
    public Result handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String filePath = "/Users/dalaoyang/Downloads/";
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            //设置文件路径及名字
                            new File(filePath + file.getOriginalFilename())));
                    // 写入
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    HashMap<String,String> info = new HashMap<>(2);
                    info.put("第 " + i + " 个文件上传失败 ==> ",e.getMessage());
                    return ResultUtil.error(info);

                }
            } else {
                HashMap<String,String> info = new HashMap<>(2);
                info.put("第 " + i + " 个文件上传失败 ==> ","上传失败因为文件为空");
                return ResultUtil.error(info);
            }
        }
        return ResultUtil.success();
    }

    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        // 文件名
        String fileName = "dalaoyang.jpeg";
        if (fileName != null) {
            //设置文件路径
            File file = new File("/Users/dalaoyang/Documents/dalaoyang.jpeg");
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
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
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}
