package support.context;

import support.ui_dto.User;

public class CredentialManager {
    //TODO create enum for credentials and mongodb ( or any other localdb) for saving them
    public User getCredentials(String credentials){
        if(credentials.equals("standard")){
            return new User("test.acc.wsr1@gmail.com", "TestingAccount1");
        }


        return null;
    }
}
