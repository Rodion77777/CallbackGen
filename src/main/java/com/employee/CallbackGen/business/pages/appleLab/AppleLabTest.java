package com.employee.CallbackGen.business.pages.appleLab;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AppleLabTest {
    @NonNull AppleLabPage appleLabPage;

    public void start(String firstname, String phoneNumber){
        appleLabPage.openAddress()
                .callbackButtonClick()
                .fieldFirstnameSendKeys(firstname)
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
