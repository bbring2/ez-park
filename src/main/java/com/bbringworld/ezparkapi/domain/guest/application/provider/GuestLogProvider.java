package com.bbringworld.ezparkapi.domain.guest.application.provider;

import com.bbringworld.ezparkapi.domain.guest.dao.entity.GuestLog;

public interface GuestLogProvider {

    void in(String carNumber);

    void out(String carNumber);

    void checkOut(GuestLog guestLog);

}
