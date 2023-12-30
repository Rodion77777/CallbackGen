package com.employee.CallbackGen.business.pages.volia;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VoliaTest {
    @NonNull VoliaPage voliaPage;

    public void start(String firstname, String phoneNumber){
        voliaPage.openAddress()
                .callbackButtonClick()
                .fieldFirstnameSendKeys(firstname)
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
