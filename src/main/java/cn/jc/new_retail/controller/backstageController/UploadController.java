package cn.jc.new_retail.controller.backstageController;

import cn.jc.new_retail.entity.ReturnValue;
import cn.jc.new_retail.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ljw
 * @date 2020/4/21 11:15
 */
@RestController
@RequestMapping(value = "/aop")
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 文件上传测试接口
     * @return
     */
    @RequestMapping("/upload")
    public ReturnValue uploadFileTest(@RequestParam("uploadFile") MultipartFile zipFile) {
        return fileUploadService.uploadFileTest(zipFile);
    }

}
