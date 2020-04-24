package cn.jc.new_retail.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljw
 * @date 2020/4/10 11:21
 */
@Data

public class Store implements Serializable {
    /**
     * 编号
     */
    @Length(max = 64)
    private String storeId;

    /**
     * 门店名称
     */
    @Length(max = 32)
    private String storeName;

    /**
     * 纬度
     */
    private Double storeLatitude;

    /**
     * 经度
     */
    private Double storeLongitude;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 门店地址
     */
    @Length(max = 150)
    private String storeAddress;

    /**
     * 门店地址补充地址
     */
    @Length(max = 100, message = "门店地址过长")
    private String storeAddressDetail;

    /**
     * 门店管理员id
     */
    @Length(max = 64)
    private String storeAdminId;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 管理员手机
     */
//    @Phone
    private String adminPhone;

    /**
     * 门店账号
     */
    @Length(max = 64)
    private String storeLoginName;

    /**
     * 门店密码
     */
    @Length(max = 64)
    private String storePassword;

    /**
     * 创建人
     */
    @Length(max = 64)
    private String creator;

    /**
     * 门店联系电话
     */
    @Length(max = 11)
//    @Phone
    private String storePhone;

    /**
     * 门店状态
     */
    private String state;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 准备封装返回给查询附近的门店是的信息
     * @param storeName 门店名称
     * @param storeLatitude 纬度
     * @param storeLongitude 经度
     * @param storeAddress 地址
     * @param storePhone 电话
     */
    public Store(@Length(max = 32) String storeName, Double storeLatitude, Double storeLongitude, @Length(max = 150) String storeAddress,  @Length(max = 11) String storePhone) {
        this.storeName = storeName;
        this.storeLatitude = storeLatitude;
        this.storeLongitude = storeLongitude;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
    }

    public Store() {
    }
}
