package az.iktlab.create.service;

import az.iktlab.create.dao.CrudOperationsDao;

public class CrudOperationsService {

    private static final CrudOperationsDao create = new CrudOperationsDao();

    public static void run(){
        create.createDb();
        create.createTable();
        create.insertPerson();
        create.insertFlight();
    }
}
