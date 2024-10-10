package com.foodbookingplatform.utils;

import ch.hsr.geohash.GeoHash;

public class GeoHashGeneration {

    public static void main(String[] args) {
        String currentLocation = getGeoHashCode(10.801815771214525, 106.6389862348937, 5);
        String nearby01 = getGeoHashCode(10.778832984795226, 10.778832984795226, 9);
        String nearby02 = getGeoHashCode(10.774485967233257, 106.70631832411459, 9);
        String nearby03 = getGeoHashCode(10.770634407168673, 106.68445659527843, 9);
        String nearby04 = getGeoHashCode(10.773197947031898, 106.70104999527857, 9);
        String nearby05 = getGeoHashCode(10.775029103562796, 106.68813411790194, 9);
        String nearby06 = getGeoHashCode(10.765077629783354, 106.65628038299691, 9);
        String nearby07 = getGeoHashCode(10.777679383156537, 106.70216663695903, 9);
        String nearby08 = getGeoHashCode(10.79013723312897, 106.70293408205124, 9);
        String nearby09 = getGeoHashCode(10.778259201078905, 106.70396399255701, 9);
        String nearby10 = getGeoHashCode(10.77383221225152, 106.70078825376534, 9);
        String nearby11 = getGeoHashCode(10.800190205392171, 106.7358976241099, 9);
        String nearby12 = getGeoHashCode(10.81290129289196, 106.73474480034143, 9);
        String nearby13 = getGeoHashCode(10.789192559519389, 106.68527342411488, 9);
        String nearby14 = getGeoHashCode(10.807955784181551, 106.65597108110464, 9);

        System.out.println("Current Location GeoHash: " + currentLocation);
        System.out.println("Nearby Location 1 GeoHash: " + nearby01);
        System.out.println("Nearby Location 2 GeoHash: " + nearby02);
        System.out.println("Nearby Location 2 GeoHash: " + nearby03);
        System.out.println("Nearby Location 2 GeoHash: " + nearby04);
        System.out.println("Nearby Location 2 GeoHash: " + nearby05);
        System.out.println("Nearby Location 2 GeoHash: " + nearby06);
        System.out.println("Nearby Location 2 GeoHash: " + nearby07);
        System.out.println("Nearby Location 2 GeoHash: " + nearby08);
        System.out.println("Nearby Location 2 GeoHash: " + nearby09);
        System.out.println("Nearby Location 2 GeoHash: " + nearby10);
        System.out.println("Nearby Location 2 GeoHash: " + nearby11);
        System.out.println("Nearby Location 2 GeoHash: " + nearby12);
        System.out.println("Nearby Location 2 GeoHash: " + nearby13);
        System.out.println("Nearby Location 2 GeoHash: " + nearby14);
    }

    public static String getGeoHashCode(double latitude, double longitude, int precision){
        GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longitude, precision);
        return geoHash.toBase32();
    }
}