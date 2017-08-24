package pers.roamer.youyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pers.roamer.youyou.entity.ParkingInfoEntity;
import pers.roamer.youyou.entity.ParkingTypeEntity;

import java.util.List;

@Repository("pers.roamer.youyou.repository.IParkingInfoRepository")
public interface IParkingInfoRepository extends JpaRepository<ParkingInfoEntity, String>, PagingAndSortingRepository<ParkingInfoEntity, String> {
    ParkingInfoEntity findById(String id);

    List<ParkingInfoEntity> findByParkingTypeByParkingType(ParkingTypeEntity parkingTypeEntity);

    List<ParkingInfoEntity> findByParkingTypeByParkingTypeNot(ParkingTypeEntity parkingTypeEntity);
}
