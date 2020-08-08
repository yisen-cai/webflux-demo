package com.glancebar.webfluxtutorial.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Role implements Serializable {

    @Id
    private Long id;

    private String roleName = null;

    private String note = null;

}
