package com.project.userprofile.service.impl;

import com.project.userprofile.controller.request.AppointmentCreationRequest;
import com.project.userprofile.controller.request.UserCreationRequest;
import com.project.userprofile.controller.response.UserResponse;
import com.project.userprofile.domain.Appointment;
import com.project.userprofile.domain.User;
import com.project.userprofile.persistence.AppointmentRepository;
import com.project.userprofile.persistence.UserRepository;
import com.project.userprofile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public UserResponse createUserFrom(UserCreationRequest request) {

        User newUser = new User(request.getEmail(), request.getFirstName(), request.getLastName());

        User user = userRepository.save(newUser);

        addAppointmentsToUser(request.getAppointments(), user);

        return new UserResponse(user);
    }

    private void addAppointmentsToUser(List<AppointmentCreationRequest> appointmentCreationRequests, User user) {

        if (appointmentCreationRequests != null) {
            appointmentCreationRequests.forEach(appointmentInfo -> {
                Appointment newAppointment = new Appointment();
                newAppointment.setRoleId(appointmentInfo.getRoleId());
                newAppointment.setRoleDesc(appointmentInfo.getRoleDesc());
                newAppointment.setOrgName(appointmentInfo.getOrgName());
                newAppointment.setUser(user);

                appointmentRepository.save(newAppointment);

                user.addAppointment(newAppointment);
            });
        }
    }
}
