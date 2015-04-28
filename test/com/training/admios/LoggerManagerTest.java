package com.training.admios;

import com.training.admios.foo.LoggerFactory;
import com.training.admios.types.LogLevel;
import com.training.admios.types.LoggerType;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * Created by yohendryhurtado on 4/27/15.
 */
public class LoggerManagerTest {

    @BeforeMethod
    public void testBeforeMethod() {
        File file = new File("file.log");
        file.delete();
    }

    @Test
    public void testAdd() throws Exception {
        LoggerManager lm = new LoggerManager();
        Assert.assertEquals(lm.size(),0);
        lm.add(LoggerFactory.getLogger(LoggerType.CONSOLE, LogLevel.INFO));
        Assert.assertEquals(lm.size(), 1);
    }

    @Test
    public void testRemove() throws Exception {
        LoggerManager lm = new LoggerManager();
        lm.add(LoggerFactory.getLogger(LoggerType.CONSOLE, LogLevel.INFO));
        Assert.assertEquals(lm.size(),1);
        lm.remove(0);
        Assert.assertEquals(lm.size(),0);
    }

    @Test
    public void testInfo() throws Exception {
        LoggerManager lm = new LoggerManager();

        lm.add(LoggerFactory.getLogger(LoggerType.FILE, LogLevel.INFO, "file.log"));

        lm.info("test line");

        BufferedReader reader = new BufferedReader(new FileReader("file.log"));
        String line = reader.readLine();

        Assert.assertEquals(line, "INFO : test line");
    }

    @Test
    public void testDebug() throws Exception {
        LoggerManager lm = new LoggerManager();

        lm.add(LoggerFactory.getLogger(LoggerType.FILE, LogLevel.INFO, "file.log"));

        lm.debug("test line");

        BufferedReader reader = new BufferedReader(new FileReader("file.log"));
        String line = reader.readLine();

        Assert.assertEquals(line, "DEBUG : test line");
    }

    @Test
    public void testWarning() throws Exception {
        LoggerManager lm = new LoggerManager();

        lm.add(LoggerFactory.getLogger(LoggerType.FILE, LogLevel.INFO, "file.log"));

        lm.warning("test line");

        BufferedReader reader = new BufferedReader(new FileReader("file.log"));
        String line = reader.readLine();

        Assert.assertEquals(line, "WARNING : test line");
    }

    @Test
    public void testError() throws Exception {
        LoggerManager lm = new LoggerManager();

        lm.add(LoggerFactory.getLogger(LoggerType.FILE, LogLevel.INFO, "file.log"));

        lm.error("test line");

        BufferedReader reader = new BufferedReader(new FileReader("file.log"));
        String line = reader.readLine();

        Assert.assertEquals(line, "ERROR : test line");
    }

    @Test
    public void testLoggerLevel() throws Exception {
        LoggerManager lm = new LoggerManager();

        lm.add(LoggerFactory.getLogger(LoggerType.FILE, LogLevel.WARNING, "file.log"));
        lm.add(LoggerFactory.getLogger(LoggerType.CONSOLE, LogLevel.WARNING));

        lm.info("info line");
        lm.debug("debug line");
        lm.error("error line");

        BufferedReader reader = new BufferedReader(new FileReader("file.log"));
        String line = reader.readLine();

        Assert.assertEquals(line, "ERROR : error line");
    }

    @Test
    public void testAsyncLogger() throws Exception {
        LoggerManager lm = new LoggerManager();

        File file = new File("async.log");
        file.createNewFile();

        lm.add(LoggerFactory.getLogger(LoggerType.ASYNC, LogLevel.INFO, "async.log"));

        lm.info("info line");

        BufferedReader reader = new BufferedReader(new FileReader("async.log"));
        String line = reader.readLine();

        Assert.assertEquals(line, "INFO : info line");
    }
}