package pers.roamer.youyou.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.roamer.youyou.entity.ParkingTypeEntity;
import pers.roamer.youyou.repository.IParkingTypeRepository;

import java.util.List;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/8  下午5:57
 */
@Log4j2
@Data
@Service("pers.roamer.youyou.service.ParkingTypeService")
public class ParkingTypeService {
    @Qualifier("pers.roamer.youyou.repository.IParkingTypeRepository")
    @Autowired
    IParkingTypeRepository iParkingTypeRepository;

    public List<ParkingTypeEntity> findAll() {
        return iParkingTypeRepository.findAll();
    }
}
