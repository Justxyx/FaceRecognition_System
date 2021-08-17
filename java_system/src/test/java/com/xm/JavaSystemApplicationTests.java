
package com.xm;


		import com.fasterxml.jackson.databind.annotation.JsonAppend;
		import com.xm.entity.Group;
		import com.xm.entity.Menus;
		import com.xm.entity.User;
		import com.xm.mapper.GroupsMapper;
		import com.xm.mapper.UserMapper;
		import com.xm.service.MenusService;
		import org.apache.catalina.mbeans.GroupMBean;
		import org.junit.jupiter.api.Test;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.test.context.SpringBootTest;

		import javax.sql.DataSource;
		import java.util.List;

@SpringBootTest
class JavaSystemApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	MenusService menusService;

	@Autowired
	GroupsMapper groupsMapper;

	@Test
	public void test1(){
		List<Menus> menusAlone = menusService.findMenusAlone();
		System.out.println(menusAlone);
	}
}