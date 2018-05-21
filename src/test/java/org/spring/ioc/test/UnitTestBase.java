package org.spring.ioc.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class UnitTestBase {

	private ClassPathXmlApplicationContext context;
	private String springXmlPath;

	/**
	 * 无参构造器
	 */
	public UnitTestBase() {

	}

	/**
	 * 含参构造器
	 *
	 * @param springXmlPath
	 *            spring配置文件路径
	 */
	public UnitTestBase(String springXmlPath) {

		this.springXmlPath = springXmlPath;

	}

	/**
	 * 初始化spring配置文件
	 */
	@Before // 在@Test注解的方法执行前执行
	public void before() {

		if (StringUtils.isEmpty(springXmlPath)) {// 默认spring配置文件路径
			springXmlPath = "classpath*:spring-*.xml";
		}
		// 加载配置文件，一个context表示一个容器
		context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
		// 启动组件
		context.start();

	}

	/**
	 * 销毁spring组件
	 */
	@After // 在@Test注解的方法执行后执行
	public void after() {

		context.destroy();// 销毁组件

	}

	/**
	 * 获取spring中定义的bean实例
	 *
	 * @param beanId
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {

		return (T) context.getBean(beanId);

	}

	/**
	 * 获取spring中定义的bean实例
	 *
	 * @param clazz
	 * 
	 * @return
	 */
	protected <T extends Object> T getBean(Class<T> clazz) {

		return (T) context.getBean(clazz);

	}

}
