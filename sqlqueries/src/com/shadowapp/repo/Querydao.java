package com.shadowapp.repo;

import java.sql.*;
public class Querydao {
    static String jdbcUrl="jdbc:mysql://localhost:3306/ex?serverTimezone=UTC";
    static String jdbcUser="root";
    static String jdbcPassword="password";
    static String driver="com.mysql.cj.jdbc.Driver";

    public static void one(){
        try{
            Class.forName(driver).getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){
                String sql = "SELECT name, age FROM users WHERE age>18";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        String name = resultSet.getString(1);
                        int age=resultSet.getInt(2);
                       System.out.println(name+" age: "+age);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void two(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){
                String sql = "select name from users where name like '%s%'";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        String name = resultSet.getString(1);
                        System.out.println("Name contains 'S':"+name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void three(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql = "select users.id, users.name, age, jobs.name as job  from users join jobs on jobs.id=users.job and jobs.name='Java'";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int id = resultSet.getInt(1);
                        String name=resultSet.getString(2);
                        int age=resultSet.getInt(3);
                        String job=resultSet.getString(4);
                        System.out.println("id: "+id+" name: "+name+" age: "+age+" job:"+job);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void four(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql =" select count(*) as count from users join jobs on  users.job=jobs.id and jobs.name='php'";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int count = resultSet.getInt(1);
                        System.out.println("Count of people which have php: "+count);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

    }

    public static void five(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql =" select sum(age) as sum from users join jobs on  users.job=jobs.id and jobs.name='js'";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int sum = resultSet.getInt(1);
                        System.out.println("People's sum of age which have job JS: "+sum);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void six(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql ="select * from jobs group by name order by id desc";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int id=resultSet.getInt(1);
                        String name=resultSet.getString(2);
                        System.out.println(id+"-"+name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }



    public static void eight(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)){

                String sql ="select distinct name, count(name) as count from users group by name";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int count = resultSet.getInt(2);
                        String name=resultSet.getString(1);
                        System.out.println("Name "+name+" repeats "+count+" time(s)");
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }

    }

}
