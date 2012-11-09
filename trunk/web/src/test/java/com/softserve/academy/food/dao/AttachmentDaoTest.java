package com.softserve.academy.dao;

import com.softserve.academy.entity.Attachment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Transactional
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/testApplicationContext.xml"})
public class AttachmentDaoTest {

    @Autowired
    private AttachmentDao attachmentDao;

    private List<Attachment> expectedAttachmentList() {
        Attachment expectedAttachmentEntity1 = new Attachment();
        expectedAttachmentEntity1.setName("name1");
        expectedAttachmentEntity1.setPath("path1");
        Attachment expectedAttachmentEntity2 = new Attachment();
        expectedAttachmentEntity2.setName("name2");
        expectedAttachmentEntity2.setPath("path2");
        Attachment expectedAttachmentEntity3 = new Attachment();
        expectedAttachmentEntity3.setName("name3");
        expectedAttachmentEntity3.setPath("path3");
        return new ArrayList<>(Arrays.asList(expectedAttachmentEntity1, expectedAttachmentEntity2, expectedAttachmentEntity3));
    }

    @Test
    public void testAdd() throws Exception {
        Attachment expectedAttachmentEntity = new Attachment();
        expectedAttachmentEntity.setName("name1");
        expectedAttachmentEntity.setPath("path1");
        attachmentDao.add(expectedAttachmentEntity);
        assertEquals(1, attachmentDao.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        Attachment expectedAttachmentEntity = new Attachment();
        expectedAttachmentEntity.setName("name1");
        expectedAttachmentEntity.setPath("path1");
        attachmentDao.add(expectedAttachmentEntity);
        assertEquals(expectedAttachmentEntity, attachmentDao.get(expectedAttachmentEntity.getId()));
    }

    @Test
    public void testGetAll() throws Exception {
        for(Attachment attachmentEntity : expectedAttachmentList()) {
            attachmentDao.add(attachmentEntity);
        }
        assertEquals(expectedAttachmentList().size(), attachmentDao.getAll().size());
    }

    @Test
    public void testDeleteByEntity() throws Exception {
        Attachment expectedAttachmentEntity = new Attachment();
        expectedAttachmentEntity.setName("name1");
        expectedAttachmentEntity.setPath("path1");
        attachmentDao.add(expectedAttachmentEntity);
        attachmentDao.delete(expectedAttachmentEntity);
        assertEquals(0, attachmentDao.getAll().size());
    }

    @Test
    public void testDeleteById() throws Exception {
        Attachment expectedAttachmentEntity = new Attachment();
        expectedAttachmentEntity.setName("name1");
        expectedAttachmentEntity.setPath("path1");
        attachmentDao.add(expectedAttachmentEntity);
        attachmentDao.delete((long) 2);
        assertEquals(0, attachmentDao.getAll().size());
    }

}
