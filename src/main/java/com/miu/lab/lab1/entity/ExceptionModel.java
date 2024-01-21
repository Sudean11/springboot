package com.miu.lab.lab1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.intellij.lang.annotations.Identifier;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Transaction_Id;

    LocalDate Date;
    LocalTime Time;
    String Principle;
    String Operation;
    String Exception;
    String Type;
}
