package com.xcy.local.dao;

import com.xcy.local.pojo.localCities;

import java.util.List;

public interface localCitiesMapper {

    List<localCities> selectAllProvince();

    List<localCities> selectAllCity(int id);

    List<localCities> selectAllCounty(int id);
}
