package cn.jerio.dao;

import cn.jerio.domain.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Franky on 2018/08/02.
 */
@Repository
public class FileDaoImpl implements FileDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<File> findAll(){
        return mongoTemplate.findAll(File.class,"file");
    }

    @Override
    public Optional<File> findById(String id) {
        File file = mongoTemplate.findById(id,File.class);
        return Optional.of(file);
    }

    @Override
    public File saveFile(File f) {
        mongoTemplate.save(f,"file");
        return f;
    }

    @Override
    public void removeFile(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        mongoTemplate.remove(query,"file");
    }
}
