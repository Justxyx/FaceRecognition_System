
package com.xm;


		import com.fasterxml.jackson.databind.annotation.JsonAppend;
		import com.xm.entity.*;
		import com.xm.mapper.CameraInfoMapper;
		import com.xm.mapper.GroupsMapper;
		import com.xm.mapper.TimeTestMapper;
		import com.xm.mapper.UserMapper;
		import com.xm.service.MenusService;
		import org.apache.catalina.mbeans.GroupMBean;
		import org.junit.jupiter.api.Test;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.context.SpringBootTest;

		import javax.sql.DataSource;

		import java.sql.Timestamp;
		import java.text.ParseException;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.List;

@SpringBootTest
class JavaSystemApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	MenusService menusService;

	@Autowired
	GroupsMapper groupsMapper;

	@Autowired
	TimeTestMapper timeTestMapper;

	@Autowired
	CameraInfoMapper cameraInfoMapper;
	@Test
	public void test1() throws ParseException {
//		java.util.Date date = new java.util.Date();          // 获取一个Date对象
//		Timestamp timeStamp = new Timestamp(date.getTime());     //   讲日期时间转换为数据库中的timestamp类型
//		System.out.println(timeStamp);
//		timeTestMapper.add(timeStamp);

//		List<TestTime> testTimeList = (List<TestTime>) timeTestMapper.find();
////
////		System.out.println("----------------------------");
////		Timestamp times = testTimeList.get(0).getTimes();
//////		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//////		String format = simpleDateFormat.format(times);
//////		System.out.println(format);
////		System.out.println(times);
////		timeTestMapper.add(times);

		List<CameraInfo> allCameraInfo = cameraInfoMapper.getAllCameraInfo();
		CameraInfo cameraInfo = allCameraInfo.get(0);
		System.out.println(cameraInfo);

	}
}