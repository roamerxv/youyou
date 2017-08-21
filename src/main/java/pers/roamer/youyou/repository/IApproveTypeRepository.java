package pers.roamer.youyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pers.roamer.youyou.entity.ApproveTypeEntity;

/**
 * @author roamer - 徐泽宇
 * @create 2017-08-2017/8/8  下午5:40
 */
@Repository("pers.roamer.youyou.repository.IApproveTypeRepository")
public interface IApproveTypeRepository extends JpaRepository<ApproveTypeEntity, String>, PagingAndSortingRepository<ApproveTypeEntity, String> {
}
