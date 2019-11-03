package cn.edu.cqupt.mislab.work.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @program: work-Mis.Lab
 * @description: 文件上传工具
 * @author: 宋丽
 * @create: 2019-10-05 21:30
 **/
public class FileUtils {

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）

    public final static String UPLOAD_PATH_PREFIX = "static/upload";

    public static File getFilePath(String md5,String fileName){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = "src/main/resources/" + UPLOAD_PATH_PREFIX+File.separator+md5+File.separator+fileName;

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    /**
     * 获取文件的MD5值
     * @param file
     * @return
     */
    public static String getFileMd5String(MultipartFile file) {
        try {
            MessageDigest mMessageDigest = null;
            mMessageDigest = MessageDigest.getInstance("MD5");
            InputStream fis = file.getInputStream();
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) > 0) {
                mMessageDigest.update(buffer, 0, length);
            }
            fis.close();
            return new BigInteger(1, mMessageDigest.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean delFile(File file) {
        try{
            if (file.isDirectory()) {
                String[] children = file.list();
                //递归删除目录中的子目录下
                assert children != null;
                for (String aChildren : children) {
                    boolean success = delFile(new File(file, aChildren));
                    if (!success) {
                        System.out.println("删除失败");
                        return false;
                    }

                }
            }
            // 目录此时为空，可以删除
            System.out.println("删除成功");
            return file.delete();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

