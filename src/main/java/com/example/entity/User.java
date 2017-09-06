package com.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "姓名不能为空")
  @Size(min = 2, max = 20)
  @Column(length = 20, nullable = false, unique = true)
  private String userName;

  @NotNull
  @Min(18)
  @Column(length = 3, nullable = false, unique = true)
  private Integer age;

  @NotNull
  @Column(length = 20, nullable = false)
  private String passWord;

  @Column(length = 30, unique = true)
  private String email;

  @Column(length = 30, unique = true)
  private String nickName;

  @Column(nullable = false)
  private Date regTime;

}
