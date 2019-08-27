package cn.jerio.service.impl;

import cn.jerio.dao.FileDao;
import cn.jerio.domain.File;
import cn.jerio.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Franky on 2018/08/02.
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;

    @Override
    public List<File> findAll() {
        return fileDao.findAll();
    }

    @Override
    public Optional<File> findById(String id) {
        return fileDao.findById(id);
    }

    @Override
    public File saveFile(File f) {
        return fileDao.saveFile(f);
    }

    @Override
    public void removeFile(String id) {
        fileDao.removeFile(id);
    }
}
