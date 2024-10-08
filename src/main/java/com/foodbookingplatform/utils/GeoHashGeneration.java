package com.foodbookingplatform.utils;

import ch.hsr.geohash.GeoHash;

public class GeoHashGeneration {

    public static void main(String[] args) {
        String currentLocation = getGeoHashCode(10.801815771214525, 106.6389862348937, 5);
        String nearby01 = getGeoHashCode(10.802173, 106.638689, 9);
        String nearby02 = getGeoHashCode(10.801523726129737, 106.63929651670884, 9);

        System.out.println("Current Location GeoHash: " + currentLocation);
        System.out.println("Nearby Location 1 GeoHash: " + nearby01);
        System.out.println("Nearby Location 2 GeoHash: " + nearby02);
    }

    public static String getGeoHashCode(double latitude, double longitude, int precision){
        GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longitude, precision);
        return geoHash.toBase32();
    }
}