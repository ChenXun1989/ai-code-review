package controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wiki.chenxun.ai.code.review.boot.Application;
import wiki.chenxun.ai.code.review.boot.controller.GitlabController;
import wiki.chenxun.ai.code.review.boot.controller.req.GitlabMergeRequestEvent;
import wiki.chenxun.ai.code.review.boot.controller.res.GitLabMergeContentRes;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class GitlabControllerTest {


    @Autowired
    private GitlabController gitlabController;



    @Test
    public void testMergeEvent(){
        int projectId=3748;
        int mergeRequestId=133;

        List<GitLabMergeContentRes> res= gitlabController.getMergeContentResResponseEntity(projectId,mergeRequestId);

        Assertions.assertNotNull(res);



    }

    @Test
    public void testMergeEvent2(){

        GitlabMergeRequestEvent event=new GitlabMergeRequestEvent();
        GitlabMergeRequestEvent.Project project=new GitlabMergeRequestEvent.Project();
        project.setId(3748);

        event.setProject(project);
        GitlabMergeRequestEvent.ObjectAttributes objectAttributes =  new GitlabMergeRequestEvent.ObjectAttributes();
        objectAttributes.setIid(133);
        event.setObjectAttributes(objectAttributes);
        gitlabController.onMergeEvent(event);

    }





}