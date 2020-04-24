package cn.jc.new_retail.service.impl;

import cn.jc.new_retail.entity.Store;
import cn.jc.new_retail.mapper.StoreMapper;
import cn.jc.new_retail.service.StoreService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author ljw
 * @date 2020/4/14 10:35
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> listStore(Integer pageNum, Integer pageRow, String name) {
        PageHelper.startPage(pageNum, pageRow);

        return storeMapper.listStore(pageNum,pageRow,name);
    }

    @Override
    public Boolean updateStore(Store store) {
        return storeMapper.updateStore(store);
    }

    @Override
    public Boolean enableStore(String storeId, Boolean isEnable) {
        return storeMapper.enableStore(storeId, isEnable);
    }

    @Override
    public Store loadStoreAdmin(String storeId) {
        return storeMapper.loadStoreAdmin(storeId);
    }

    @Override
    public Boolean deleteStore(String storeId) {
        return storeMapper.deleteStore(storeId);
    }

    @Override
    public Boolean addStore(Store store) {
        return storeMapper.addStore(store);
    }
}
