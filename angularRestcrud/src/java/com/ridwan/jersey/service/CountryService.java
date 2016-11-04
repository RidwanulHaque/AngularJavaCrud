/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridwan.jersey.service;

import com.ridwan.jersey.bean.Country;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author HaqueFamily
 */
public class CountryService {

  

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public CountryService() {
        super();

       
    }

//    public List<Country> getAllCountries() {
//        List<Country> countries = new ArrayList<Country>(countryIdMap.values());
//        return countries;
//    }
    public List<Country> getAllRecords() {
        List<Country> list = new ArrayList<Country>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from country");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Country country = new Country();
                country.setId(rs.getInt("id"));
                country.setCountryName(rs.getString("name"));
                country.setPopulation(rs.getLong("population"));
                list.add(country);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

   

    public Country addCountry(Country country) {

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("insert into country (name,population)values(?,?)");
            ps.setString(1, country.getCountryName());
            ps.setLong(2, country.getPopulation());
           
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return country;

    }

    public Country updateCountry(Country country) {
        if (country.getId() <= 0) {
            return null;
        }

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("update country set name=?, population=? where id=?");
            ps.setString(1, country.getCountryName());
            ps.setLong(2, country.getPopulation());
            ps.setInt(3, country.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return country;

    }

    public void deleteCountry(int id) {


        try {
            Connection con= getConnection();
            PreparedStatement ps = con.prepareStatement("delete from country where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

   

    
}
