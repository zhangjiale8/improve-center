package com.zjl.lottery.combine.vo;

public enum ScreenTypEnum {
	RED("red", "红球"), BLUE("blue", "蓝球");
	// 防止字段值被修改，增加的字段也统一final表示常量
	private final String key;
	private final String value;

	private ScreenTypEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	// 根据key获取枚举
	public static ScreenTypEnum getEnumByKey(String key) {
		if (null == key) {
			return null;
		}
		for (ScreenTypEnum temp : ScreenTypEnum.values()) {
			if (temp.getKey().equals(key)) {
				return temp;
			}
		}
		return null;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

}
