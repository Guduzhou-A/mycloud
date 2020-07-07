package org.gdz.mycloud.common.base.util;

/**
 * 正则匹配工具类
 *
 * @author guduzhou
 */
public class RegexUtils {

    /**
     * 匹配手机号码, 支持+86和86开头
     */
    public static final String REGX_MOBILENUM = "^((\\+86)|(86))?(13|15|17|18)\\d{9}$";

    /**
     * 匹配邮箱帐号
     */
    public static final String REGX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

    /**
     * 密码
     */
    public static final String PWD = "^(?=.*[a-zA-Z0-9].*)(?=.*[a-zA-Z\\\\W].*)(?=.*[0-9\\\\W].*).{8,20}$";

}
