
package com.xm;


		import com.xm.entity.*;
		import com.xm.mapper.CameraInfoMapper;
		import com.xm.mapper.GroupsMapper;
		import com.xm.mapper.TimeTestMapper;
		import com.xm.mapper.UserMapper;
		import com.xm.service.MenusService;
		import org.junit.jupiter.api.Test;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.context.SpringBootTest;
		import org.springframework.web.client.RestTemplate;

		import javax.jws.soap.SOAPBinding;
		import java.text.ParseException;
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

	@Test
	void test4(){
		long userId	= 1;
		String url = "http://192.168.0.101:8082/delete";
		RestTemplate restTemplate = new RestTemplate();
		Boolean b = restTemplate.postForObject(url,userId, Boolean.class);

	}

	@Autowired
	User user;

	@Test
	void  test5(){
		user.setUserId("2021");
		user.setUserPassword("1234");
		Boolean aBoolean = null;
		try {
			aBoolean = userMapper.addUser(user);
		} catch (Exception e) {
			System.out.println("------------------");
			e.printStackTrace();
			System.out.println("------------------");
		}
		System.out.println(aBoolean);
	}
}