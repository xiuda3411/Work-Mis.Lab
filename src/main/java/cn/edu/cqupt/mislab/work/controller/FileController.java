package cn.edu.cqupt.mislab.work.controller;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.service.FileService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.UploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    @Resource
    private FileService fileService;

    @ApiOperation(value = "文件上传")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file,@RequestParam("userId")Integer userId, HttpServletRequest request, HttpSession session) {
            return fileService.uploadFile(file,userId);
    }

    @ApiOperation(value = "文件批量上传")
    @RequestMapping(value = "/batch",method = RequestMethod.POST)
    public Result uploadMultipleFiles(HttpServletRequest request) {
        return fileService.uploadMultipleFiles(request);
    }

    @ApiOperation(value = "文件下载")
    @RequestMapping(value = "/download",method = RequestMethod.GET)
        public Result downloadFile(Integer fid,HttpServletResponse response) {
        return fileService.downloadFile(fid,response);
    }
}
