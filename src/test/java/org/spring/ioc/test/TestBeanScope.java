package org.spring.ioc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.spring.bean.BeanScope;

@RunWith(BlockJUnit4ClassRunner.class) // 指定JUnit默认执行类
public class TestBeanScope extends UnitTestBase {

	public TestBeanScope() {// 通过构造方法传入spring配置文件路径

		super("classpath*:spring-beanScope.xml");

	}

	@Test
	public void testScope() {

		BeanScope beanScope = super.getBean("beanScope");
		beanScope.say();

		/**
		 * 若在两个方法中执行这两行代码，则hashCode会不同。
		 * 因为每个test方法执行前都会执行@Before,会重新加载spring配置文件，此时是在两个容器中，所以不同
		 */
		BeanScope beanScope2 = super.getBean("beanScope");
		beanScope2.say();

	}

}
