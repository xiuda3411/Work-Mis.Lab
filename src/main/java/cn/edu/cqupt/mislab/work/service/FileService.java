package cn.edu.cqupt.mislab.work.service;

import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public interface FileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
    Result uploadFile(MultipartFile file);

    /**
     * 文件下载
     * @param id
     * @return
     */
    Result downloadFile(Integer id, HttpServletResponse response) throws UnsupportedEncodingException;

    /**
     * 批量文件上传
     * @param request
     * @return
     */
    Result uploadMultipleFiles(HttpServletRequest request);
}
