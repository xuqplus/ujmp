package cn.xuqplus.ujmp.repository;

import cn.xuqplus.ujmp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
