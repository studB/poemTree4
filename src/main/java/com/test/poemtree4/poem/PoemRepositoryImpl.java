package com.test.poemtree4.poem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class PoemRepositoryImpl implements PoemRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PoemRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    
    // AdminTable

    @Override
    public int insertA(String tableName) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("ADMINTABLE").usingGeneratedKeyColumns("TABLEID");

        Map<String, String> param = new HashMap<String, String>();
        param.put("TABLENAME", tableName);
        int key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(param)).intValue();
        
        return key;
    }

    @Override
    public void deleteA(int tableId) {
        jdbcTemplate.update("DELETE ADMINTABLE WHERE TABLEID = ?", tableId);
    }

    @Override
    public List<FolderObject> findAllA() {
        List<FolderObject> result = jdbcTemplate.query("SELECT * FROM ADMINTABLE", folderObjectRowMapper());
        return result;
    }

    @Override
    public void updateNameA(int tableId, String newTableName) {
        jdbcTemplate.update("UPDATE ADMINTABLE SET TABLENAME = ? WHERE TABLEID = ?", newTableName, tableId);
    }

    private RowMapper<FolderObject> folderObjectRowMapper(){
        return new RowMapper<FolderObject>(){
            @Override
            public FolderObject mapRow(ResultSet rs, int rowNum) throws SQLException{
                FolderObject folderObject = new FolderObject();
                folderObject.setTableId(rs.getInt("tableid"));
                folderObject.setTableName(rs.getString("tablename"));
                return folderObject;
            }
        };
    }




    //WorkingTable

    @Override
    public void insertW(int tableId, String contentId) {
        jdbcTemplate.update("INSERT INTO WORKINGTABLE(TABLEID, CONTENTID) VALUES(?,?)", tableId, contentId);
    }

    @Override
    public void deleteFolderW(int tableId) {
        jdbcTemplate.update("DELETE WORKINGTABLE WHERE TABLEID = ?", tableId);
    }

    @Override
    public void deleteContentW(String contentId) {
        jdbcTemplate.update("DELETE WORKINGTABLE WHERE CONTENTID = ?", contentId);
    }

    @Override
    public List<PoemObject> findByIdW(int tableId) {
        List<PoemObject> result = jdbcTemplate.query("SELECT * FROM WORKINGTABLE WHERE TABLEID = ?", poemObjectRowMapper(), tableId);
        return result;
    }

    @Override
    public Optional<PoemObject> findContentByContentIdW(String contentId) {
        List<PoemObject> result = jdbcTemplate.query("SELECT * FROM WORKINGTABLE WHERE CONTENTID = ?", poemObjectRowMapper(), contentId);
        return result.stream().findAny();
    }


    @Override
    public void updateAnyW(PoemObject newObject) {
        jdbcTemplate.update("UPDATE WORKINGTABLE SET (TITLE, BODY, DATE) = (?,?,?) where CONTENTID = ?", 
            newObject.getTitle(), newObject.getBody(), newObject.getDate(), newObject.getContentId());

    }


    private RowMapper<PoemObject> poemObjectRowMapper(){
        return new RowMapper<PoemObject>() {
            @Override
            public PoemObject mapRow(ResultSet rs, int rowNum) throws SQLException {
                PoemObject poemObject = new PoemObject();
                poemObject.setContentId(rs.getString("CONTENTID"));
                poemObject.setTitle(rs.getString("TITLE"));
                poemObject.setBody(rs.getString("BODY"));
                poemObject.setDate(rs.getString("DATE"));
                return poemObject;
            }
        };
    }


    // FolderTable 

    @Override
    public void createTableF(int tableId) {
        String genName = "table" + tableId;
        String sql = "CREATE TABLE " + genName + " (" +
                        "CONTENTID VARCHAR(255), " + 
                        "TITLE VARCHAR(255), " + 
                        "BODY TEXT, " + 
                        "DATE VARCHAR(255), " + 
                        "FOREIGN KEY(CONTENTID) REFERENCES WORKINGTABLE(CONTENTID) " + 
                        ")";
        jdbcTemplate.execute(sql);

    }

    @Override
    public void deleteTableF(int tableId) {
        String genName = "table" + tableId;
        String sql = "DROP TABLE " + genName;
        jdbcTemplate.execute(sql);

    }

    @Override
    public void insertF(int tableId, PoemObject poemObject) {
        String genName = "table" + tableId;
        String sql = "INSERT INTO " + genName + " VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, poemObject.getContentId(), poemObject.getTitle(), 
                                poemObject.getBody(), poemObject.getDate());
    }

    @Override
    public void deleteByContentIdF(int tableId, String contentId) {
        String genName = "table" + tableId;
        String sql = "DELETE " + genName + " WHERE CONTENTID = ?";
        jdbcTemplate.update(sql, contentId);
    }

    @Override
    public void eraseF(int tableId, String date) {
        String genName = "table" + tableId;
        String sql = "DELETE " + genName + " WHERE DATE = ?";
        jdbcTemplate.update(sql, date);
    }

    @Override
    public List<PoemObject> findByContentIdF(int tableId, String contentId) {
        String genName = "table" + tableId;
        String sql = "SELECT * FROM " + genName + " WHERE CONTENTID = ? ";
        List<PoemObject> result = jdbcTemplate.query(sql, poemObjectRowMapper(),contentId);
        return result;
    }
    

    
}
