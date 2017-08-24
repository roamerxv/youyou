package pers.roamer.youyou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pers.roamer.youyou.entity.UserEntity;

@Repository("pers.roamer.youyou.repository.IUserRepository")
public interface IUserRepository extends JpaRepository<UserEntity, String>, PagingAndSortingRepository<UserEntity, String> {
}
