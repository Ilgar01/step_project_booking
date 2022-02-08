package az.iktlab.create.dao;

import az.iktlab.create.db.ConnPostgresSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOperationsDao {

    public void createDb(){
        try(Connection connection = ConnPostgresSQL.getInstance("").getConnection()){
            String sql = "create database book";
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void createTable(){
        try(Connection connection = ConnPostgresSQL.getInstance("book").getConnection()){
            String sql1 = "CREATE TABLE person(person_id serial primary key,person_name varchar(15) not null,person_surname varchar(20) not null )";
            String sql2 = "CREATE TABLE flight(flight_id serial primary key,local_date date,local_time time,destination varchar(30),seats int,full_seats int )";
            String sql3 = "CREATE TABLE book(book_id serial primary key,person_id int, flight_id int, " +
                    "CONSTRAINT fk_person foreign key(person_id) references person(person_id)," +
                    "CONSTRAINT fk_flight foreign key(flight_id) references flight(flight_id))";
            Statement statement = connection.createStatement();
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void insertPerson(){
        try(Connection conn = ConnPostgresSQL.getInstance("book").getConnection()){
            String sql1="insert into person(person_name,person_surname) values('Shahrza','Gahramanov')";
            String sql2="insert into person(person_name,person_surname) values('Malik','Nuriyev')";
            String sql3="insert into person(person_name,person_surname) values('Seymur','Mikayilov')";
            Statement statement = conn.createStatement();
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void insertFlight(){
        try(Connection conn = ConnPostgresSQL.getInstance("book").getConnection()){
            String sql1="insert into flight(destination,local_date,local_time,seats,full_seats) values('Baku,Azerbaijan','2022-02-12','20:00:00',30,0)";
            String sql2="insert into flight(destination,local_date,local_time,seats,full_seats) values('Paris,France','2022-02-11','15:30:00',25,0)";
            String sql3="insert into flight(destination,local_date,local_time,seats,full_seats) values('Moscow,Russia','2022-02-13','08:45:00',35,0)";
            String sql4="insert into flight(destination,local_date,local_time,seats,full_seats) values('Istanbul,Turkey','2022-02-10','21:15:00',40,0)";
            String sql5="insert into flight(destination,local_date,local_time,seats,full_seats) values('Tehran,Iran','2022-02-25','14:00:00',20,0)";
            String sql6="insert into flight(destination,local_date,local_time,seats,full_seats) values('Tbilisi,Georgia','2022-02-13','15:50:00',15,0)";
            Statement statement = conn.createStatement();
            statement.execute(sql1);
            statement.execute(sql2);
            statement.execute(sql3);
            statement.execute(sql4);
            statement.execute(sql5);
            statement.execute(sql6);
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
