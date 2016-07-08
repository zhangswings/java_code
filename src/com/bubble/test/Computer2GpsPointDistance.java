package com.bubble.test;

/**
 * Created by Administrator on 2016/7/8.
 * Android GPS坐标距离计算
 */
public class Computer2GpsPointDistance {
//    LatLng latLng1 = new LatLng(37.014232, 117.565597);
//    LatLng latLng2 = new LatLng(31.137012, 121.345326);
//    double mDistance = DistanceUtil.getDistance(latLng1, latLng2);
//    Log.e(TAG, "onCreate: 百度-距离：" + mDistance + "米");
//
//    Location location1 = new Location("l1");
//    location1.setLatitude(37.014232);
//    location1.setLongitude(117.565597);
//    Location location2 = new Location("l2");
//    location2.setLatitude(31.137012);
//    location2.setLongitude(121.345326);
//
//    07-08 10:17:47.678 27561-27561/baidumapsdk.demo E/MainActivity: onCreate: 百度-距离：740275.3203764297米
//    07-08 10:17:47.678 27561-27561/baidumapsdk.demo E/MainActivity: onCreate: 谷歌-距离：740275.3203764297米



    /**
     * 计算两点坐标距离
     *
     * @return 返回单位为米
     * @deprecated 直接使用系统的 Location.distanceBetween
     */
//    @Deprecated
//    public static double distanceOfTwoPoint(final double lon1, final double lat1, final double lon2, final double lat2)
//    {
//        final double theta = lon1 - lon2;
//        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
//                * Math.cos(deg2rad(theta));
//        dist = Math.acos(dist);
//        dist = rad2deg(dist);
//        final double miles = dist * 60 * 1.1515;
//        //英里转换米
//        return miles * 1609.344;
//    }

    /**
     * @deprecated 系统有自带的 Location.distanceTo
     */
//    @Deprecated
//    public static double distanceOfTwoPoint(final Location mOriginalLocation, final Location mCurrentLocation)
//    {
//        return distanceOfTwoPoint(//
//                mOriginalLocation.getLongitude(),//
//                mOriginalLocation.getLatitude(), //
//                mCurrentLocation.getLongitude(), //
//                mCurrentLocation.getLatitude());
//    }
    /**
     * 将弧度转换为角度
     */
    public static double rad2deg(final double radian)
    {
        return radian * 180 / Math.PI;
    }

}
