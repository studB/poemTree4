package com.test.poemtree4.poem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.experimental.PackagePrivate;

@Controller
public class PoemController{

    private PoemRepository poemRepository;

    @Autowired
    public PoemController(PoemRepository poemRepository){
        this.poemRepository = poemRepository;
    }

    @RequestMapping(value = "/")
    public String mainRendering(){
        return "note";
    }

    // Poem Logic


    @RequestMapping(value = "/api/get/allfolder")
    @ResponseBody
    public List<FolderObject> getAllFolderList(){
        return poemRepository.findAllA();
    }


    // Folder open - test ok
    // Get Contents list in clicked folder
    @RequestMapping( value = "/api/get/contents/{tableId}")
    @ResponseBody
    public List<PoemObject> getAllContentsInFolder(@PathVariable(required = true) int tableId){
       return poemRepository.findByIdW(tableId);
    }


    // Create Folder - test ok
    // Make folder table and insert a folder information into admintable
    @RequestMapping( value = "/api/create/folder/{folderName}")
    @ResponseBody
    public int createNewFolder(@PathVariable(required = true) String folderName){

        int tableId = poemRepository.insertA(folderName);
        poemRepository.createTableF(tableId);

        return tableId;
    }

    // Rename Folder
    @RequestMapping( value = "/api/rename/folder/{tableId}/{newName}")
    @ResponseBody
    public String renameFolder(@PathVariable(required = true) int tableId, @PathVariable(required = true) String newName){
        poemRepository.updateNameA(tableId, newName);

        return newName;
    }


    // Click contents - test ok
    // Get Contents, worked one and backup 
    @RequestMapping( value = "/api/get/content/{tableId}/{contentId}")
    @ResponseBody
    public Map<String, Object> getContent(@PathVariable(required = true) int tableId, @PathVariable(required = true) String contentId){
        
        Map<String, Object> returnSet = new HashMap<String, Object>();
        returnSet.put("work", poemRepository.findContentByContentIdW(contentId));
        returnSet.put("backup", poemRepository.findByContentIdF(tableId, contentId));

        return returnSet;
    } 


    // create new content - test ok
    // start to the work
    @RequestMapping( value = "/api/create/content/{tableId}")
    @ResponseBody
    public String createNewContent(@PathVariable(required = true) int tableId){

        String contentId = UUID.randomUUID().toString();

        PoemObject poemObject = new PoemObject();
        poemObject.setContentId(contentId);
        
        poemRepository.insertW(tableId, contentId);
        
        return contentId;
    }


    // Save worked Contents - test ok
    // Update Worked contents
    @PostMapping( value = "/api/save/content")
    @ResponseBody
    public String saveContent(@RequestBody PoemObject poemObject){
        poemRepository.updateAnyW(poemObject);
        return "done";
    }


    // Publish Worked Content into backup house - test ok
    // insert data and get backup contens again
    @PostMapping( value = "/api/backup/content/{tableId}")
    @ResponseBody
    public String backUpContent(@PathVariable(required = true) int tableId, @RequestBody PoemObject poemObject){
        
        poemRepository.insertF(tableId, poemObject);

        return "done";
    }


    // Erase backup one - test ok
    // erase content
    @RequestMapping( value = "/api/delete/backup/{tableId}/{date}")
    @ResponseBody
    public String eraseBackUp(@PathVariable(required = true) int tableId, @PathVariable(required = true) String date){

        poemRepository.eraseF(tableId, date);

        return "done";
    }

    // Delete contents test ok
    // erase content all that conttains worked and backup, and erase content info from all table
    @RequestMapping( value = "/api/delete/content/{tableId}/{contentId}")
    public String deleteContent(@PathVariable(required = true) int tableId, @PathVariable(required = true) String contentId){

        // delete backup
        poemRepository.deleteByContentIdF(tableId, contentId);


        // delete from workingtable
        poemRepository.deleteContentW(contentId);

        return "redirect:/";
    }
    
    
    // Delete Folder
    // delete folder information and related table, all contents of folder is also deleted. 
    @RequestMapping( value = "/api/delete/folder/{tableId}")
    @ResponseBody
    public String deleteFolder(@PathVariable(required = true) int tableId){

        //delete folder table
        poemRepository.deleteTableF(tableId);

        //delete from workingtable
        poemRepository.deleteFolderW(tableId);

        //delete from admintable
        poemRepository.deleteA(tableId);

        return "done";
    }



}