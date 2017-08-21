package pers.roamer.youyou.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.roamer.youyou.entity.ApproveTypeEntity;
import pers.roamer.youyou.repository.IApproveTypeRepository;

import java.util.List;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/8  下午5:57
 */
@Log4j2
@Data
@Service("pers.roamer.youyou.service.ApproveTypeService")
public class ApproveTypeService {
    @Qualifier("pers.roamer.youyou.repository.IApproveTypeRepository")
    @Autowired
    IApproveTypeRepository iApproveTypeRepository;

    public List<ApproveTypeEntity> findAll() {
        return iApproveTypeRepository.findAll();
    }
}
