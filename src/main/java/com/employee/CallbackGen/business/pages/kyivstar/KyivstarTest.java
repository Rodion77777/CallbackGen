package com.employee.CallbackGen.business.pages.kyivstar;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KyivstarTest {
    @NonNull KyivstarPage kyivstarPage;

    public void start(String city, String phoneNumber){
        kyivstarPage.openAddress()
                .callbackButtonClick()
                .fieldCitySendKeys(city)
                .fieldPhoneNumberSendKeys(phoneNumber)
                .submitButtonClick();
    }
}
