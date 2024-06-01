package com.group.commute_system.domain.employee;

import com.group.commute_system.domain.team.Team;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.type.NumericBooleanConverter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Convert(converter = NumericBooleanConverter.class)
    private boolean isManager;
    @Column(nullable = false)
    private LocalDate workStartDate;
    @Column(nullable = false)
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @OneToMany(mappedBy = "employee")
    private List<WorkLog> workLogList = new ArrayList<>();
    public Employee(String name, boolean isManager, LocalDate workStartDate, LocalDate birthday, Team team) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.isManager = isManager;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
        this.team = team;
    }
}
