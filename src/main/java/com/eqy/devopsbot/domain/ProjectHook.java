package com.eqy.devopsbot.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-05-05 16:18
 */
@Data
@Entity
@Table(name = "t_project_hook")
public class ProjectHook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int projectId;

    private int hookId;
}
