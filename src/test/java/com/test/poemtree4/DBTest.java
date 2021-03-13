package com.test.poemtree4;

import java.util.UUID;

import com.test.poemtree4.poem.FolderObject;
import com.test.poemtree4.poem.PoemConfig;
import com.test.poemtree4.poem.PoemObject;
import com.test.poemtree4.poem.PoemRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class DBTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(PoemConfig.class);

    PoemRepository pr = ac.getBean("poemRepository", PoemRepository.class);

    /*
    @Test
    void admintableTest(){
        int initRowNum = pr.findAllA().size();
        String tableName = "testName";
        pr.insertA(tableName);
        int newRowNum = pr.findAllA().size();
        Assertions.assertThat(newRowNum).isEqualTo(initRowNum + 1);
        int newRowIndex = 0;
        for( FolderObject f : pr.findAllA()){
            if(f.getTableName().equals(tableName)){
                newRowIndex = f.getTableId();
            }
        }
        String newTableName = "newTestName";
        pr.updateNameA(newRowIndex, newTableName);
        int newRowIndex2 = 0;
        for( FolderObject f : pr.findAllA()){
            if(f.getTableName().equals(newTableName)){
                newRowIndex2 = f.getTableId();
            }
        }
        Assertions.assertThat(newRowIndex2).isEqualTo(newRowIndex).isNotEqualTo(0);
        pr.deleteA(newRowIndex);
        int newRowNum2 = pr.findAllA().size();
        Assertions.assertThat(newRowNum2).isEqualTo(initRowNum);

    }

    @Test
    void workingtable(){
        pr.insertW(1, "a");
        pr.insertW(1, "b");
        pr.insertW(1, "c");
        
        Assertions.assertThat(pr.findByIdW(1).size()).isEqualTo(3);

        pr.deleteContentW("a");

        Assertions.assertThat(pr.findByIdW(1).size()).isEqualTo(2);

        pr.deleteFolderW(1);

        Assertions.assertThat(pr.findByIdW(1).size()).isEqualTo(0);
    }

    @Test
    void workingtable2(){
        pr.insertW(1, "a");

        PoemObject p = new PoemObject();
        p.setContentId("a");
        p.setTitle("title");
        p.setBody("body");
        p.setDate("date");

        pr.updateAnyW(p);

        Assertions.assertThat(pr.findByIdW(1).get(0).getTitle()).isEqualTo("title");

        pr.deleteFolderW(1);

    }


    @Test
    void folderTable(){
        
        pr.insertW(1, "a");
        pr.createTableF(1);
        
        PoemObject p1 = new PoemObject();
        p1.setContentId("a");
        p1.setTitle("title1");
        p1.setBody("body1");
        p1.setDate("date1");

        PoemObject p2 = new PoemObject();
        p2.setContentId("a");
        p2.setTitle("title2");
        p2.setBody("body2");
        p2.setDate("date2");

        PoemObject p3 = new PoemObject();
        p3.setContentId("a");
        p3.setTitle("title3");
        p3.setBody("body3");
        p3.setDate("date3");

        pr.insertF(1, p1);
        pr.insertF(1, p2);
        pr.insertF(1, p3);

        Assertions.assertThat(pr.findByContentIdF(1, "a").size()).isEqualTo(3);

        for(PoemObject po : pr.findByContentIdF(1, "a")){
            System.out.println(po.toString());
        }

        pr.eraseF(1, "date3");

        for(PoemObject po : pr.findByContentIdF(1, "a")){
            System.out.println(po.toString());
        }

        Assertions.assertThat(pr.findByContentIdF(1, "a").size()).isEqualTo(2);

        pr.deleteByContentIdF(1, "a");

        Assertions.assertThat(pr.findByContentIdF(1, "a").size()).isEqualTo(0);

        pr.deleteTableF(1);
        pr.deleteFolderW(1);
    }
*/


}
