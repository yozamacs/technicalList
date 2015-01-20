package com.springapp.mvc;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistMapper {

    @Insert("create table if not exists checklist (name integer)")
    public void createTable();

    @Insert(
            "INSERT INTO checklist(itemcompleted,itemdescription,itemtitle) VALUES (#{itemCompleted},#{itemDescription},#{itemTitle})"
    )
    public void insert(Checklist checklist);

    @Select(
            "SELECT * FROM checklist"
    )
    @Results(value = {
            @Result(property="itemCompleted", column="itemcompleted"),
            @Result(property="itemDescription", column="itemdescription"),
            @Result(property="itemTitle", column="itemtitle")
    })
    public List<Checklist> selectAll();

}
