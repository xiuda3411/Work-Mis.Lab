package cn.edu.cqupt.mislab.work.service.impl;
import cn.edu.cqupt.mislab.work.constant.ResultEnum;
import cn.edu.cqupt.mislab.work.dao.FileDao;
import cn.edu.cqupt.mislab.work.domain.entity.MyFile;
import cn.edu.cqupt.mislab.work.domain.po.Result;
import cn.edu.cqupt.mislab.work.exception.MyException;
import cn.edu.cqupt.mislab.work.service.FileService;
import cn.edu.cqupt.mislab.work.util.ResultUtil;
import cn.edu.cqupt.mislab.work.util.FileUtils;
import cn.edu.cqupt.mislab.work.util.ServiceUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

/**
 * @program: work-Mis.Lab
 * @description: 文件上传服务实现类
 * @author: 宋丽
 * @create: 2019-09-13 16:46
 **/
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FileDao fileDao;

    @Override
    public Result uploadFile(MultipartFile file) {
        try {
            String md5 = FileUtils.getFileMd5String(file);
            String flag = fileDao.comparedMd5(md5);
            if (flag != null){
                throw new MyException(ResultEnum.ISEXIST);
            }
            if (file.isEmpty()) {
                return ResultUtil.isNull();
            }
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            assert fileName != null;
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 设置文件存储路径
            String filePath = FileUtils.getFilePath(md5,fileName).getAbsolutePath();
            //输出文件夹绝对路径
            System.out.println(filePath);
            //构建真实的文件路径
            File newFile = new File(filePath);
            System.out.println(newFile.getAbsolutePath());
            //上传文件到绝对路径
            file.transferTo(newFile);
            ServiceUtil.insertSuccess(fileDao.uploadFile(fileName,filePath,md5));
            return ResultUtil.success(fileDao.getFileByMd5(md5));
        } catch (IOException | MyException e) {
            e.printStackTrace();
            return ResultUtil.error();
        }
    }

    @Override
    public Result downloadFile(Integer id, HttpServletResponse response) throws UnsupportedEncodingException {

        MyFile myFile = fileDao.getFile(id);

        if (myFile != null) {
            //设置文件路径
            File file = new File(myFile.getFilePath());
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.reset();
                String fileName = myFile.getFileName();
                fileName = new String(fileName.getBytes(), StandardCharsets.UTF_8);
                response.setHeader("Content-Disposition","attachment; filename=" + fileName);
                response.setContentType("application/octet-stream;charset=UTF-8");
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
                    return ResultUtil.success(myFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResultUtil.error();
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
        return ResultUtil.error();
    }

    @Override
    public Result uploadMultipleFiles(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            String md5 = FileUtils.getFileMd5String(file);
            File filePath = FileUtils.getFilePath(md5,file.getOriginalFilename());
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            //设置文件路径及名字
                            new File(filePath.getAbsolutePath())));
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
}
