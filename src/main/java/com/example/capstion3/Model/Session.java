package com.example.capstion3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date not null")
   private LocalDateTime session_date;
    @Positive(message = "enter valid value for duration minutes")
    @Column(columnDefinition = "int not null")
    private int  duration_minutes ;
    @Column(columnDefinition = "varchar(200) not null")
    @NotEmpty(message = "notes can not be empty")
    private String notes;

}
