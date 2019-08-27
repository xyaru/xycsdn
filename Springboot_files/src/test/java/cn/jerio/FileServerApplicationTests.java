package cn.jerio;

import cn.jerio.domain.File;
import cn.jerio.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServerApplicationTests {

	@Autowired
	FileService fileService;

	@Test
	public void contextLoads() {
	}


	@Test
	public void findAll(){
		List<File> files = fileService.findAll();
		System.out.println(files);
	}

	@Test
	public void save(){

	}

	@Test
	public void remove(){
		fileService.removeFile("5b62ace3c1748e0bb0183638");
	}
}
