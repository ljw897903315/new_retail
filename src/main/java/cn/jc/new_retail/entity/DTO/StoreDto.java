package cn.jc.new_retail.entity.DTO;

import cn.jc.new_retail.entity.Store;
import lombok.Data;

import java.io.Serializable;

/**
 * 门店基本信息以及用户距离当前门店的距离
 * @author ljw
 * @date 2020/4/22 14:02
 */
@Data
public class StoreDto implements Serializable {
    //门店基本信息
    private Store store;
    //客户和门店的距离
    private String distance;

    public StoreDto(Store store, String distance) {
        this.store = store;
        this.distance = distance;
    }

    public StoreDto() {
    }
}
