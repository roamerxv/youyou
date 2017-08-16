package pers.roamer.youyou.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.roamer.youyou.entity.LivingTypeEntity;
import pers.roamer.youyou.repository.ILivingTypeRepository;

import java.util.List;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/8  下午5:57
 */
@Log4j2
@Data
@Service("pers.roamer.youyou.service.LivingTypeService")
public class LivingTypeService {
    @Qualifier("pers.roamer.youyou.repository.ILivingTypeRepository")
    @Autowired
    ILivingTypeRepository iLivingTypeRepository;

    public List<LivingTypeEntity> findAll() {
        return iLivingTypeRepository.findAll();
    }
}
