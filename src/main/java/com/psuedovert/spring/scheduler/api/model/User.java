package com.psuedovert.spring.scheduler.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
