package com.employee.CallbackGen.business.pages.dimAKB;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DimAKBTest {
    @NonNull DimAKBPage dimAKBPage;

    public void start(String firstName, String phoneNumber) {
        dimAKBPage.openAddress()
                .callbackButtonClick()
                .fieldFirstnameSendKeys(firstName)
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
