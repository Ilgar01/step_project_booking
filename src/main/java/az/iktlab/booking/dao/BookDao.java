package az.iktlab.booking.dao;

import az.iktlab.create.db.ConnPostgresSQL;
import az.iktlab.entity.Flight;
import az.iktlab.entity.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDao {
    public ResultSet search(Flight flight, int numberPeople)
    {  ResultSet resultset=null;
       try(Connection connection = ConnPostgresSQL.getInstance("book").getConnection()) {
           String searchQuery="select * from flight where destination like '%"+
                   flight.getDestination()+"%' and local_date='"+flight.getLocalDate()+"' " +
                   "and seats-full_seats>="+numberPeople+" ";
           Statement statement = connection.createStatement();
          resultset= statement.executeQuery(searchQuery);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return resultset;
    }
    public int[] book(Person[] persons, int flightId){
        int i=0;
        int[] booksId = new int[persons.length];
        try(Connection connection = ConnPostgresSQL.getInstance("book").getConnection()) {
            for (Person p:persons) {
                String insertPerson="insert into person(person_name, person_surname)" +
                        " values('"+p.getPersonName()+"','"+p.getPersonSurname()+"') returning person_id";
                String addFullSeats = "update flight\n" +
                        "set full_seats = full_seats+1 where flight_id='"+flightId+"'";
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(insertPerson);
                rs.next();
                int personId = rs.getInt("person_id");
                statement.executeUpdate(addFullSeats);
                String insertBook= "insert into book(person_id,flight_id) " +
                        "values('"+personId+"','"+flightId+"') returning book_id";
                ResultSet rs2 = statement.executeQuery(insertBook);
                rs2.next();
                booksId[i]=rs2.getInt("book_id");
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksId;
    }
    public int cancel(int bookId){
        int response =0;
        ResultSet rs;
        try(Connection connection = ConnPostgresSQL.getInstance("book").getConnection()){
            String deleteBook= "delete from book where book_id='"+bookId+"' returning person_id, flight_id";
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(deleteBook);
            rs.next();
            int deletedId = rs.getInt("person_id");
            int flightId= rs.getInt("flight_id");
            String deletePerson = "delete from person where person_id='"+deletedId+"'";
            statement.executeUpdate(deletePerson);
            String fullSeats = "Update flight set full_seats = full_seats-1 where flight_id ='"+flightId+"'";
            response = statement.executeUpdate(fullSeats);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }
    public ResultSet myFlights(Person person){
        ResultSet rs=null;
        try(Connection connection = ConnPostgresSQL.getInstance("book").getConnection()) {
            String selectQuery = "  select * from person pn join book bk on pn.person_id = bk.person_id join\n" +
                    "  flight ft on bk.flight_id=ft.flight_id where " +
                    "pn.person_name ='"+person.getPersonName()+"' and " +
                    "pn.person_surname='"+person.getPersonSurname()+"'";
            Statement statement = connection.createStatement();
           rs= statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
