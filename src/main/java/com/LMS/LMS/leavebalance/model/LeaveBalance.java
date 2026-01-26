package com.LMS.LMS.leavebalance.model;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leave.model.LeaveInformation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "leave_balance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeInformation employee;

    // Many balances belong to one leave type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveInformation leaveType;

    private int totalAllowed;
    private int used;
    private int remaining;
}
