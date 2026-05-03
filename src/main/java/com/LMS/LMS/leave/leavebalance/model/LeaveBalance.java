package com.LMS.LMS.leavebalance.model;

import com.LMS.LMS.employee.model.EmployeeInformation;
import com.LMS.LMS.leaveinformation.model.LeaveInformation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private int totalLeave;
    private int remaining;
    private  String year;
    private boolean presentStatus;
}
