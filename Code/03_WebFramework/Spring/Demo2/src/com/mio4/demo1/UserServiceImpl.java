package com.mio4.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** component注解
 * 代替<bean id="userService" class="com.mio4.demo1.UserServiceImpl"></>
 */
@Component(value="userService")
public class UserServiceImpl implements UserService{

	//给name属性注入mio字符串,Setter可以省略
	@Value(value="mio")
	private String name;

	/*public void setName(String name) {
		this.name = name;
	}*/

	//将UserDaoImpl注入
	@Autowired //按照类型进行注入
	@Qualifier(value="userDao") //按照名称进行注入
	private UserDao userDao;

	@Override
	public void sayHello() {
		System.out.println("Hello " + name);
		userDao.save();
	}


}
