package math.design.base.controller;

import java.util.Random;

import math.design.util.Mail;
import math.design.util.MailUtil;

public class TestController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int x = random.nextInt(899999)+100000;
		String p = Integer.toString(x);
		StringBuffer content = new StringBuffer();
		content.append(p);
		Mail mail = new Mail();  
        mail.setHost("smtp.163.com"); // 设置邮件服务器,如果不用163的,自己找找看相关的  
        mail.setSender("gu_can123@163.com");  
        mail.setReceiver("gu_can123@163.com"); // 接收人  
        mail.setUsername("gu_can123@163.com"); // 登录账号,一般都是和邮箱名一样吧  
        mail.setPassword("29871413qing"); // 发件人邮箱的登录密码  
        mail.setSubject("数学科学学院学生信息管理系统 初始密码");  
        mail.setMessage(content.toString());  
        new MailUtil().send(mail);  
	}

}
