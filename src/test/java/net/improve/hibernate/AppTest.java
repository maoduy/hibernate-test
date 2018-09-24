package net.improve.hibernate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.sql.NClob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;
import org.hibernate.engine.jdbc.NClobProxy;
import org.junit.Before;
import org.junit.Test;

import net.improve.hibernate.Gender;
import net.improve.hibernate.HibernateUtil;
import net.improve.hibernate.Job;
import net.improve.hibernate.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   
	@Before
	public void init() {
		// Extend the clob column length, instead of 255 by default
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.createSQLQuery("alter table public.user alter column clob clob").executeUpdate();
    	session.createSQLQuery("alter table public.user alter column stringLob clob").executeUpdate();
    	session.createSQLQuery("alter table public.user alter column charArr clob").executeUpdate();
    	session.getTransaction().commit();
    	session.close();
	}
	
    @Test
    public void testSaveAndGetMethod() throws IOException, SQLException
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	User user = new User();
    	
    	user.setUserId(2);
    	user.setUsername("Mukesh");
    	user.setCreatedBy("Google");
    	user.setCreatedDate(new Date());
    	user.setGender(Gender.MALE);
    	user.setJob(Job.BOSS);
    	
    	File image = new File(getClass().getClassLoader().getResource("59226334_87658369.jpg").getFile());
    	File jpTextFile = new File(getClass().getClassLoader().getResource("jp.txt").getFile());
    	String jpText = Files.readAllLines(jpTextFile.toPath()).get(0);
    	byte[] imageBytes = Files.readAllBytes(image.toPath());
    	String imageBase64String = Base64.getEncoder().encodeToString(imageBytes);
    	
    	user.setBlob(BlobProxy.generateProxy(imageBytes));
    	user.setByteArrLob(imageBytes);
    	user.setClob(ClobProxy.generateProxy(imageBase64String));
    	user.setStringLob(imageBase64String);
    	user.setCharArr(imageBase64String.toCharArray());
    	user.setNclob(NClobProxy.generateProxy(jpText));
    	Integer userId = (Integer) session.save(user);
    	session.getTransaction().commit();
    	
    	User u = (User) session.get(User.class, userId);
    	
    	assertEquals(Gender.MALE, u.getGender());
    	assertEquals(Job.BOSS, user.getJob());
    	
    	try (InputStream is = u.getBlob().getBinaryStream()) {
    		// Blob, use stream
    		assertArrayEquals(imageBytes, IOUtils.toByteArray(is));
    	}
    	
    	// Blob, use getBytes
    	assertArrayEquals(imageBytes, u.getBlob().getBytes(1L, (int)(u.getBlob().length())));
    	
    	// byte[]
    	assertArrayEquals(imageBytes, u.getByteArrLob());
    	
    	// Clob
    	try (Reader reader = u.getClob().getCharacterStream()) {
    		assertEquals(imageBase64String, IOUtils.toString(reader));
    	}
    	
    	// Blob string
    	assertEquals(imageBase64String, u.getStringLob());
    	
    	// Char array
    	assertEquals(imageBase64String, new String(u.getCharArr()));
    	
    	// NClob
    	try (Reader reader = u.getNclob().getCharacterStream()) {
    		assertEquals(jpText, IOUtils.toString(reader));
    	}
    	
    	
    	session.close();
    }
}
