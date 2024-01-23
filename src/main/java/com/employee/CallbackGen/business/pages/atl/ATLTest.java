package com.employee.CallbackGen.business.pages.atl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ATLTest {
    @NonNull ATLPage atlPage;

    public void start(String phoneNumber) {
        atlPage.openAddress()
                .callbackMenuClick()
                .callbackButtonClick()
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
