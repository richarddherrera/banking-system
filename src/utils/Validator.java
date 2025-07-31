package Utils;

import exceptions.MainMenuException;

public class Validator {

    public int validatorMainMenu(String option) throws MainMenuException {

        if (option.isBlank()){
            throw new MainMenuException("\n ⚠ The option cannot be empty or null! \n");
        }

        if (!option.matches("^\\d+$")){
            throw new MainMenuException("\n ⚠ The option cannot contain letters or symbols! (Choose a number from the menu) \n") ;
        }

        int optionInt = Integer.parseInt(option);


        if (optionInt < 0 || optionInt > 6){
            throw new MainMenuException("\n ⚠ The option must be between 0 and 6! \n");
        }

        return optionInt;
    }
}
