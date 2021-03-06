package org.apache.commons.mail;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;

import com.sun.tools.javac.util.Assert;
import com.sun.tools.javac.util.List;
import static org.junit.Assert.assertEquals;


public class Emailtest {
	
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", 
			"abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
			
			email = new EmailConcrete();
			
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}

    @Test
	public void testAddBcc() throws Exception{
		
		email.addBcc(TEST_EMAILS);
		assertEquals(3, email.getBccAddresses().size());
	}
    @Test
	public void testgetHostName()
	{
		email.setHostName("localhost");
		
		String hostname=email.getHostName();
		
		assertEquals("localhost", hostname);
		
	}

    @Test
	public void testgetHostNamewithnull()
	{
		email.setHostName(null);
		
		String hostname=email.getHostName();
		
		assertEquals(null, hostname);
		
	}
	
    public void testgetHostNamewithsession()
	{
		Properties properties=new Properties();
		Session session=Session.getDefaultInstance(properties, null);
		properties.put(EmailConstants.MAIL_HOST, "smtp.gmail.com");
		email.setMailSession(session);
		assertEquals("smtp.gmail.com", email.getHostName());
		
	}

    @Test
	public void testaddCC() throws EmailException
	{
		email.addCc("123@gmail.com");
		assertEquals("123@gmail.com", email.getCcAddresses());
		
	}

    @Test
	public void testaddHeader()
	{
		email.addHeader("header", "value");
		
	}

    @Test
	public void testaddHeadernamenull()
	{
		email.addHeader(null, "value");
		
	}

    @Test
	public void testaddHeadervaluenull()
	{
		email.addHeader("header", null);
		
	}
	
    @Test
	public void testaddReplyTo() throws EmailException
	{
		email.addReplyTo("123@gmail.com", "thanks");
		
	}

    @Test
	public void testbuildMimeMessage() throws EmailException
	{
		email.addCc(TEST_EMAILS);
		
		email.buildMimeMessage();
	}

    @Test
	public void testgetMailSession() throws EmailException
	{
		Properties properties=new Properties();
		Session session=Session.getDefaultInstance(properties, null);
		properties.put(EmailConstants.MAIL_HOST, "smtp.gmail.com");
		email.setMailSession(session);
		email.getMailSession();
	}

    @Test
	public void testgetSocketConnectionTimeout()
	{
		email.setSocketConnectionTimeout(15);
		assertEquals(15, email.getSocketConnectionTimeout());
	}
	
    @Test
	public void testsetFromm() throws EmailException
	{
		email.setFrom("Froms@gmail.com");
	}
	
    @Test
	public void testgetSentDatenull()
	{
		email.setSentDate(null);
		email.getSentDate();
	}
    @Test
	public void testgetSentDate()
	{
		Date today = new Date(12);
		email.setSentDate(today);
		email.getSentDate();
	}