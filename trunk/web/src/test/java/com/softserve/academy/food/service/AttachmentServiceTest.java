package com.softserve.academy.service;

import com.softserve.academy.model.AttachmentModel;
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
public class AttachmentServiceTest {

    @Autowired
    private AttachmentService attachmentService;

    private List<AttachmentModel> expectedAttachmentList() {
        AttachmentModel expectedAttachment1 = new AttachmentModel();
        expectedAttachment1.setName("name1");
        expectedAttachment1.setPath("path1");
        AttachmentModel expectedAttachment2 = new AttachmentModel();
        expectedAttachment2.setName("name2");
        expectedAttachment2.setPath("path2");
        AttachmentModel expectedAttachment3 = new AttachmentModel();
        expectedAttachment3.setName("name3");
        expectedAttachment3.setPath("path3");
        return new ArrayList<>(Arrays.asList(expectedAttachment1, expectedAttachment2, expectedAttachment3));
    }

    @Test
    public void setModel() throws Exception {
        AttachmentModel expectedAttachment = new AttachmentModel();
        expectedAttachment.setName("name1");
        expectedAttachment.setPath("path1");
        assertEquals(expectedAttachment, attachmentService.setModel(expectedAttachment.getName(), expectedAttachment.getPath()));
    }

    @Test
    public void testAdd() throws Exception {
        AttachmentModel expectedAttachment = new AttachmentModel();
        expectedAttachment.setName("name1");
        expectedAttachment.setPath("path1");
        attachmentService.add(expectedAttachment);
        assertEquals(1, attachmentService.getAll().size());
    }

    @Test
    public void testGet() throws Exception {
        AttachmentModel expectedAttachment = new AttachmentModel();
        expectedAttachment.setId((long)4);
        expectedAttachment.setName("name1");
        expectedAttachment.setPath("path1");
        attachmentService.add(expectedAttachment);
        assertEquals(expectedAttachment, attachmentService.get(expectedAttachment.getId()));
    }

    @Test
    public void testGetAll() throws Exception {
        for(AttachmentModel attachment : expectedAttachmentList()) {
            attachmentService.add(attachment);
        }
        assertEquals(expectedAttachmentList().size(), attachmentService.getAll().size());
    }

    @Test
    public void testDeleteByEntity() throws Exception {
        AttachmentModel expectedAttachment = new AttachmentModel();
        expectedAttachment.setId((long)1);
        expectedAttachment.setName("name1");
        expectedAttachment.setPath("path1");
        attachmentService.add(expectedAttachment);
        attachmentService.delete(expectedAttachment);
        assertEquals(0, attachmentService.getAll().size());
    }

    @Test
    public void testDeleteById() throws Exception {
        AttachmentModel expectedAttachment = new AttachmentModel();
        expectedAttachment.setName("name1");
        expectedAttachment.setPath("path1");
        attachmentService.add(expectedAttachment);
        attachmentService.delete((long) 2);
        assertEquals(0, attachmentService.getAll().size());
    }

}
