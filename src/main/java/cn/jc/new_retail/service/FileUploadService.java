package cn.jc.new_retail.service;

import cn.jc.new_retail.entity.ReturnValue;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ljw
 * @date 2020/4/21 11:25
 */
public interface FileUploadService {
    public ReturnValue uploadFileTest(MultipartFile zipFile);
}
