package com.employee.CallbackGen.business.pages.aService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AServiceTest {
    @NonNull AServicePage aServicePage;

    public void start(String phoneNumber){
        aServicePage.openAddress()
                .callbackButtonClick()
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
