package com.txl.until;

import java.util.Collection;

public class ValidateUtils {

	/**
	 * �жϼ����Ƿ���Ч
	 * @return
	 */
	public static boolean isValidate(Collection<?> cll){
		if(cll==null||cll.isEmpty()){
			return false;
		}
		return true;
	}
	
}
