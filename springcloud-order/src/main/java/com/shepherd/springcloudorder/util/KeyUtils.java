package com.shepherd.springcloudorder.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author fjzheng
 * @version 1.0
 * @date 2020/4/19 17:33
 */
public class KeyUtils {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;
        return format+ String.valueOf(number);
    }
}
