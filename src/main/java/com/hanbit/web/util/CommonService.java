package com.hanbit.web.util;

import java.util.List;
import java.util.Map;

/**
 * @date   :2016. 7. 8.
 * @author :장종익
 * @file   :Command.java
 * @story  :
*/
public interface CommonService {
	public List<?> list();
	public List<?> findBy(String keyword);
	public int count();
	public Map<?, ?> map();
}
