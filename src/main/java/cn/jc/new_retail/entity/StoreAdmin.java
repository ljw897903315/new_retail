package cn.jc.new_retail.entity;

import lombok.Data;

/**
 * @author ljw
 * @date 2020/4/13 15:43
 */
@Data
public class StoreAdmin {
    /**
     * 管理员ID
     */
    private String storeAdminId;

    /**
     * 门店名称
     */
    private String storeName;

    /**
     * 管理员姓名
     */
    private String adminName;


    /**
     * 管理员性别
     */
    private Integer gender;

    /**
     * 管理员电话
     */
    private String adminPhone;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 非全参数构造
     * @param adminName 管理员姓名
     * @param gender  性别
     * @param adminPhone  管理员电话
     */
    public StoreAdmin(String adminName, Integer gender, String adminPhone) {
        this.adminName = adminName;
        this.gender = gender;
        this.adminPhone = adminPhone;
    }
}
