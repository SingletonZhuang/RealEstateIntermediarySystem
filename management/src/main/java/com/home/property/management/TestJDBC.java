/**
 * 
 */
package com.home.property.management;


import java.sql.*;

 

public class TestJDBC {

public static void main(String[] args) {

     String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎

     String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=HouseProperty";//注意更换自己的数据库端口和名称

     String Name="root";//填写登录名

     String Pwd="123456";//密码

   try{

   Class.forName(driverName);

   Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);

   System.out.println("数据库连接成功");

   } catch(Exception e){

      e.printStackTrace();

      System.out.println("连接失败");

      }

   }

}
