package com.employee.CallbackGen.business.pages.iStore;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IStoreTest {
    @NonNull IStorePage iStorePage;

    public void start(String phoneNumber){
        iStorePage.openAddress()
                .callbackButtonClick()
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
