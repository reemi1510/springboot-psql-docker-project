package com.project.userprofile.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "appointments")
public class Appointment {

    @Id
    @SequenceGenerator(sequenceName = "public.appointment_id_seq", name = "appointmentIdSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentIdSequence")
    private long id;

    @Column(name = "role_id")
    private long roleId;

    @Column(name = "role_description")
    @Size(max = 255)
    private String roleDesc;

    @Column(name = "organisation_name")
    @Size(max = 255)
    private String orgName;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private User user;

    public Appointment(long roleId, String roleDesc, String orgName, User user) {
        this.roleId = roleId;
        this.roleDesc = roleDesc;
        this.orgName = orgName;
        this.user = user;
    }
}