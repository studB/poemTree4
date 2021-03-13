package com.test.poemtree4;

import static org.mockito.ArgumentMatchers.refEq;

import javax.swing.text.AbstractDocument.Content;

import com.test.poemtree4.poem.PoemController;
import com.test.poemtree4.poem.PoemObject;
import com.test.poemtree4.poem.PoemRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


// https://spring.io/guides/gs/testing-web/
// https://www.baeldung.com/spring-boot-testing
/*
@TestPropertySource(
  locations = "classpath:application-test.properties")
*/


@SpringBootTest(
    //SpringBootTest.WebEnvironment.MOCK
)
@AutoConfigureMockMvc
public class APITest {
    
    @Autowired
    private PoemController poemController;

    @Autowired
    private PoemRepository poemRepository;

    @Test
    void controllerLoad() throws Exception{
        Assertions.assertThat(poemController).isNotNull();
        Assertions.assertThat(poemRepository).isNotNull();
    }

/*
    @Autowired
    private MockMvc mockMvc;

    MockMvcRequestBuilders mrb;
    MockMvcResultHandlers mrh;
    MockMvcResultMatchers mrm;

    @Test
    void getAllFolderListTest() throws Exception{
        mockMvc
            .perform(mrb.get("/api/get/allfolder"))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }

    @Test
    void getAllContentsInFolderTest() throws Exception{
        mockMvc
            .perform(mrb.get("/api/get/contents/{tableid}", 6))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }

    @Test
    void renameFolderTest() throws Exception{
        mockMvc
            .perform(mrb.get("/api/rename/folder/{tableId}/{newName}", 6, "newName"))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }

    @Test
    void createNewFolderTest() throws Exception{
        
        mockMvc
            .perform(mrb.get("/api/create/folder/{folderName}", "testFolder"))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk())
            .andReturn();

    }

    @Test
    void createNewContentTest() throws Exception{

        mockMvc
            .perform(mrb.get("/api/create/content/{tableId}", 6))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());

        for(PoemObject p : poemRepository.findByIdW(6)){
            System.out.println(p.toString());
        }
    }

    @Test
    void getContentTest() throws Exception{
        mockMvc
            .perform(mrb.get("/api/get/content/{tableId}/{contentId}",6,"3126ce02-acf8-4b0b-b1c7-efe61e752f9f"))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }



    @Test
    void saveContentTest() throws Exception{
        
        String poemContent ="{\"contentId\" : \"3126ce02-acf8-4b0b-b1c7-efe61e752f9f\", " +
                            "\"title\" : \"title\", " + 
                            "\"body\" : \"body\", " + 
                            "\"date\" : \"date\"}";

        RequestBuilder request = mrb.post("/api/save/content")
                                        .content(poemContent)
                                        .contentType("application/json");

        mockMvc
            .perform(request)
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }

    @Test
    void backUpContentTest() throws Exception{

        int tableId = 1;
        String poemContent ="{\"contentId\" : \"3126ce02-acf8-4b0b-b1c7-efe61e752f9f\", " +
                            "\"title\" : \"title1\", " + 
                            "\"body\" : \"body1\", " + 
                            "\"date\" : \"date1\"}";

        RequestBuilder request = mrb.post("/api/backup/content/{tableId}", 6)
                                        .content(poemContent)
                                        .contentType("application/json");

        mockMvc
            .perform(request)
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());

    }

    @Test
    void eraseBackUpTest() throws Exception{

        mockMvc
            .perform(mrb.get("/api/delete/backup/{tableId}/{date}", 6,"date1"))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }

    @Test
    void deleteContentTest() throws Exception{

        mockMvc
            .perform(mrb.get("/api/delete/content/{tableId}/{contentId}", 6, "3126ce02-acf8-4b0b-b1c7-efe61e752f9f"))
            .andDo(mrh.print())
            .andExpect(mrm.redirectedUrl("/"));

    }

    @Test
    void deleteFolderTest() throws Exception{

        mockMvc
            .perform(mrb.get("/api/delete/folder/{tableId}", 6))
            .andDo(mrh.print())
            .andExpect(mrm.status().isOk());
    }

*/
}
