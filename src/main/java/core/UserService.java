package core;

import java.util.List;

public class UserService {

    Database db;

    static {
      // db = // connect to database
    }


    public List<Object> getUsersWithName(String name) {
        db.Query(SomeSelect);
    }
    public List<Object> getUsersWithSecondName(String secondName) {
        db.Query(SomeSelect);
    }
}
