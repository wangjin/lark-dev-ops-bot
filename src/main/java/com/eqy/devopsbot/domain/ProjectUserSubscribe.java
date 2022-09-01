package com.eqy.devopsbot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2022-04-29 22:10
 */
@Data
@Entity
@Table(name = "t_project_user_subscribe")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUserSubscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String openId;

    private int projectId;

}
