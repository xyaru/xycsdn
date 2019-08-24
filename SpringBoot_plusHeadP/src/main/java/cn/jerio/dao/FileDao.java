package cn.jerio.dao;

import cn.jerio.domain.File;

import java.util.List;
import java.util.Optional;

/**
 * Created by Franky on 2018/08/02.
 */
public interface FileDao {
    List<File> findAll();

    Optional<File> findById(String id);

    File saveFile(File f);

    void removeFile(String id);
}
