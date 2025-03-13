package com.javarush.kozlov.commands;

import com.javarush.kozlov.entity.Result;

public interface Action {
    Result execute(String[] parameters);

}
