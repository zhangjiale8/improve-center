package com.zjl.daily.javavoice.day20181203.lomok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Data //data 注解包含set、get、toString
@NoArgsConstructor //无参构造函数
@AllArgsConstructor //全参构造函数
public class LomokBean {
	//toString 不包括
	@ToString.Exclude 
	private String name;
	@ToString.Include
	private String id;
	@Getter
	private String phone;
	
	public LomokBean(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	//@NonNull注解标注方法和构造器的参数，如果参数为null，则会抛出空指针异常，不需要在代码中进行null检测
	public String noNull(@NonNull String name) {
		return this.getId();
	}
	
}
