package cn.jc.new_retail.service.impl;


import cn.jc.new_retail.entity.ReturnCodeAndMsgEnum;
import cn.jc.new_retail.entity.ReturnValue;
import cn.jc.new_retail.service.FileUploadService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ljw
 * @date 2020/4/21 11:29
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);


    @Override
    public ReturnValue uploadFileTest(MultipartFile zipFile) {
        String targetFilePath = "D:\\idea\\IDEA space\\new_retail\\src\\main\\resources\\static\\image";
        String save = "http://localhost:8080/static/image/";
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String fileSuffix = getFileSuffix(zipFile);
        if (fileSuffix != null) {   // 拼接后缀
            fileName += fileSuffix;
        }
        //拼接地址和文件名
        String fileAddress = save+fileName;
        File targetFile = new File(targetFilePath + File.separator + fileName);


        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
            logger.info("------>>>>>>uploaded a file successfully!<<<<<<------");
        } catch (IOException e) {
            return new ReturnValue<>(-1, null);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
        return new ReturnValue<>(ReturnCodeAndMsgEnum.Success, fileAddress);

    }

//    文件上传获得文件后缀相关函数
    private String getFileSuffix(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = file.getOriginalFilename();
        int suffixIndex = fileName.lastIndexOf(".");
        if (suffixIndex == -1) {    // 无后缀
            return null;
        } else {                    // 存在后缀
            return fileName.substring(suffixIndex, fileName.length());
        }
    }



}
