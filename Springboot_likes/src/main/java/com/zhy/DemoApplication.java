package com.zhy;

import com.zhy.model.ArticleLikesRecord;
import com.zhy.repository_rest.LikesRepository;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;

@MapperScan("com.zhy.mapper")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class DemoApplication {
    @Qualifier("likesRepository")
    @Autowired
    public MongoRepository likesRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @PostConstruct
    public void init() {
        long defaultLikesNum = likesRepository.count();
        if (defaultLikesNum == 0) {
            ArticleLikesRecord defaultPad = new ArticleLikesRecord(2,1,"2019-08-28");
            likesRepository.save(defaultPad);
        }



    }
}
