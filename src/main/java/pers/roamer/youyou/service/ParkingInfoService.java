package pers.roamer.youyou.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pers.roamer.youyou.entity.ParkingInfoEntity;
import pers.roamer.youyou.repository.IParkingInfoRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 车位信息 service 类
 *
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/3  下午12:55
 */
@Log4j2
@Data
@Service("pers.roamer.youyou.service.ParkingInfoService")
public class ParkingInfoService {

    @Qualifier("pers.roamer.youyou.repository.IParkingInfoRepository")
    @Autowired
    IParkingInfoRepository iParkingInfoRepository;

    public List<ParkingInfoEntity> findAll() throws ServiceException {
        return iParkingInfoRepository.findAll();
    }

    public ParkingInfoEntity add(ParkingInfoEntity parkingInfoEntity) throws ServiceException {
        parkingInfoEntity.setId(UUID.randomUUID().toString());
        Timestamp timestamp = new Timestamp(new Date().getTime());
        parkingInfoEntity.setCreatedAt(timestamp);
        parkingInfoEntity.setUpdatedAt(timestamp);
        log.debug("开始保存一条停车场信息,创建时间是:{}", parkingInfoEntity.getCreatedAt());
        ParkingInfoEntity m_rtn = iParkingInfoRepository.save(parkingInfoEntity);
        return m_rtn;
    }

    public void delete(String id) throws ServiceException{
        try{
            iParkingInfoRepository.delete(id);
        }catch (Exception e){
            throw new ServiceException(e.getMessage());
        }

    }

    public ParkingInfoEntity findByID(String id) throws ServiceException{
        return iParkingInfoRepository.findById(id) ;
    }

    public void update(ParkingInfoEntity parkingInfoEntity) throws ServiceException {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        parkingInfoEntity.setUpdatedAt(timestamp);
        iParkingInfoRepository.save(parkingInfoEntity);
    }
}
