package com.nminh123.martianrun.box2d;

import com.nminh123.martianrun.enums.UserDataType;

public abstract class UserData
{
    protected UserDataType userDataType;

    public UserData()
    {

    }

    public UserDataType getUserDataType()
    {
        return userDataType;
    }
}
