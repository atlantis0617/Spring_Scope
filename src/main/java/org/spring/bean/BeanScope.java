package org.spring.bean;

public class BeanScope {
	
	public void say () {
        
        System.out.println("hashCode:" + this.hashCode());//通过hashCode判断是否是同一个实例
         
    }
	
}
