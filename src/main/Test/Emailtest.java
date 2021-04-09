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

    