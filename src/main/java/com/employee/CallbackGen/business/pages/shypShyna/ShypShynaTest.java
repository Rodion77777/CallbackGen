package com.employee.CallbackGen.business.pages.shypShyna;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShypShynaTest {
    @NonNull ShypShynaPage shypShynaPage;

    public void start(String firstname, String phoneNumber) {
        shypShynaPage.openAddress()
                .callbackButtonClick()
                .fieldFirstnameSendKeys(firstname)
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitCheckBoxRequired()
                .submitButtonClick();
    }
}
