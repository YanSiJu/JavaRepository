package com.heyong.lenrn_net.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create By Yong
 */

public class ToJsonString {
    static Logger logger = LoggerFactory.getLogger(ToJsonString.class);

    public static String ToJSONString(String Text){
        logger.info("text1:{}",Text);
        Text = Text.replaceAll("=","=\"");
        Text = Text.replaceAll(",","\",");
        Text = Text.substring(0,Text.length()-1)+"\"}";
        logger.info("text2:{}",Text);
        return Text;
    }
}
