package com.group.commute_system.domain.employee;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String teamName;
    @Column(nullable = false)
    private boolean isManager;
    @Column(nullable = false)
    private LocalDate workStartDate;
    @Column(nullable = false)
    private LocalDate birthday;

    public Employee(String name, String teamName, boolean isManager, LocalDate workStartDate, LocalDate birthday) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.teamName = teamName;
        this.isManager = isManager;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
    }

}
