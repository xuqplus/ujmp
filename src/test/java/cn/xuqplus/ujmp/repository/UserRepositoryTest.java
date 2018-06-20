package cn.xuqplus.ujmp.repository;

import cn.xuqplus.ujmp.UjmpApplicationTests;
import cn.xuqplus.ujmp.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

public class UserRepositoryTest extends UjmpApplicationTests {
    @Autowired
    UserRepository userRepository;

    @Test
    public void aa() {
        User user = new User();
        user.setName("haha");
        userRepository.save(user);
    }


    @Test
    public void bb() {
        User user = userRepository.findById(1L).get();
        System.out.println(user);
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Test
    @Transactional
    public void cc() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.createNativeQuery("truncate table `user`").executeUpdate();
        transaction.commit();
        this.bb();
    }
}