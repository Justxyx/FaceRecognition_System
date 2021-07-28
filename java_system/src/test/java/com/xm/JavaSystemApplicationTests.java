
package com.xm;


		import com.fasterxml.jackson.databind.annotation.JsonAppend;
		import com.xm.entity.Menus;
		import com.xm.entity.User;
		import com.xm.mapper.UserMapper;
		import com.xm.service.MenusService;
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

	@Test
	public void test1(){
		List<Menus> allOne = menusService.findAllMenus();
		System.out.println(allOne);
	}
}