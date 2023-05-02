package edu.skypro.homework.service;

import edu.skypro.homework.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isAlpha;
@Service
public class ValidatorServiceImpl implements ValidatorService{

    @Override
    public void checkInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}
