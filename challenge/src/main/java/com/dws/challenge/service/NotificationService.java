package com.dws.challenge.service;

import com.dws.challenge.domain.Accounts;

public interface NotificationService {

  void notifyAboutTransfer(Accounts account, String transferDescription);
}
