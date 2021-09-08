package com.xm;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.xm.entity.Infos;
import com.xm.mapper.InfosMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.sampled.Line;
import java.util.List;

@SpringBootTest
class CloudJavaSystemApplicationTests {


	@Autowired
	InfosMapper infosMapper;

	@Autowired
	Infos infos;

	@Test
	public void test1(){
		boolean b = infosMapper.deleteInfos("1");
		System.out.println(2);
	}
}
