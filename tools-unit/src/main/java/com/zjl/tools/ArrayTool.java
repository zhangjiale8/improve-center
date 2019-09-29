package com.zjl.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArrayTool {
	/**
	 * 将数组转成set集合；
	 * 
	 * @param arrParam
	 * @return
	 */
	public static Set<Object> aray2Set(Object[] arrParam) {
		if (null != arrParam) {
			return new HashSet<Object>(Arrays.asList(arrParam));
		}
		return null;
	}

	/**
	 * 数组中是否包含某一个值
	 * 
	 * @param param
	 * @param arrParam
	 * @return
	 */
	public static boolean isContains(Object param, Object[] arrParam) {
		if (null != arrParam && null != param) {
			return Arrays.asList(arrParam).contains(param);
		}
		return false;
	}

	/**
	 * 从array中创建list
	 * 
	 * @param arrParam
	 * @return
	 */
	public static ArrayList<Object> array2List(Object[] arrParam) {
		if (null != arrParam) {
			return new ArrayList<Object>(Arrays.asList(arrParam));
		}
		return null;
	}

	/**
	 * 从array中创建list 通过for循环
	 * 
	 * @param arrParam
	 * @return
	 */
	public static ArrayList<Object> array2ListByLoop(Object[] arrParam) {
		if (null != arrParam) {
			ArrayList<Object> list = new ArrayList<Object>();
			for (Object obj : arrParam) {
				list.add(obj);
			}
			return list;
		}
		return null;
	}

	/**
	 * int数组转成string
	 * 
	 * @param array
	 * @return
	 */
	public static String intArr2String(int[] array) {
		if (null != array) {
			return Arrays.toString(array);
		}
		return null;

	}

	/**
	 * 获取int数组长度
	 * 
	 * @param array
	 * @return
	 */
	public static int getArrayLength(int[] array) {
		if (null != array) {
			return array.length;
		}
		return 0;
	}

	/**
	 * 填充数组 (int数组)
	 * 
	 * @param paramArr
	 * @param fill
	 */
	public static void fill(int[] paramArr, int fill) {
		Arrays.fill(paramArr, fill);
	}

	/**
	 * 排序
	 * 
	 * @param paramArr
	 * @return
	 */
	public static int[] sort(int[] paramArr) {
		if (null != paramArr) {
			Arrays.sort(paramArr);
		}
		return paramArr;
	}

	/**
	 * 
	 * @param sortArr
	 * @param start
	 * @param end
	 * @return
	 */
	public static int[] sort(int[] paramArr, int start, int end) {
		if (null != paramArr && start <= paramArr.length && end <= paramArr.length && start <= end) {
			Arrays.sort(paramArr, start, end);
		}
		return paramArr;
	}

	/**
	 * int数组复制
	 * 
	 * @param paramArr
	 *            原数组
	 * @param length
	 *            新数组长度
	 * @return
	 */
	public static int[] copyof(int[] paramArr, int length) {
		if (null != paramArr && paramArr.length <= length) {
			return Arrays.copyOf(paramArr, length);
		}
		return null;
	}

	/**
	 * 
	 * @param paramArr
	 *            原数组
	 * @param start
	 *            开始下标
	 * @param end
	 *            结束下标
	 * @return
	 */
	public static int[] copyOfRange(int[] paramArr, int start, int end) {
		if (null != paramArr && start >= 0 && end < paramArr.length) {

			return Arrays.copyOfRange(paramArr, start, end);
		}
		return null;
	}

	/**
	 * 
	 * @param paramArr
	 *            原数组
	 * @param compareArr
	 *            比较数组
	 * @return
	 */
	public static boolean compareArr(int[] paramArr, int[] compareArr) {
		return Arrays.equals(paramArr, compareArr);
	}

	/**
	 * 数组去重
	 * 
	 * @param paramArr
	 *            去重数组
	 * @return
	 */
	public static int[] removeRepeat(int[] paramArr) {
		if (null != paramArr) {
			// 利用set的特性(无序，不重复)
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < paramArr.length; i++) {
				set.add(paramArr[i]);
			}
			int[] result = new int[set.size()];
			int j = 0;
			for (int i : set) {
				result[j++] = i;
			}
			return result;
		}
		return null;
	}

	/**
	 * 获取数组中最大值
	 * 
	 * @param paramArr
	 * @return
	 */
	public static int getMaxInArr(int[] paramArr) {
		if (null != paramArr) {
			int max = paramArr[0];
			for (int i = 0; i < paramArr.length; i++) {
				if (paramArr[i] > max) {
					max = paramArr[i];
				}
			}
			return max;
		}
		return 0;
	}

	/**
	 * 获取数组中最小值
	 * 
	 * @param paramArr
	 * @return
	 */
	public static int getMinInArr(int[] paramArr) {
		if (null != paramArr) {
			int min = paramArr[0];
			for (int i = 0; i < paramArr.length; i++) {
				if (paramArr[i] < min) {
					min = paramArr[i];
				}
			}
			return min;
		}
		return 0;
	}

	/**
	 * 获取两个数组中相同元素
	 * 
	 * @param param
	 * @param redArr
	 * @return
	 */
	public static int [] getSameElements(int[] param, int[] redArr) {
		if(null != param && null != redArr){
			Set<Integer> same = new HashSet<Integer>(); // 用来存放两个数组中相同的元素
			Set<Integer> temp = new HashSet<Integer>(); // 用来存放数组a中的元素

			for (int i = 0; i < param.length; i++) {
				temp.add(param[i]); // 把数组a中的元素放到Set中，可以去除重复的元素
			}

			for (int j = 0; j < redArr.length; j++) {
				// 把数组b中的元素添加到temp中
				// 如果temp中已存在相同的元素，则temp.add（b[j]）返回false
				if (!temp.add(redArr[j]))
					same.add(redArr[j]);
			}
			if(null != same && same.size() > 0){
				int [] result = new int[same.size()];
				int i = 0;
				Iterator<Integer> it = same.iterator();  
				while (it.hasNext()) {  
					result[i] = it.next();
					i++;
				}
				return result;
			}
		}
		return null;
	}
	
	/**
	 * String数组转化成int数组
	 * @param paramArr
	 * @return
	 */
	public static int[] strArr2InArr(String[] paramArr) {
		int[] ints = new int[paramArr.length];
		for (int i = 0; i < paramArr.length; i++) {
			ints[i] = Integer.parseInt(paramArr[i].trim());
		}
		return ints;
	
	}
	
	/**
	 * int数组转化成String数组
	 * @param paramArr
	 * @return
	 */
	public static String[] intArr2StrArr(int[] paramArr) {
		String[] strArr = new String[paramArr.length];
		for (int i = 0; i < paramArr.length; i++) {
			strArr[i] = paramArr[i] + "";
		}
		return strArr;
	
	}
	/**
	 * 求两个string数组的交集
	 */
	 public static String[] getIntersectArr(String[] m, String[] n)
	    {
	        List<String> rs = new ArrayList<String>();

	        // 将较长的数组转换为set
	        Set<String> set = new HashSet<String>(Arrays.asList(m.length > n.length ? m : n));

	        // 遍历较短的数组，实现最少循环
	        for (String i : m.length > n.length ? n : m)
	        {
	            if (set.contains(i))
	            {
	                rs.add(i);
	            }
	        }

	        String[] arr = {};
	        return rs.toArray(arr);
	    }

}
