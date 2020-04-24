package cn.jc.new_retail.mapper;

import cn.jc.new_retail.entity.Store;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author ljw
 * @date 2020/4/10 16:28
 */
@Repository
public interface StoreMapper {
    /**
     * 查询门店
     * @param pageNum 分页页数
     * @param pageRow 分页显示条数
     * @param storeName 门店名称，可为空
     * @return
     */
    List<Store> listStore(Integer pageNum,Integer pageRow,String storeName);

    /**
     * 编辑门店信息
     * @param store
     * @return
     */
    Boolean updateStore(Store store);

    /**
     * 启用关闭门店
     * @param storeId 门店id
     * @param isEnable 是否启用
     * @return
     */
    Boolean enableStore(String storeId,Boolean isEnable);

    /**
     * 根据门店id查询门店管理员信息
     * @param storeId 门店id
     * @return
     */
    Store loadStoreAdmin(String storeId);

    /**
     * 根据门店id删除门店
     * @param storeId  门店id
     * @return
     */
    Boolean deleteStore(String storeId);

    /**
     * 添加门店
     * @param store 门店对象
     * @return
     */
    Boolean addStore(Store store);

}
