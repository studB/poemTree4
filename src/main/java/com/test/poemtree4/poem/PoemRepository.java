package com.test.poemtree4.poem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

// This is a wrong code, because business logic and database task is not divided...
// On Small project like poemtree test, its composition is so intutive,
// but it absoultely to be a bad as project size is more bigger ...


public interface PoemRepository {
    

    // Three Table

    // AdminTable : pre-exist, one
    //  tableId, tableName
    // create table admintable (tableid int primary key AUTO_INCREMENT not null, tablename varchar(255));

    // WorkingTable : pre-exist, one
    //  tableId, poemObject
    // create table workingtable ( tableid int not null, contentid varchar(255) primary key, title varchar(255), body text, date varchar(255), foreign key(tableid) references admintable(tableid) );

    // FolderTable : non-exist, many as folder number
    //  poemObject


    // AdminTable operation

    //
    int insertA(String tableName);

    //
    void deleteA(int tableId);

    //
    List<FolderObject> findAllA();

    //
    void updateNameA(int tableId, String newTableName);


    // WorkingTable operation 

    // vain record
    void insertW(int tableId, String contentId);

    //
    void deleteFolderW(int tableId);

    //
    void deleteContentW(String contentId);

    // 
    List<PoemObject> findByIdW(int tableId);

    //
    Optional<PoemObject> findContentByContentIdW(String contentId);

    //
    void updateAnyW(PoemObject newObject);



    // FolderTable
    
    // @return tableId
    // tableName is table_{tableId}
    void createTableF(int tableId);

    // void deleteTable(int tableId);
    void deleteTableF(int tableId);

    // 
    void insertF(int tableId, PoemObject poemObject);

    //
    void deleteByContentIdF(int tableId, String contentId);

    //
    void eraseF(int tableId, String date);

    // 
    List<PoemObject> findByContentIdF(int tableId, String contentId);


}
