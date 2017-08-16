package pers.roamer.youyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pers.roamer.youyou.entity.ParkingTypeEntity;

@Repository("pers.roamer.youyou.repository.IParkingTypeRepository")
public interface IParkingTypeRepository  extends JpaRepository<ParkingTypeEntity, String>, PagingAndSortingRepository<ParkingTypeEntity, String> {
}
