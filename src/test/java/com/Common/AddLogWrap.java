package com.Common;

import org.apache.log4j.Logger;

public class AddLogWrap {
	public static final Logger LOGGER = Logger.getLogger(AddLogWrap.class);
	
	public AddLogWrap(){
		LOGGER.info("\r \n");
	}
}
