package com.workspacesharing.service;

import com.workspacesharing.model.Booking;
import com.workspacesharing.model.User;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    void addBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteById(Long id);
    List<Booking> findAll();
    Optional<Booking> findById(Long id);
    List<Booking> findByUser(User user);
}
